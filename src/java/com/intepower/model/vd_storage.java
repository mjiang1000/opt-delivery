//------------------------------------------------------------------------------
// 创建标识: Copyright (C) 2015 智强软件 版权所有
// 创建描述: Intepower代码生成器 V2.0.0.0 自动创建于 2015/5/5 23:29:15
//------------------------------------------------------------------------------


package com.intepower.model;

import java.util.Date;

/**
* 
* 实体类： vd_storage
* @author Intepower
* @version V1.0
* @since 2015/05/05
* 
**/
public class vd_storage 
{
	/** ID **/
	public int ID;
	/** 以后需要修改 **/
	public int UserID;
	/** 以后需要修改 **/
	public int CompID;
	/** StorName **/
	public String StorName;
	/** 仓库管理人员 **/
	public String Manager;
	/** ManaID **/
	public int ManaID;
	/** Tel **/
	public String Tel;
	/** Capacity **/
	public double Capacity;
	/** Adress **/
	public String Adress;
	/** LON **/
	public double LON;
	/** LAT **/
	public double LAT;
	/** SurpCapacity **/
	public double SurpCapacity;
	/** 当前仓储量 **/
	public double CurrCapacity;
	/** 仓库建设/租用时间 **/
	public String BuiltTime;
	public vd_storage()
	{ }

	/**
	* 构造函数 vd_storage
	* @param pID ID
	* @param pUserID 以后需要修改
	* @param pCompID 以后需要修改
	* @param pStorName StorName
	* @param pManager 仓库管理人员
	* @param pManaID ManaID
	* @param pTel Tel
	* @param pCapacity Capacity
	* @param pAdress Adress
	* @param pLON LON
	* @param pLAT LAT
	* @param pSurpCapacity SurpCapacity
	* @param pCurrCapacity 当前仓储量
	* @param pBuiltTime 仓库建设/租用时间
	**/
	public vd_storage(int pID, int pUserID, int pCompID, String pStorName, String pManager, int pManaID, String pTel, double pCapacity, String pAdress, double pLON, double pLAT, double pSurpCapacity, double pCurrCapacity, String pBuiltTime)
	{
		this.ID = pID;
		this.UserID = pUserID;
		this.CompID = pCompID;
		this.StorName = pStorName;
		this.Manager = pManager;
		this.ManaID = pManaID;
		this.Tel = pTel;
		this.Capacity = pCapacity;
		this.Adress = pAdress;
		this.LON = pLON;
		this.LAT = pLAT;
		this.SurpCapacity = pSurpCapacity;
		this.CurrCapacity = pCurrCapacity;
		this.BuiltTime = pBuiltTime;
	}


}
