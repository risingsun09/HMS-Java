package com.hms.filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.hms.pojo.BookRoomPojo;

public class BookDetailsReadWriteFromFile 
{
	@SuppressWarnings("unchecked")
	public static ArrayList<BookRoomPojo> readDataFromFile()
	{
		ArrayList<BookRoomPojo> list4;
		try
		{
		   FileInputStream fin=new FileInputStream("BookRoom.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<BookRoomPojo>)oin.readObject();
		   
		   oin.close();
		   fin.close();
		}catch(Exception e)
		 {
			 list4=new ArrayList<BookRoomPojo>();
		 }
		 
		return list4;
	}
	
	public static void writeDatatoFile(ArrayList<BookRoomPojo> wlist)
	{
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("BookRoom.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(wlist);
		       
		       oout.close();
		}catch(Exception e){System.out.println(e);}
	}
}

