package com.hms.framedesign;
import java.util.ArrayList;

import com.hms.filehandling.UserDataReadWriteFromFile;
import com.hms.pojo.OperatorRegistrationPojo;

public class Search 
{
	public static int searchId(String id)
	{
		ArrayList<OperatorRegistrationPojo> list2;
		int f = -1;
		try
		{
			list2=UserDataReadWriteFromFile.readDataFromFile();
			
			for(int p=0; p<list2.size(); p++)
			{
				if(id.equals(list2.get(p).getId()))
				{
				   f = p;
				   break;
				}	
			}
			 
			return(f);
		}catch(Exception e)
		{
			System.out.println(e);
			return(-1);
		}
 	}
}