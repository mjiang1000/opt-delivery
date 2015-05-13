//------------------------------------------------------------------------------
// 创建标识: Copyright (C) 2015 智强软件 版权所有
// 创建描述: Intepower代码生成器 V2.0.0.0 自动创建于 2015/4/26 19:32:08
//------------------------------------------------------------------------------


package com.intepower.model;

/**
* 
* 实体类： vm_drivers
* @author Intepower
* @version V1.0
* @since 2015/04/26
* 
**/
public class vm_drivers 
{
	/** ID **/
	public int ID;
	/** Name **/
	public String Name;
	/** Age **/
	public int Age;
	/** 0-女；1-男 **/
	public int Sex;
	/** IDNum **/
	public String IDNum;
	/** DrivYears **/
	public int DrivYears;
	/** Tel **/
	public String Tel;
	/** 所属运输方ID **/
	public int TransID;
	/** TransName **/
	public String TransName;
	/** 当前驾驶的车辆牌照 **/
	public String VehiNum;
	/** Remark **/
	public String Remark;
	/** 0-未工作；1-工作 **/
	public int State;
	public vm_drivers()
	{ }

	/**
	* 构造函数 vm_drivers
	* @param pID ID
	* @param pName Name
	* @param pAge Age
	* @param pSex 0-女；1-男
	* @param pIDNum IDNum
	* @param pDrivYears DrivYears
	* @param pTel Tel
	* @param pTransID 所属运输方ID
	* @param pTransName TransName
	* @param pVehiNum 当前驾驶的车辆牌照
	* @param pRemark Remark
	* @param pState 0-未工作；1-工作
	**/
	public vm_drivers(int pID, String pName, int pAge, int pSex, String pIDNum, int pDrivYears, String pTel, int pTransID, String pTransName, String pVehiNum, String pRemark, int pState)
	{
		this.ID = pID;
		this.Name = pName;
		this.Age = pAge;
		this.Sex = pSex;
		this.IDNum = pIDNum;
		this.DrivYears = pDrivYears;
		this.Tel = pTel;
		this.TransID = pTransID;
		this.TransName = pTransName;
		this.VehiNum = pVehiNum;
		this.Remark = pRemark;
		this.State = pState;
	}


}
