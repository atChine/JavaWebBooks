package com.ataj.test;

import com.ataj.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @ClassName: JDBCUtilsTest
 * @Description: TODO
 * @Author: 高举
 * @Date: 2021/11/21 16:42
 * @URL：https://github.com/GaoHaiNB
 */
public class JDBCUtilsTest {
    @Test
    public void testJDBCUtils(){
        for (int i = 0; i < 100; i++) {
            Connection connection = JDBCUtils.getConnection();
            System.out.println(connection);
            JDBCUtils.close(connection);
        }

    }
}
