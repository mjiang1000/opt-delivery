//------------------------------------------------------------------------------
// 创建标识: Copyright (C) 2015 智强软件 版权所有
// 创建描述: Intepower代码生成器 V2.0.0.0 自动创建于 2015/5/5 21:47:57
//------------------------------------------------------------------------------


package com.intepower.model;

import java.util.Date;

/**
* 
* 实体类： ot_oilpick
* @author Intepower
* @version V1.0
* @since 2015/05/05
* 
**/
public class ot_oilpick 
{
	/** ID **/
	public int ID;
	/** OrderID **/
	public int OrderID;
	/** ScheID **/
	public int ScheID;
	/** SellerID **/
	public int SellerID;
	/** SellerName **/
	public String SellerName;
	/** BuyerID **/
	public int BuyerID;
	/** BuyerName **/
	public String BuyerName;
	/** OilTypeID **/
	public int OilTypeID;
	/** 油品类型 **/
	public String OilType;
	/** StorageID **/
	public int StorageID;
	/** StorName **/
	public String StorName;
	/** 运输方式：0-配送；2-自提 **/
	public int DeliType;
	/** OilNum **/
	public double OilNum;
	/** PickTime **/
	public String PickTime;
	/** GeneMan **/
	public String GeneMan;
	/** GeneTime **/
	public String GeneTime;
	/** DeliPlace **/
	public String DeliPlace;
	/** PickMan **/
	public String PickMan;
	/** TradTime **/
	public String TradTime;
	/** Remark **/
	public String Remark;
	/** LON **/
	public double LON;
	/** LAT **/
	public double LAT;
	/** 签名照片存储地址 **/
	public String Signature;
	public ot_oilpick()
	{ }

	/**
	* 构造函数 ot_oilpick
	* @param pID ID
	* @param pOrderID OrderID
	* @param pScheID ScheID
	* @param pSellerID SellerID
	* @param pSellerName SellerName
	* @param pBuyerID BuyerID
	* @param pBuyerName BuyerName
	* @param pOilTypeID OilTypeID
	* @param pOilType 油品类型
	* @param pStorageID StorageID
	* @param pStorName StorName
	* @param pDeliType 运输方式：0-配送；2-自提
	* @param pOilNum OilNum
	* @param pPickTime PickTime
	* @param pGeneMan GeneMan
	* @param pGeneTime GeneTime
	* @param pDeliPlace DeliPlace
	* @param pPickMan PickMan
	* @param pTradTime TradTime
	* @param pRemark Remark
	* @param pLON LON
	* @param pLAT LAT
	* @param pSignature 签名照片存储地址
	**/
	public ot_oilpick(int pID, int pOrderID, int pScheID, int pSellerID, String pSellerName, int pBuyerID, String pBuyerName, int pOilTypeID, String pOilType, int pStorageID, String pStorName, int pDeliType, double pOilNum, String pPickTime, String pGeneMan, String pGeneTime, String pDeliPlace, String pPickMan, String pTradTime, String pRemark, double pLON, double pLAT, String pSignature)
	{
		this.ID = pID;
		this.OrderID = pOrderID;
		this.ScheID = pScheID;
		this.SellerID = pSellerID;
		this.SellerName = pSellerName;
		this.BuyerID = pBuyerID;
		this.BuyerName = pBuyerName;
		this.OilTypeID = pOilTypeID;
		this.OilType = pOilType;
		this.StorageID = pStorageID;
		this.StorName = pStorName;
		this.DeliType = pDeliType;
		this.OilNum = pOilNum;
		this.PickTime = pPickTime;
		this.GeneMan = pGeneMan;
		this.GeneTime = pGeneTime;
		this.DeliPlace = pDeliPlace;
		this.PickMan = pPickMan;
		this.TradTime = pTradTime;
		this.Remark = pRemark;
		this.LON = pLON;
		this.LAT = pLAT;
		this.Signature = pSignature;
	}


}
