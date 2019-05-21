package com.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-20 17:17
 * @Modified By:
 */
public interface MyMapper<T> extends MySqlMapper<T>, Mapper<T> {

}
