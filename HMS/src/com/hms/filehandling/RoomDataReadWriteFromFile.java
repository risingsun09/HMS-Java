package com.hms.filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.hms.pojo.RoomPojo;

public class RoomDataReadWriteFromFile 
{
	@SuppressWarnings("unchecked")
	public static ArrayList<RoomPojo> readDataFromFile()
	{
		ArrayList<RoomPojo> list4;
		try
		{
		   FileInputStream fin=new FileInputStream("Rooms Library.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<RoomPojo>)oin.readObject();
		   
		   oin.close();
		   fin.close();
		}catch(Exception e)
		 {
			 list4=new ArrayList<RoomPojo>();
		 }
		
		
		
		return list4;
	}
	
	public static void writeDatatoFile(ArrayList<RoomPojo> wlist)
	{
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("Rooms Library.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(wlist);
		       
		       oout.close();
		}catch(Exception e){System.out.println(e);}
	}
}

