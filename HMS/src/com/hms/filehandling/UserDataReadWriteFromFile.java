package com.hms.filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.hms.pojo.OperatorRegistrationPojo;

public class UserDataReadWriteFromFile 
{
	
	@SuppressWarnings("unchecked")
	public static ArrayList<OperatorRegistrationPojo> readDataFromFile()
	{
		ArrayList<OperatorRegistrationPojo> list4;
		try
		{
		   FileInputStream fin=new FileInputStream("OperatorRegistration.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<OperatorRegistrationPojo>)oin.readObject();
		   
		   oin.close();
		   fin.close();
		}catch(Exception e)
		 {
			 list4=new ArrayList<OperatorRegistrationPojo>();
		 }
		 
		return list4;
	}
	
	public static void writeDatatoFile(ArrayList<OperatorRegistrationPojo> wlist)
	{
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("OperatorRegistration.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(wlist);
		       
		       oout.close();
		}catch(Exception e){System.out.println(e);}
	}
}
