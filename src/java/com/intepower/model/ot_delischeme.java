//------------------------------------------------------------------------------
// 创建标识: Copyright (C) 2015 智强软件 版权所有
// 创建描述: Intepower代码生成器 V2.0.0.0 自动创建于 2015/5/10 12:02:19
//------------------------------------------------------------------------------


package com.intepower.model;

import java.util.Date;

/**
* 
* 实体类： ot_delischeme
* @author Intepower
* @version V1.0
* @since 2015/05/10
* 
**/
public class ot_delischeme 
{
	/** ID **/
	public int ID;
	/** OrderID **/
	public String OrderID;
	/** BuyerID **/
	public String BuyerID;
	/** BuyerName **/
	public String BuyerName;
	/** 包含提货单个数 **/
	public int AppliNum;
	/** 配送油品总量 **/
	public double OilVol;
	/** StorageID **/
	public String StorageID;
	/** StorName **/
	public String StorName;
	/** 运输方ID **/
	public String Vechicle;
	/** DeliManID **/
	public int DeliManID;
	/** DeliMan **/
	public String DeliMan;
	/** GeneTime **/
	public String GeneTime;
	/** GeneMan **/
	public String GeneMan;
	/** 装油时间 **/
	public String RefuTime;
	/** 出库时间 **/
	public String LeavTime;
	/** 装油人员 **/
	public String RefuMan;
	/** FiniTime **/
	public String FiniTime;
	/** Address **/
	public String Address;
	/** 油品类型 **/
	public String OilType;
	/** 0-未执行，1-在执行，2-完成 **/
	public int State;
	/** PickID **/
	public String PickID;
	public ot_delischeme()
	{ }

	/**
	* 构造函数 ot_delischeme
	* @param pID ID
	* @param pOrderID OrderID
	* @param pBuyerID BuyerID
	* @param pBuyerName BuyerName
	* @param pAppliNum 包含提货单个数
	* @param pOilVol 配送油品总量
	* @param pStorageID StorageID
	* @param pStorName StorName
	* @param pVechicle 运输方ID
	* @param pDeliManID DeliManID
	* @param pDeliMan DeliMan
	* @param pGeneTime GeneTime
	* @param pGeneMan GeneMan
	* @param pRefuTime 装油时间
	* @param pLeavTime 出库时间
	* @param pRefuMan 装油人员
	* @param pFiniTime FiniTime
	* @param pAddress Address
	* @param pOilType 油品类型
	* @param pState 0-未执行，1-在执行，2-完成
	* @param pPickID PickID
	**/
	public ot_delischeme(int pID, String pOrderID, String pBuyerID, String pBuyerName, int pAppliNum, double pOilVol, String pStorageID, String pStorName, String pVechicle, int pDeliManID, String pDeliMan, String pGeneTime, String pGeneMan, String pRefuTime, String pLeavTime, String pRefuMan, String pFiniTime, String pAddress, String pOilType, int pState, String pPickID)
	{
		this.ID = pID;
		this.OrderID = pOrderID;
		this.BuyerID = pBuyerID;
		this.BuyerName = pBuyerName;
		this.AppliNum = pAppliNum;
		this.OilVol = pOilVol;
		this.StorageID = pStorageID;
		this.StorName = pStorName;
		this.Vechicle = pVechicle;
		this.DeliManID = pDeliManID;
		this.DeliMan = pDeliMan;
		this.GeneTime = pGeneTime;
		this.GeneMan = pGeneMan;
		this.RefuTime = pRefuTime;
		this.LeavTime = pLeavTime;
		this.RefuMan = pRefuMan;
		this.FiniTime = pFiniTime;
		this.Address = pAddress;
		this.OilType = pOilType;
		this.State = pState;
		this.PickID = pPickID;
	}


}
