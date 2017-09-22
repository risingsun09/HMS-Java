package com.hms.framedesign;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hms.filehandling.BookDetailsReadWriteFromFile;
import com.hms.pojo.BookRoomPojo;

public class BookRoomSearchDisplay extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public BookRoomSearchDisplay(int index)
	{
		super("Search Window");
		String heading[]={"Room No","Name","Gender","Country","ID Type","ID No.","D.O.B","Address","EmailId","MobNo","Reg Date","Reg Time"};
		String data[][] = new String[5][15];
		ArrayList<BookRoomPojo> list6;
		try
		{
			list6 = BookDetailsReadWriteFromFile.readDataFromFile();
					
			BookRoomPojo re = list6.get(index);
			
			int r = 0;
			data[r][0]=re.getRoomno();
			data[r][1]=re.getName();
			
			data[r][3]=re.getGender();
			data[r][4]=re.getCountry();
			data[r][5]=re.getIdtype();
			data[r][6]=re.getIdno();
			data[r][7]=re.getDob();
			data[r][8]=re.getAddress();
			data[r][9]=re.getEmailid();
			data[r][10]=re.getMobno();
			
			data[r][13]=re.getDate();
			data[r][14]=re.getTime();
					
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("Information Details"),BorderLayout.NORTH);
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

