package com.hms.framedesign;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hms.filehandling.RoomIncomeReadWriteFromFile;
import com.hms.pojo.RoomIncomePojo;

@SuppressWarnings("serial")
public class ShowRoomIncome extends JFrame
{
	public ShowRoomIncome(String title)
	{
		super(title);
		Container c=getContentPane();
		String header[]={"Room No"," Total Income"};
		String data[][];
		try
		{
		ArrayList<RoomIncomePojo> ar;
		ar=RoomIncomeReadWriteFromFile.readDataFromFile();
		int p=0;
		data=new String[ar.size()][2];
		
		for(RoomIncomePojo r : ar)
		{
			data[p][0]=r.getRoomno();
			data[p][1]=r.getTotalincome();
			p++;
			
				
			
		}
		
		
		
		c.setLayout(new BorderLayout());
		c.add(new JLabel("Total Income From Rooms So Far...."), BorderLayout.NORTH);
		
		
		JTable datatable=new JTable(data, header);
		JScrollPane scr= new JScrollPane(datatable);
		c.add(scr, BorderLayout.CENTER);
		setVisible(true);
		setLocation(200, 200);
		setSize(850,300);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String args[])
	{
		new ShowRoomIncome("Hi");
	}
	
}
