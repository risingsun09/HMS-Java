package com.hms.framedesign;

import java.util.ArrayList;

import com.hms.filehandling.RoomIncomeReadWriteFromFile;
import com.hms.pojo.RoomIncomePojo;

public class SearchRoomIncome {

	public static int searchRoomIncome(String roomno)
	{
		ArrayList<RoomIncomePojo> ar ;
		
		int p= 0,f = -1;
		try
		{
			ar=RoomIncomeReadWriteFromFile.readDataFromFile();
			
			for(RoomIncomePojo r : ar)
			{
				if(roomno.equals(r.getRoomno()))
				{
					f=p;
					break;
				}
				p++;
			}
			
			return f;
		}catch(Exception e)
		{
			System.out.println(e);
			return -1;
			
		}
		
	}
}
