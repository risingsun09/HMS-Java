package com.hms.framedesign;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hms.filehandling.UserDataReadWriteFromFile;
import com.hms.pojo.OperatorRegistrationPojo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;



public class DisplayAllData extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public DisplayAllData()
	{
		super("Display All");
		String heading[]={"ID","Password","Name","EmailId","MobNo","Address","City","Gender","DOB"};
		String data[][];
		ArrayList<OperatorRegistrationPojo> list;
		try
		{
			list = UserDataReadWriteFromFile.readDataFromFile();
			
			data = new String[list.size()][9];
			
			int r=0;
			for(OperatorRegistrationPojo re : list)
			{
				data[r][0]=re.getId();
				data[r][1]=re.getPassword();
				data[r][2]=re.getName();
				data[r][3]=re.getEmailid();
				data[r][4]=re.getMobno();
				data[r][5]=re.getAddress();
				data[r][6]=re.getCity();
				data[r][7]=re.getGender();
				data[r][8]=re.getDob();
				r++;
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