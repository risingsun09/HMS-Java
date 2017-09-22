package com.hms.framedesign;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hms.filehandling.BookDetailsReadWriteFromFile;
import com.hms.pojo.BookRoomPojo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

public class ViewAllBookedRooms extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public ViewAllBookedRooms()
	{
		super("Display All");
		String heading[]={"Bill No","Room No","Name","Gender","Country","ID Type","ID No.","D.O.B","Address","EmailId","MobNo","Reg Date","Reg Time"};
		String data[][];
		ArrayList<BookRoomPojo> list;
		try
		{
			list = BookDetailsReadWriteFromFile.readDataFromFile();
			
			data = new String[list.size()][13];
			
			int r=0;
			for(BookRoomPojo re : list)
			{
				data[r][0]=re.getBillno();
				data[r][1]=re.getRoomno();
				data[r][2]=re.getName();
			
				data[r][3]=re.getGender();
				data[r][4]=re.getCountry();
				data[r][5]=re.getIdtype();
				data[r][6]=re.getIdno();
				data[r][7]=re.getDob();
				data[r][8]=re.getAddress();
				data[r][9]=re.getEmailid();
				data[r][10]=re.getMobno();
				
				data[r][11]=re.getDate();
				data[r][12]=re.getTime();
				r++;
				
			}
			
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Booked Details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			
			setSize(950, 300);
			setLocation(200, 200);
			setVisible(true);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}