//------------------------------------------------------------------------------
// 创建标识: Copyright (C) 2015 智强软件 版权所有
// 创建描述: Intepower代码生成器 V2.0.0.0 自动创建于 2015/5/5 23:29:15
//------------------------------------------------------------------------------

package com.intepower.dal;

import Intepower.DbUtils.PageBean;
import com.intepower.model.vd_storage;
import dbtest.core.dal.BaseDao;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import java.sql.SQLException;


/**
 数据访问类 vd_storage
* @author Intepower
* @version V1.0
* @since 2015/05/05
* 
**/
public class vd_storageDAO extends BaseDao
{
	public vd_storageDAO() throws NamingException
	{	
		super();
		// TODO Auto-generated constructor stub
	}
		/** 增加一条数据 
		 * @throws SQLException 
		 * @throws NamingException **/
		public boolean add(com.intepower.model.vd_storage model) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("INSERT INTO vd_storage (StorName,Manager,ManaID,Tel,Capacity,Adress,LON,LAT,SurpCapacity,CurrCapacity,BuiltTime)");
			strSql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?)");

			Object[] cmdParms = {
				model.StorName,
				model.Manager,
				model.ManaID,
				model.Tel,
				model.Capacity,
				model.Adress,
				model.LON,
				model.LAT,
				model.SurpCapacity,
				model.CurrCapacity,
				model.BuiltTime			};

			return dbHelper.executeNonQuery(strSql.toString(), cmdParms);
		}

		/** 更新一条数据 
		 * @throws SQLException 
		 * @throws NamingException **/
		public boolean update(com.intepower.model.vd_storage model) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("UPDATE vd_storage SET ");
			strSql.append("UserID=?,");
			strSql.append("CompID=?,");
			strSql.append("StorName=?,");
			strSql.append("Manager=?,");
			strSql.append("ManaID=?,");
			strSql.append("Tel=?,");
			strSql.append("Capacity=?,");
			strSql.append("Adress=?,");
			strSql.append("LON=?,");
			strSql.append("LAT=?,");
			strSql.append("SurpCapacity=?,");
			strSql.append("CurrCapacity=?,");
			strSql.append("BuiltTime=?");
			strSql.append(" WHERE ID="+Integer.toString(model.ID));
			Object[] cmdParms = {
				model.UserID,
				model.CompID,
				model.StorName,
				model.Manager,
				model.ManaID,
				model.Tel,
				model.Capacity,
				model.Adress,
				model.LON,
				model.LAT,
				model.SurpCapacity,
				model.CurrCapacity,
				model.BuiltTime			};


			return dbHelper.executeNonQuery(strSql.toString(), cmdParms);
		}

		/** 删除指定ID的一条数据 
		 * @throws NamingException **/
		public int delete(int id) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("DELETE FROM vd_storage ");
			strSql.append(" WHERE id="+Integer.toString(id));

			return dbHelper.executeQuery(strSql.toString());
		}

		/** 是否存在该记录
		 * @throws SQLException **/
		public boolean exists(int ID) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(1) FROM vd_storage");
			strSql.append(" WHERE ID=@in_ID");

			int n = dbHelper.queryCount(strSql.toString());
			return n > 0;
		}

		/** 是否存在该记录 
		 * @throws SQLException **/
		public boolean exists(String where) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(1) FROM vd_storage");
			strSql.append(" WHERE "+where);

			int n = dbHelper.queryCount(strSql.toString());
			return n > 0;
		}

		/** 得到一个对象实体 
		 * @throws SQLException 
		 * @throws NamingException **/
		public com.intepower.model.vd_storage getModel(String where) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM vd_storage ");
			strSql.append(" WHERE "+where);

			com.intepower.model.vd_storage model = null;
			List<?> models=this.dbHelper.getList(vd_storage.class, strSql.toString());
			if(models.size()>0)
				return (com.intepower.model.vd_storage)models.get(0);
			else
				return null;
		}

		/** 得到指定ID的对象实体 
		 * @throws SQLException 
		 * @throws NamingException **/
		public com.intepower.model.vd_storage getModel(int id) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM vd_storage ");
			strSql.append(" WHERE id="+Integer.toString(id));

			List<?> models=this.dbHelper.getList(vd_storage.class, strSql.toString());
			if(models.size()>0)
				return (com.intepower.model.vd_storage)models.get(0);
			else
				return null;
		}

		/** 获取泛型数据列表 
		 * @throws SQLException 
		 * @throws NamingException **/
		public List<com.intepower.model.vd_storage> getList() throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM vd_storage ");
			List<?> lst=this.dbHelper.getList(vd_storage.class, strSql.toString());
				return (List<com.intepower.model.vd_storage>)lst;
		}

		/** 获取泛型数据列表
		 * @throws SQLException 
		 * @throws NamingException **/
		public List<com.intepower.model.vd_storage> getList(String where) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM vd_storage ");
			strSql.append(" WHERE "+where);
			List<?> lst=this.dbHelper.getList(vd_storage.class, strSql.toString());
				return (List<com.intepower.model.vd_storage>)lst;
		}

		/** 得到数据条数 
		 * @throws SQLException **/
		public int queryCount() throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(*) FROM vd_storage ");
			return dbHelper.queryCount(strSql.toString());
		}

		/** 得到数据条数
		 * @throws SQLException **/
		public int queryCount(String where) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(*) FROM vd_storage ");
			strSql.append(" WHERE "+where);
			return dbHelper.queryCount(strSql.toString());
		}


		/** 分页获取泛型数据列表
		 * @throws SQLException 
		 * @throws NamingException **/
		public List<com.intepower.model.vd_storage> getPageList(int pageSize, int pageIndex, String whereClause) throws NamingException, SQLException
		{
			PageBean pb=new PageBean();
			pb.setPageSize(pageSize);
			pb.setPageNum(pageIndex);
			StringBuilder strSql=new StringBuilder();
			strSql.append("SELECT * FROM vd_storage WHERE "+whereClause);
			return this.dbHelper.pagedQuery("vd_storage",vd_storage.class,pb, strSql.toString());
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
