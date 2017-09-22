package com.hms.framedesign;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hms.filehandling.RoomDataReadWriteFromFile;
import com.hms.pojo.RoomPojo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;




public class DisplayAllRoom extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public DisplayAllRoom()
	{
		super("Display All");
		String heading[]={"RoomNo","RoomType","Tarrif","NumOfPersons","allocation"};
		String data[][];
		ArrayList<RoomPojo> list;
		try
		{
			list = RoomDataReadWriteFromFile.readDataFromFile();
			
			data = new String[list.size()][12];
			
			int r=0;
			for(RoomPojo re : list)
			{
				data[r][0]=re.getRoomno();
				data[r][1]=re.getRoomtype();
				data[r][2]=re.getTarrif();
				data[r][3]=re.getNumofpersons();
				data[r][4]=""+re.isAllocate();
				r++;
			}
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			con.setBackground(Color.BLUE);
			
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
