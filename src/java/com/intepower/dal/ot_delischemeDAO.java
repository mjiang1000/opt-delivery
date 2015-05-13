//------------------------------------------------------------------------------
// 创建标识: Copyright (C) 2015 智强软件 版权所有
// 创建描述: Intepower代码生成器 V2.0.0.0 自动创建于 2015/5/10 12:02:19
//------------------------------------------------------------------------------

package com.intepower.dal;

import Intepower.DbUtils.PageBean;
import com.intepower.model.ot_delischeme;
import dbtest.core.dal.BaseDao;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import java.sql.SQLException;


/**
 数据访问类 ot_delischeme
* @author Intepower
* @version V1.0
* @since 2015/05/10
* 
**/
public class ot_delischemeDAO extends BaseDao
{
	public ot_delischemeDAO() throws NamingException
	{	
		super();
		// TODO Auto-generated constructor stub
	}
		/** 增加一条数据 
		 * @throws SQLException 
		 * @throws NamingException **/
		public boolean add(com.intepower.model.ot_delischeme model) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("INSERT INTO ot_delischeme (OrderID,BuyerID,BuyerName,AppliNum,OilVol,StorageID,StorName,Vechicle,DeliManID,DeliMan,GeneTime,GeneMan,RefuTime,LeavTime,RefuMan,FiniTime,Address,OilType,PickID)");
			strSql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			Object[] cmdParms = {
				model.OrderID,
				model.BuyerID,
				model.BuyerName,
				model.AppliNum,
				model.OilVol,
				model.StorageID,
				model.StorName,
				model.Vechicle,
				model.DeliManID,
				model.DeliMan,
				model.GeneTime,
				model.GeneMan,
				model.RefuTime,
				model.LeavTime,
				model.RefuMan,
				model.FiniTime,
				model.Address,
				model.OilType,
				model.PickID			};

			return dbHelper.executeNonQuery(strSql.toString(), cmdParms);
		}

		/** 更新一条数据 
		 * @throws SQLException 
		 * @throws NamingException **/
		public boolean update(com.intepower.model.ot_delischeme model) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("UPDATE ot_delischeme SET ");
			strSql.append("OrderID=?,");
			strSql.append("BuyerID=?,");
			strSql.append("BuyerName=?,");
			strSql.append("AppliNum=?,");
			strSql.append("OilVol=?,");
			strSql.append("StorageID=?,");
			strSql.append("StorName=?,");
			strSql.append("Vechicle=?,");
			strSql.append("DeliManID=?,");
			strSql.append("DeliMan=?,");
			strSql.append("GeneTime=?,");
			strSql.append("GeneMan=?,");
			strSql.append("RefuTime=?,");
			strSql.append("LeavTime=?,");
			strSql.append("RefuMan=?,");
			strSql.append("FiniTime=?,");
			strSql.append("Address=?,");
			strSql.append("OilType=?,");
			strSql.append("State=?,");
			strSql.append("PickID=?");
			strSql.append(" WHERE ID="+Integer.toString(model.ID));
			Object[] cmdParms = {
				model.OrderID,
				model.BuyerID,
				model.BuyerName,
				model.AppliNum,
				model.OilVol,
				model.StorageID,
				model.StorName,
				model.Vechicle,
				model.DeliManID,
				model.DeliMan,
				model.GeneTime,
				model.GeneMan,
				model.RefuTime,
				model.LeavTime,
				model.RefuMan,
				model.FiniTime,
				model.Address,
				model.OilType,
				model.State,
				model.PickID			};


			return dbHelper.executeNonQuery(strSql.toString(), cmdParms);
		}

		/** 删除指定ID的一条数据 
		 * @throws NamingException **/
		public int delete(int id) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("DELETE FROM ot_delischeme ");
			strSql.append(" WHERE id="+Integer.toString(id));

			return dbHelper.executeQuery(strSql.toString());
		}

		/** 是否存在该记录
		 * @throws SQLException **/
		public boolean exists(int ID) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(1) FROM ot_delischeme");
			strSql.append(" WHERE ID=@in_ID");

			int n = dbHelper.queryCount(strSql.toString());
			return n > 0;
		}

		/** 是否存在该记录 
		 * @throws SQLException **/
		public boolean exists(String where) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(1) FROM ot_delischeme");
			strSql.append(" WHERE "+where);

			int n = dbHelper.queryCount(strSql.toString());
			return n > 0;
		}

		/** 得到一个对象实体 
		 * @throws SQLException 
		 * @throws NamingException **/
		public com.intepower.model.ot_delischeme getModel(String where) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM ot_delischeme ");
			strSql.append(" WHERE "+where);

			com.intepower.model.ot_delischeme model = null;
			List<?> models=this.dbHelper.getList(ot_delischeme.class, strSql.toString());
			if(models.size()>0)
				return (com.intepower.model.ot_delischeme)models.get(0);
			else
				return null;
		}

		/** 得到指定ID的对象实体 
		 * @throws SQLException 
		 * @throws NamingException **/
		public com.intepower.model.ot_delischeme getModel(int id) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM ot_delischeme ");
			strSql.append(" WHERE id="+Integer.toString(id));

			List<?> models=this.dbHelper.getList(ot_delischeme.class, strSql.toString());
			if(models.size()>0)
				return (com.intepower.model.ot_delischeme)models.get(0);
			else
				return null;
		}

		/** 获取泛型数据列表 
		 * @throws SQLException 
		 * @throws NamingException **/
		public List<com.intepower.model.ot_delischeme> getList() throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM ot_delischeme ");
			List<?> lst=this.dbHelper.getList(ot_delischeme.class, strSql.toString());
				return (List<com.intepower.model.ot_delischeme>)lst;
		}

		/** 获取泛型数据列表
		 * @throws SQLException 
		 * @throws NamingException **/
		public List<com.intepower.model.ot_delischeme> getList(String where) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM ot_delischeme ");
			strSql.append(" WHERE "+where);
			List<?> lst=this.dbHelper.getList(ot_delischeme.class, strSql.toString());
				return (List<com.intepower.model.ot_delischeme>)lst;
		}

		/** 得到数据条数 
		 * @throws SQLException **/
		public int queryCount() throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(*) FROM ot_delischeme ");
			return dbHelper.queryCount(strSql.toString());
		}

		/** 得到数据条数
		 * @throws SQLException **/
		public int queryCount(String where) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(*) FROM ot_delischeme ");
			strSql.append(" WHERE "+where);
			return dbHelper.queryCount(strSql.toString());
		}


		/** 分页获取泛型数据列表
		 * @throws SQLException 
		 * @throws NamingException **/
		public List<com.intepower.model.ot_delischeme> getPageList(int pageSize, int pageIndex, String whereClause) throws NamingException, SQLException
		{
			PageBean pb=new PageBean();
			pb.setPageSize(pageSize);
			pb.setPageNum(pageIndex);
			StringBuilder strSql=new StringBuilder();
			strSql.append("SELECT * FROM ot_delischeme WHERE "+whereClause);
			return this.dbHelper.pagedQuery("ot_delischeme",ot_delischeme.class,pb, strSql.toString());
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
