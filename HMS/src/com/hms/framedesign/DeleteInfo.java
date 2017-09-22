package com.hms.framedesign;
import java.util.ArrayList;

import com.hms.filehandling.UserDataReadWriteFromFile;
import com.hms.pojo.OperatorRegistrationPojo;

public class DeleteInfo 
{
	public static void deleteInfoData(int index)
	{
		ArrayList<OperatorRegistrationPojo> list1;
		
		list1=UserDataReadWriteFromFile.readDataFromFile();
		
		list1.remove(index);
		 
		UserDataReadWriteFromFile.writeDatatoFile(list1);
	}
}