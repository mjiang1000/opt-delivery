package dbtest.core.dal;

import Intepower.DbUtils.DbHelper;
import javax.naming.NamingException;


/**
 * ������ݷ��ʻ���

 *
 */
public class BaseDao {
	/**
	 * ��ݿ�����
	 */
	protected DbHelper dbHelper;
	/**
	 * ������
	 */
	protected String errorMessage;
	
	
	public BaseDao() throws NamingException
	{
		dbHelper=new DbHelper();
	}
	
	/**
	 *
	 * @return String
	 */
	public String getErrorMessage()
	{
		return errorMessage;
	}
	

}
