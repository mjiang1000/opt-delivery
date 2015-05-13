//------------------------------------------------------------------------------
// 创建标识: Copyright (C) 2015 智强软件 版权所有
// 创建描述: Intepower代码生成器 V2.0.0.0 自动创建于 2015/4/26 15:28:21
//------------------------------------------------------------------------------


package com.intepower.model;

import java.util.Date;

/**
* 
* 实体类： vm_gps
* @author Intepower
* @version V1.0
* @since 2015/04/26
* 
**/
public class vm_gps 
{
	/** ID **/
	public int ID;
	/** VehiID **/
	public int VehiID;
	/** PlatNum **/
	public String PlatNum;
	/** PushTime **/
	public String PushTime;
	/** Lon **/
	public double Lon;
	/** Lat **/
	public double Lat;
	public vm_gps()
	{ }

	/**
	* 构造函数 vm_gps
	* @param pID ID
	* @param pVehiID VehiID
	* @param pPlatNum PlatNum
	* @param pPushTime PushTime
	* @param pLon Lon
	* @param pLat Lat
	**/
	public vm_gps(int pID, int pVehiID, String pPlatNum, String pPushTime, double pLon, double pLat)
	{
		this.ID = pID;
		this.VehiID = pVehiID;
		this.PlatNum = pPlatNum;
		this.PushTime = pPushTime;
		this.Lon = pLon;
		this.Lat = pLat;
	}


}
