package com.ataj.dao.impl;

import com.ataj.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: BaseDao
 * @Description: TODO
 * @Author: 高举
 * @Date: 2021/11/21 17:11
 * @URL：https://github.com/GaoHaiNB
 */
public abstract class BaseDao {
    private QueryRunner queryRunner=new QueryRunner();
    //update 方法用来执行:Insert/Delete/Update语句
    public int update(String sql,Object ... args){
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection);
        }
        return -1;
    }


    public<T> T queryForOne(Class<T> type,String sql,Object ... args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }


    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }


    public Object queryForSingleValue(String sql,Object ... args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }
}
