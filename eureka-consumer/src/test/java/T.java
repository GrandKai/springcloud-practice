import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-09 16:16
 * @Modified By:
 */
public class T {

  public static void main(String[] args) {
    System.out.println(String.format("当前节点：serviceId: %s, instanceId: %s  %d", "a", "b", 1));
  }


  public RestTemplateCustomizer restTemplateCustomizer(
      final LoadBalancerInterceptor loadBalancerInterceptor) {


    return new RestTemplateCustomizer() {
      @Override
      public void customize(RestTemplate restTemplate) {
        List<ClientHttpRequestInterceptor> list = new ArrayList<>(restTemplate.getInterceptors());
        list.add(loadBalancerInterceptor);

        restTemplate.setInterceptors(list);
      }
    };
    /*
    return restTemplate -> {
      List<ClientHttpRequestInterceptor> list = new ArrayList<>(
          restTemplate.getInterceptors());
      list.add(loadBalancerInterceptor);
      restTemplate.setInterceptors(list);
    };*/

  }


  private List<RestTemplate> restTemplates = Collections.emptyList();

  @Bean
  public SmartInitializingSingleton loadBalancedRestTemplateInitializerDeprecated(final ObjectProvider<List<RestTemplateCustomizer>> restTemplateCustomizers) {

    return new SmartInitializingSingleton() {
      @Override
      public void afterSingletonsInstantiated() {

        List<RestTemplateCustomizer> customizers = restTemplateCustomizers.getIfAvailable();
        for (RestTemplate restTemplate : restTemplates) {
          for (RestTemplateCustomizer customizer : customizers) {

            customizer.customize(restTemplate);
          }

        }
      }
    };

    /*
    return () -> restTemplateCustomizers.ifAvailable(customizers -> {
			for (RestTemplate restTemplate : LoadBalancerAutoConfiguration.this.restTemplates) {
				for (RestTemplateCustomizer customizer : customizers) {
					customizer.customize(restTemplate);
				}
			}
    });*/
  }
}
