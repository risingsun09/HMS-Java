package com.hms.framedesign;

import java.util.ArrayList;

import com.hms.filehandling.BookDetailsReadWriteFromFile;
import com.hms.pojo.BookRoomPojo;

public class  BookRoomDetailsDelete
{
	public static void deleteInfoData(int index)
	{
		ArrayList<BookRoomPojo> list1;
		
		list1=BookDetailsReadWriteFromFile.readDataFromFile();
		
		list1.remove(index);
		 
		BookDetailsReadWriteFromFile.writeDatatoFile(list1);
	}
}