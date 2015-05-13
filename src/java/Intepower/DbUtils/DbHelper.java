package Intepower.DbUtils;



import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

/**
 * 扩展的一个数据库操作类，用于操作数据库的增删改查操作 
 * 创建作者：李光强
 * 创建日期：2012-4-16
 */
public class DbHelper extends DbHelperBase {

	public DbHelper() throws NamingException {
		super();
		// TODO Auto-generated constructor stub
	}
	ArrayList<String> st = new ArrayList<String>();
	/**
	 * 当前行号
	 */
	private int currentRow = -1;
	/**
	 * 行集
	 */
	private List<List<NameValuePair>> rows = new ArrayList<List<NameValuePair>>();
	/**
	 * 当前列号
	 */
	private int currentColumn = -1;

/**
	 * 分页查询方法 分2部分组成，第一部分是计算总记录数，第二部分是查询分页内容 传入参数在原来的基础上加上2个参数，一个起始记录和结束记录
	 * 
	 * @param pb
	 * @param sql
	 * @return
	 * @throws NamingException
	 */

public  <T> List<T> pagedQuery(String tabName,Class<T> genericType,PageBean pb, String where)
			throws NamingException, SQLException {
	String sql="SELECT COUNT(*) FROM "+tabName;
		pb.setTotal(this.queryCount(sql));
		String pagedSql = "select * from (select rownum as rn, t__.* from ("
				+ sql + ") t__) where rn >= ? and rn <= ? AND "+where;
		Object[] p = new Object[2];
		p[0] = pb.getFirstResult();
		p[1] = pb.getMaxResult();
		return this.getList(genericType,pagedSql,p);
	}

	
	/**
	 * 统计当前sql语句在数据库表中的总记录数
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws NamingException
	 */
	public int queryCount(String sql) throws NamingException {
		try {
			query(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return 0;
	}		

	/**
	 * 统计当前sql语句在数据库表中的总记录数
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws NamingException
	 */
	public int queryCount(String sql, Object... params) throws NamingException {
		try {
			query(sql, params);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}		
	
	/**
	 * 查询操作 
	 * @param genericType 实体类型
	 * @param sql  调用者方法中定义好的sql语句
	 * @return List
	 * @throws NamingException
	 * @throws SQLException 
	 */
	public <T> List<T> getList(Class<T> genericType, String sql) throws NamingException, SQLException {

		if (genericType == null || sql == null || sql.length() == 0) {
			return null;
		}
		List<T> list = new ArrayList<T>();
		try {
			this.openConn();
			query(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsCount = rsmd.getColumnCount();
			while (rs.next()) {
				List<NameValuePair> row = new ArrayList<NameValuePair>();
				for (int i = 1; i <= columnsCount; i++) {
					String columnName = rsmd.getColumnName(i);
					row.add(new NameValuePair(columnName, (rs
							.getObject(columnName))));					
				}
				T o = toEntity(genericType, row);
				list.add(o);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			super.closeAll();
		}

		return list;
	}

	/**
	 * 查询操作
	 * 
	 * @param <T>
	 * @param sql
	 *            调用者方法中定义好的sql语句，通常是一个DAO类的方法
	 * @param params
	 *            传入的参数，多个参数用逗号隔开即可
	 * @return List
	 * @throws NamingException
	 */
	public <T> List<T> getList(Class<T> genericType, String sql,
			Object... params) throws NamingException {

		if (genericType == null || sql == null || sql.length() == 0) {
			return null;
		}
		List<T> list = new ArrayList<T>();
		try {
			query(sql, params);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsCount = rsmd.getColumnCount();
			while (rs.next()) {
				List<NameValuePair> row = new ArrayList<NameValuePair>();
				for (int i = 1; i <= columnsCount; i++) {
					String columnName = rsmd.getColumnName(i);
					row.add(new NameValuePair(columnName, rs
							.getObject(columnName)));
					T o = toEntity(genericType, row);
					list.add(o);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			super.closeAll();
		}

		return list;
	}

	/**
	 * 查询操作，值返回true或者false，具体的结果集通过此类的方法来获取
	 * 
	 * @param sql
	 *            ，调用者方法中定义好的sql语句，通常是一个DAO类的方法
	 * @param params
	 *            传入的参数，多个参数用逗号隔开即可
	 * @return
	 * @throws NamingException
	 */
	public boolean rowsQuery(String sql, Object... params)
			throws NamingException {
		rows.clear();
		currentRow = -1;
		try {
			query(sql, params);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsCount = rsmd.getColumnCount();
			while (rs.next()) {
				List<NameValuePair> row = new ArrayList<NameValuePair>();
				for (int i = 1; i <= columnsCount; i++) {
					String columnName = rsmd.getColumnName(i);
					row.add(new NameValuePair(columnName, rs
							.getObject(columnName)));
				}
				rows.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			super.closeAll();
		}

		return true;
	}

	/**
	 * 移到下一行，如果没有则返回false
	 * 
	 * @return
	 */
	public boolean nextRow() {
		currentRow++;
		currentColumn = -1;// 每移到一行，列都重头开始
		if (currentRow < rows.size()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断当前是否还有列未遍历完成
	 * 
	 * @return
	 */
	public boolean nextColumn() {
		currentColumn++;
		if (currentColumn < rows.get(currentRow).size()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 返回当前列的值, 下标按当前下标值
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <V> V getColumn() {
		return (V) rows.get(currentRow).get(currentColumn).getValue();
	}

	/**
	 * 按列小表获取列数据
	 * 
	 * @param columnIndex
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <V> V getColumn(int columnIndex) {
		return (V) rows.get(currentRow).get(columnIndex).getValue();
	}

	/**
	 * 获得当前列的值 由于列的数量相对来说不多，一般不超过几十列，所以用集合遍历也没问题
	 * 
	 * @param column
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <V> V getColumn(String column) {
		for (NameValuePair nvp : rows.get(currentRow)) {
			if (nvp.getName().equals(column.toUpperCase())) {
				return (V) nvp.getValue();
			}
		}
		return null;
	}

}
