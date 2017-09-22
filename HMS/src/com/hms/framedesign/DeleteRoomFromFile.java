package com.hms.framedesign;



import java.util.ArrayList;

import com.hms.filehandling.RoomDataReadWriteFromFile;
import com.hms.pojo.RoomPojo;

public class DeleteRoomFromFile
{
	public static void deleteInfoData(int index)
	{
		ArrayList<RoomPojo> list1;
		
		list1=RoomDataReadWriteFromFile.readDataFromFile();
		
		list1.remove(index);
		 
		RoomDataReadWriteFromFile.writeDatatoFile(list1);
	}
}
