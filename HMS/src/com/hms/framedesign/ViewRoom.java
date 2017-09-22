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



public class ViewRoom extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public ViewRoom()
	{
		super("view All");
		String heading[]={"RoomNo","NumOfPersons"};
		String data[][];
		ArrayList<RoomPojo> list;
		try
		{
			list = RoomDataReadWriteFromFile.readDataFromFile();
			
			data = new String[list.size()][12];
			
			int r=0;
			
			for(RoomPojo re : list)
			{
				boolean a=re.isAllocate();
				if(a==false)
				{
				data[r][0]=re.getRoomno();
				
				data[r][1]=re.getNumofpersons();
				r++;
				}
			}
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Registration Details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			
			setSize(850, 300);
			
			setLocation(200, 200);
			setVisible(true);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

