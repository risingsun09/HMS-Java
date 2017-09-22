package com.hms.framedesign;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hms.filehandling.RoomDataReadWriteFromFile;
import com.hms.pojo.RoomPojo;

public class SearchTypeDisplay extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public SearchTypeDisplay(int index)
	{
		super("Search Window");
		String heading[]={"roomno","noOfPersons"};
		String data[][] = new String[5][2];;
		ArrayList<RoomPojo> list6;
		try
		{
			list6 = RoomDataReadWriteFromFile.readDataFromFile();
					
			RoomPojo re = list6.get(index);
			
			int r = 0;
			data[r][0]=re.getRoomno();
			data[r][1]=re.getNumofpersons();
			
					
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



