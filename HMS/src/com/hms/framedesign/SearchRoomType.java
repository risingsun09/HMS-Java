package com.hms.framedesign;


import java.util.ArrayList;

import com.hms.filehandling.RoomDataReadWriteFromFile;
import com.hms.pojo.RoomPojo;

public class SearchRoomType
{
	public static int searchId(String id)
	{
		ArrayList<RoomPojo> list2;
		int f = -1;
		try
		{
			list2=RoomDataReadWriteFromFile.readDataFromFile();
			
			for(int p=0; p<list2.size(); p++)
			{
				if(id.equals(list2.get(p).getRoomtype()))
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
