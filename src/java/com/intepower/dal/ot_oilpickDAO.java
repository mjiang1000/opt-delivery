//------------------------------------------------------------------------------
// 创建标识: Copyright (C) 2015 智强软件 版权所有
// 创建描述: Intepower代码生成器 V2.0.0.0 自动创建于 2015/5/5 21:47:57
//------------------------------------------------------------------------------

package com.intepower.dal;

import Intepower.DbUtils.PageBean;
import com.intepower.model.ot_oilpick;
import dbtest.core.dal.BaseDao;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import java.sql.SQLException;


/**
 数据访问类 ot_oilpick
* @author Intepower
* @version V1.0
* @since 2015/05/05
* 
**/
public class ot_oilpickDAO extends BaseDao
{
	public ot_oilpickDAO() throws NamingException
	{	
		super();
		// TODO Auto-generated constructor stub
	}
		/** 增加一条数据 
		 * @throws SQLException 
		 * @throws NamingException **/
		public boolean add(com.intepower.model.ot_oilpick model) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("INSERT INTO ot_oilpick (OrderID,SellerID,SellerName,BuyerID,BuyerName,OilTypeID,OilType,StorName,DeliType,OilNum,PickTime,GeneMan,GeneTime,DeliPlace,PickMan,TradTime,Remark,LON,LAT,Signature)");
			strSql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			Object[] cmdParms = {
				model.OrderID,
				model.SellerID,
				model.SellerName,
				model.BuyerID,
				model.BuyerName,
				model.OilTypeID,
				model.OilType,
				model.StorName,
				model.DeliType,
				model.OilNum,
				model.PickTime,
				model.GeneMan,
				model.GeneTime,
				model.DeliPlace,
				model.PickMan,
				model.TradTime,
				model.Remark,
				model.LON,
				model.LAT,
				model.Signature			};

			return dbHelper.executeNonQuery(strSql.toString(), cmdParms);
		}

		/** 更新一条数据 
		 * @throws SQLException 
		 * @throws NamingException **/
		public boolean update(com.intepower.model.ot_oilpick model) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("UPDATE ot_oilpick SET ");
			strSql.append("OrderID=?,");
			strSql.append("ScheID=?,");
			strSql.append("SellerID=?,");
			strSql.append("SellerName=?,");
			strSql.append("BuyerID=?,");
			strSql.append("BuyerName=?,");
			strSql.append("OilTypeID=?,");
			strSql.append("OilType=?,");
			strSql.append("StorageID=?,");
			strSql.append("StorName=?,");
			strSql.append("DeliType=?,");
			strSql.append("OilNum=?,");
			strSql.append("PickTime=?,");
			strSql.append("GeneMan=?,");
			strSql.append("GeneTime=?,");
			strSql.append("DeliPlace=?,");
			strSql.append("PickMan=?,");
			strSql.append("TradTime=?,");
			strSql.append("Remark=?,");
			strSql.append("LON=?,");
			strSql.append("LAT=?,");
			strSql.append("Signature=?");
			strSql.append(" WHERE ID="+Integer.toString(model.ID));
			Object[] cmdParms = {
				model.OrderID,
				model.ScheID,
				model.SellerID,
				model.SellerName,
				model.BuyerID,
				model.BuyerName,
				model.OilTypeID,
				model.OilType,
				model.StorageID,
				model.StorName,
				model.DeliType,
				model.OilNum,
				model.PickTime,
				model.GeneMan,
				model.GeneTime,
				model.DeliPlace,
				model.PickMan,
				model.TradTime,
				model.Remark,
				model.LON,
				model.LAT,
				model.Signature			};


			return dbHelper.executeNonQuery(strSql.toString(), cmdParms);
		}

		/** 删除指定ID的一条数据 
		 * @throws NamingException **/
		public int delete(int id) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("DELETE FROM ot_oilpick ");
			strSql.append(" WHERE id="+Integer.toString(id));

			return dbHelper.executeQuery(strSql.toString());
		}

		/** 是否存在该记录
		 * @throws SQLException **/
		public boolean exists(int ID) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(1) FROM ot_oilpick");
			strSql.append(" WHERE ID=@in_ID");

			int n = dbHelper.queryCount(strSql.toString());
			return n > 0;
		}

		/** 是否存在该记录 
		 * @throws SQLException **/
		public boolean exists(String where) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(1) FROM ot_oilpick");
			strSql.append(" WHERE "+where);

			int n = dbHelper.queryCount(strSql.toString());
			return n > 0;
		}

		/** 得到一个对象实体 
		 * @throws SQLException 
		 * @throws NamingException **/
		public com.intepower.model.ot_oilpick getModel(String where) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM ot_oilpick ");
			strSql.append(" WHERE "+where);

			com.intepower.model.ot_oilpick model = null;
			List<?> models=this.dbHelper.getList(ot_oilpick.class, strSql.toString());
			if(models.size()>0)
				return (com.intepower.model.ot_oilpick)models.get(0);
			else
				return null;
		}

		/** 得到指定ID的对象实体 
		 * @throws SQLException 
		 * @throws NamingException **/
		public com.intepower.model.ot_oilpick getModel(int id) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM ot_oilpick ");
			strSql.append(" WHERE id="+Integer.toString(id));

			List<?> models=this.dbHelper.getList(ot_oilpick.class, strSql.toString());
			if(models.size()>0)
				return (com.intepower.model.ot_oilpick)models.get(0);
			else
				return null;
		}

		/** 获取泛型数据列表 
		 * @throws SQLException 
		 * @throws NamingException **/
		public List<com.intepower.model.ot_oilpick> getList() throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM ot_oilpick ");
			List<?> lst=this.dbHelper.getList(ot_oilpick.class, strSql.toString());
				return (List<com.intepower.model.ot_oilpick>)lst;
		}

		/** 获取泛型数据列表
		 * @throws SQLException 
		 * @throws NamingException **/
		public List<com.intepower.model.ot_oilpick> getList(String where) throws NamingException, SQLException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT * FROM ot_oilpick ");
			strSql.append(" WHERE "+where);
			List<?> lst=this.dbHelper.getList(ot_oilpick.class, strSql.toString());
				return (List<com.intepower.model.ot_oilpick>)lst;
		}

		/** 得到数据条数 
		 * @throws SQLException **/
		public int queryCount() throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(*) FROM ot_oilpick ");
			return dbHelper.queryCount(strSql.toString());
		}

		/** 得到数据条数
		 * @throws SQLException **/
		public int queryCount(String where) throws NamingException
		{
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT COUNT(*) FROM ot_oilpick ");
			strSql.append(" WHERE "+where);
			return dbHelper.queryCount(strSql.toString());
		}


		/** 分页获取泛型数据列表
		 * @throws SQLException 
		 * @throws NamingException **/
		public List<com.intepower.model.ot_oilpick> getPageList(int pageSize, int pageIndex, String whereClause) throws NamingException, SQLException
		{
			PageBean pb=new PageBean();
			pb.setPageSize(pageSize);
			pb.setPageNum(pageIndex);
			StringBuilder strSql=new StringBuilder();
			strSql.append("SELECT * FROM ot_oilpick WHERE "+whereClause);
			return this.dbHelper.pagedQuery("ot_oilpick",ot_oilpick.class,pb, strSql.toString());
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
