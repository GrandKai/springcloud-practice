import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-13 14:14
 * @Modified By:
 */
public class ThreadLocalRandomTest {

  public static void main(String[] args) {
    int a = ThreadLocalRandom.current().nextInt(3000);

    try {
      Thread.sleep(a);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(a);
  }

}
