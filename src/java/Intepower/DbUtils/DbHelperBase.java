package Intepower.DbUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.*;
import javax.naming.*;

/**
 * 作为所有数据库访问的父类<br/> 适当的提供一些数据库的操作功能
 *
 * @author Administrator
 */
public class DbHelperBase {

    protected Connection conn = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;
    private static final String DRIVER = "java:comp/env/jdbc/mysql";

    public DbHelperBase() throws NamingException {
        this.openConn();
    }

    /**
     * 取得当前数据库连接
     */
    public Connection getConnection() {
        return conn;
    }

    protected void preparedSql(String sql, Object... params)
            throws SQLException, NamingException {
        //openConn();
        pstmt = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstmt.setObject(i + 1, params[i]);
        }
    }

    protected void query(String sql) throws SQLException,
            NamingException {
        openConn();
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
    }

    protected void query(String sql, Object... params) throws SQLException,
            NamingException {
        openConn();
        preparedSql(sql, params);
        rs = pstmt.executeQuery();
    }

    /**
     * 执行SQL并返回影响行数
     *
     * @param sql 调用者方法中定义好的sql语句
     * @return int 影响 行数
     * @throws NamingException
     */
    public int executeQuery(String sql) throws NamingException {
        int count = 0;
        try {
            openConn();
            pstmt = conn.prepareStatement(sql);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }

    /**
     * 执行SQL并返回影响行数
     *
     * @param sql 调用者方法中定义好的sql语句
     * @return int 影响 行数
     * @throws NamingException
     */
    public int executeQuery(String sql, Object... params) throws NamingException {
        int count = 0;
        try {
            openConn();
            preparedSql(sql, params);
            //pstmt = conn.prepareStatement(sql);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }

    /**
     * 执行SQL不返回影响行数
     *
     * @param sql 调用者方法中定义好的sql语句
     * @return boolean 是否成功执行
     * @throws NamingException
     * @throws SQLException
     */
    public boolean executeNonQuery(String sql) throws NamingException, SQLException {
        try {
            openConn();
            pstmt = conn.prepareStatement(sql);
            return pstmt.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeAll();
        }
    }

    /**
     * 执行SQL返回影响行数
     *
     * @param sql 调用者方法中定义好的sql语句
     * @return boolean 是否成功执行
     * @throws NamingException
     * @throws SQLException
     */
    public boolean executeNonQuery(String sql, Object... params) throws NamingException, SQLException {
        try {
            openConn();
            preparedSql(sql, params);
            return pstmt.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeAll();
        }
    }

    protected void openConn() throws NamingException {
        try {
            if (conn != null) {
                if (!conn.isClosed()) {
                    return;
                }
            }

            Context initCtx = new InitialContext();
            // 获得JNDI初始化上下文信息，即获取目录上下文的引用
            DataSource ds = (DataSource) initCtx.lookup(DRIVER);
            if (ds != null) {
                conn = ds.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void closeAll() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将一行记录转换为一个实体实例
     *
     * @param clazz 实体类型
     * @param row 记录
     * @return T
     */
    protected <E> E toEntity(Class<E> clazz, List<NameValuePair> row) {
        if (clazz == null) {
            return null;
        }
        E obj = null;
        try {
            obj = clazz.newInstance();
            for (Field f : clazz.getFields()) {
                f.set(obj, this.getColumnValue(row, f.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 读取字段值
     *
     * @param row 记录
     * @param field 字段名称
     * @return Object
     */
    protected Object getColumnValue(List<NameValuePair> row, String fieldName) {
        for (NameValuePair nameValue : row) {
            if (nameValue.getName().toUpperCase().equals(fieldName.toUpperCase())) {
                return nameValue.getValue();
            }
        }
        return null;
    }
}
