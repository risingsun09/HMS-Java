package com.hms.filehandling;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.hms.pojo.RoomIncomePojo;

public class RoomIncomeReadWriteFromFile 
{

	@SuppressWarnings("unchecked")
	public static ArrayList<RoomIncomePojo> readDataFromFile()
	{
		ArrayList<RoomIncomePojo>  ar;
		try
		{
			FileInputStream fin = new FileInputStream("FoodIncome.dat");
			ObjectInputStream oin = new ObjectInputStream(fin);
			ar=(ArrayList<RoomIncomePojo>) oin.readObject();
			
			fin.close();
			oin.close();
			
		}
		catch(Exception e)
		{
			ar = new ArrayList<RoomIncomePojo>();
		}
		return ar;
		
	}
	
	public static void writeDataIntoFile( ArrayList<RoomIncomePojo> ar)
	{
		
		
		try 
		{
			FileOutputStream fout = new FileOutputStream("FoodIncome.dat");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(ar);
			
			fout.close();
			oout.close();
			
		} catch (Exception e) {
			
				System.out.println(e);
		}
		
		
		
		
	}
}
