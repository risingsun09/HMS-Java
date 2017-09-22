package com.hms.framedesign;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hms.filehandling.RoomDataReadWriteFromFile;
import com.hms.pojo.RoomPojo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

public class SearchType extends JFrame
{
	
	public SearchType(String type,String nop)
	{
		ArrayList<RoomPojo> list2;
		
		String heading[]={"roomno","noOfPersons"};
		String data[][] = new String[5][2];
		
        int r=0;
		int f = -1;
		try
		{
			list2=RoomDataReadWriteFromFile.readDataFromFile();
			
			for(int p=0; p<list2.size(); p++)
			{
				if(type.equals(list2.get(p).getRoomtype())&&nop.equals(list2.get(p).getNumofpersons())&&(!list2.get(p).isAllocate()))
				{
					data[r][0]=list2.get(p).getRoomno();
					
					data[r][1]=list2.get(p).getNumofpersons();
					r++;
				}	
			}

			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Available Rooms"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			
			setSize(500, 300);
			
			setLocation(200, 200);
			setVisible(true);
			 
			
		}catch(Exception e)
		{
			System.out.println(e);
		
		}
 	}
}

