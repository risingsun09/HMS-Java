package com.hms.framedesign;

import java.util.ArrayList;

import com.hms.filehandling.BookDetailsReadWriteFromFile;
import com.hms.pojo.BookRoomPojo;

public class BookRoomSearch 
{
	public static int searchRoomno(BookRoomPojo robj)
	{
		ArrayList<BookRoomPojo> list2;
		int f = -1;
		try
		{
			list2=BookDetailsReadWriteFromFile.readDataFromFile();
			
			for(int p=0; p<list2.size(); p++)
			{
				if((robj.getRoomno()).equals(list2.get(p).getRoomno()))
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
	
	public static int searchRoomno(String rmno)
	{
		ArrayList<BookRoomPojo> list2;
		int f = -1;
		try
		{
			list2=BookDetailsReadWriteFromFile.readDataFromFile();
			
			for(int p=0; p<list2.size(); p++)
			{
				if(rmno.equals(list2.get(p).getRoomno()))
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
