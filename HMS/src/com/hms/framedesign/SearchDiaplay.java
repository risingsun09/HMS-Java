package com.hms.framedesign;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hms.filehandling.UserDataReadWriteFromFile;
import com.hms.pojo.OperatorRegistrationPojo;

public class SearchDiaplay extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public SearchDiaplay(int index)
	{
		super("Search Window");
		String heading[]={"ID","Password","Name","EmailId","MobNo","Address","City","Gender","DOB"};
		String data[][] = new String[5][9];;
		ArrayList<OperatorRegistrationPojo> list6;
		try
		{
			list6 = UserDataReadWriteFromFile.readDataFromFile();
					
			OperatorRegistrationPojo re = list6.get(index);
			
			int r = 0;
			data[r][0]=re.getId();
			data[r][1]=re.getPassword();
			data[r][2]=re.getName();
			data[r][3]=re.getEmailid();
			data[r][4]=re.getMobno();
			data[r][5]=re.getAddress();
			data[r][6]=re.getCity();
			data[r][7]=re.getGender();
			data[r][8]=re.getDob();
					
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


