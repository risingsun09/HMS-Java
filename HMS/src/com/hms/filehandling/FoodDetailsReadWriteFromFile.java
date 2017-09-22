package com.hms.filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.hms.pojo.FoodPojo;

public class FoodDetailsReadWriteFromFile 
{
	@SuppressWarnings("unchecked")
	public static ArrayList<FoodPojo> readDataFromFile()
	{
		ArrayList<FoodPojo> list4;
		try
		{
		   FileInputStream fin=new FileInputStream("FoodDetail.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<FoodPojo>)oin.readObject();
		   
		   oin.close();
		   fin.close();
		}catch(Exception e)
		 {
			 list4=new ArrayList<FoodPojo>();
		 }
		 
		return list4;
	}
	
	public static void writeDatatoFile(ArrayList<FoodPojo> wlist)
	{
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("FoodDetail.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(wlist);
		       
		       oout.close();
		}catch(Exception e){System.out.println(e);}
	}
}


