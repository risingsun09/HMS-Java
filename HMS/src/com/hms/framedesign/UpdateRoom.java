package com.hms.framedesign;


import java.util.ArrayList;

import com.hms.filehandling.RoomDataReadWriteFromFile;
import com.hms.pojo.RoomPojo;

public class UpdateRoom 
{
	public static void UpdateInfodata(RoomPojo rg,int index)
	{
		ArrayList<RoomPojo> list1;
		
		list1=RoomDataReadWriteFromFile.readDataFromFile();
		
		list1.set(index, rg);
		 
		RoomDataReadWriteFromFile.writeDatatoFile(list1);
	}
}
