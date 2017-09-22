package com.hms.framedesign;
import java.util.ArrayList;

import com.hms.filehandling.UserDataReadWriteFromFile;
import com.hms.pojo.OperatorRegistrationPojo;

public class UpdateInfo 
{
	public static void UpdateInfodata(OperatorRegistrationPojo rg,int index)
	{
		ArrayList<OperatorRegistrationPojo> list1;
		
		list1=UserDataReadWriteFromFile.readDataFromFile();
		
		list1.set(index, rg);
		 
		UserDataReadWriteFromFile.writeDatatoFile(list1);
	}
}
