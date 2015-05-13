//------------------------------------------------------------------------------
// 创建标识: Copyright (C) 2015 智强软件 版权所有
// 创建描述: Intepower代码生成器 V2.0.0.0 自动创建于 2015/4/26 19:32:08
//------------------------------------------------------------------------------

package com.intepower.dal;

import Intepower.DbUtils.PageBean;
import com.intepower.model.vm_drivers;
import dbtest.core.dal.BaseDao;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 数据访问类 vm_drivers
* @author Intepower
* @version V1.0
* @since 2015/04/26
* 
**/
public class vm_driversDAO extends BaseDao
{
	public vm_driversDAO() throws NamingException
	{	
		super();
		// TODO Auto-generated constructor stub
	}
		/** 增加一条数据 
		 * @throws SQLException 
		 * @throws NamingException **/
		public boolean add(com.intepower.model.vm_drivers model) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("INSERT INTO vm_drivers (Name,Age,Sex,IDNum,DrivYears,Tel,TransID,TransName,VehiNum,Remark,State)");
			strSql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?)");

			Object[] cmdParms = {
				model.Name,
				model.Age,
				model.Sex,
				model.IDNum,
				model.DrivYears,
				model.Tel,
				model.TransID,
				model.TransName,
				model.VehiNum,
				model.Remark,
				model.State			};

			return dbHelper.executeNonQuery(strSql.toString(), cmdParms);
		}

		/** 更新一条数据 
		 * @throws SQLException 
		 * @throws NamingException **/
		public boolean update(com.intepower.model.vm_drivers model) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("UPDATE vm_drivers SET ");
			strSql.append("Name=?,");
			strSql.append("Age=?,");
			strSql.append("Sex=?,");
			strSql.append("IDNum=?,");
			strSql.append("DrivYears=?,");
			strSql.append("Tel=?,");
			strSql.append("TransID=?,");
			strSql.append("TransName=?,");
			strSql.append("VehiNum=?,");
			strSql.append("Remark=?,");
			strSql.append("State=?");
			strSql.append(" WHERE ID="+Integer.toString(model.ID));
			Object[] cmdParms = {
				model.Name,
				model.Age,
				model.Sex,
				model.IDNum,
				model.DrivYears,
				model.Tel,
				model.TransID,
				model.TransName,
				model.VehiNum,
				model.Remark,
				model.State			};


			return dbHelper.executeNonQuery(strSql.toString(), cmdParms);
		}

		/** 删除指定ID的一条数据 
		 * @throws NamingException **/
		public int delete(int id) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("DELETE FROM vm_drivers ");
			strSql.append(" WHERE id="+Integer.toString(id));

			return dbHelper.executeQuery(strSql.toString());
		}

		/** 是否存在该记录
		 * @throws SQLException **/
		public boolean exists(int ID) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(1) FROM vm_drivers");
			strSql.append(" WHERE ID=@in_ID");

			int n = dbHelper.queryCount(strSql.toString());
			return n > 0;
		}

		/** 是否存在该记录 
		 * @throws SQLException **/
		public boolean exists(String where) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(1) FROM vm_drivers");
			strSql.append(" WHERE "+where);

			int n = dbHelper.queryCount(strSql.toString());
			return n > 0;
		}

		/** 得到一个对象实体 
		 * @throws SQLException 
		 * @throws NamingException **/
		public com.intepower.model.vm_drivers getModel(String where) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM vm_drivers ");
			strSql.append(" WHERE "+where);

			com.intepower.model.vm_drivers model = null;
			List<?> models=this.dbHelper.getList(vm_drivers.class, strSql.toString());
			if(models.size()>0)
				return (com.intepower.model.vm_drivers)models.get(0);
			else
				return null;
		}

		/** 得到指定ID的对象实体 
		 * @throws SQLException 
		 * @throws NamingException **/
		public com.intepower.model.vm_drivers getModel(int id) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM vm_drivers ");
			strSql.append(" WHERE id="+Integer.toString(id));

			List<?> models=this.dbHelper.getList(vm_drivers.class, strSql.toString());
			if(models.size()>0)
				return (com.intepower.model.vm_drivers)models.get(0);
			else
				return null;
		}

		/** 获取泛型数据列表 
		 * @throws SQLException 
		 * @throws NamingException **/
		public List<com.intepower.model.vm_drivers> getList() throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM vm_drivers ");
			List<?> lst=this.dbHelper.getList(vm_drivers.class, strSql.toString());
				return (List<com.intepower.model.vm_drivers>)lst;
		}

		/** 获取泛型数据列表
		 * @throws SQLException 
		 * @throws NamingException **/
		public List<com.intepower.model.vm_drivers> getList(String where) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM vm_drivers ");
			strSql.append(" WHERE "+where);
			List<?> lst=this.dbHelper.getList(vm_drivers.class, strSql.toString());
				return (List<com.intepower.model.vm_drivers>)lst;
		}

		/** 得到数据条数 
		 * @throws SQLException **/
		public int queryCount() throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(*) FROM vm_drivers ");
			return dbHelper.queryCount(strSql.toString());
		}

		/** 得到数据条数
		 * @throws SQLException **/
		public int queryCount(String where) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(*) FROM vm_drivers ");
			strSql.append(" WHERE "+where);
			return dbHelper.queryCount(strSql.toString());
		}


		/** 分页获取泛型数据列表
		 * @throws SQLException 
		 * @throws NamingException **/
		public List<com.intepower.model.vm_drivers> getPageList(int pageSize, int pageIndex, String whereClause) throws NamingException, SQLException
		{
			PageBean pb=new PageBean();
			pb.setPageSize(pageSize);
			pb.setPageNum(pageIndex);
			StringBuilder strSql=new StringBuilder();
			strSql.append("SELECT * FROM vm_drivers WHERE "+whereClause);
			return this.dbHelper.pagedQuery("vm_drivers",vm_drivers.class,pb, strSql.toString());
		}

		/**
		 * 分页数
		 * @param PageSize 分页大小
		 * @param whereClause 分页条件
		 * @return int 页面数目
		 * @throws Exception
		 */
		public int getPageNum(int PageSize, String whereClause) throws Exception
		{
			int rn=queryCount(whereClause);
			return (int)Math.ceil(rn/PageSize);
		}

}
