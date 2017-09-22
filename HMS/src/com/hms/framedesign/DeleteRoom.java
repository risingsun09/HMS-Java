package com.hms.framedesign;



import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hms.filehandling.RoomDataReadWriteFromFile;
import com.hms.pojo.RoomPojo;



@SuppressWarnings("serial")
public class DeleteRoom extends JFrame
{
	 
	private JButton delete;
	private JLabel l1,l2;
	private JComboBox<String> room;
	
	  //private JTextField roomno;
	  public DeleteRoom(String title)
	  {
		  super(title);
	  
		/*  Container c=getContentPane();
		  c.setLayout(new GridLayout(3,1));
		  c.setBackground(Color.BLUE);
		  */
		  JPanel c = new JPanel();
		  c.setLayout(null);
		  setContentPane(c);
		  c.setBackground(Color.CYAN);

		  
		  room = new JComboBox<String>();
		  room.setBounds(200,60,200,30);
		  
		  ArrayList<RoomPojo> rmlist = RoomDataReadWriteFromFile.readDataFromFile();
		  
		  for(RoomPojo rp : rmlist)
		  {
			  room.addItem(rp.getRoomno());
			  
		  }
		  delete =new JButton("DELETE ROOM");
		  delete.setBounds(200,120,200,30);
		  
			delete.addActionListener((e) ->
			                             {
			                            	 deleteInformation();
			                            	
			                              }
			                            );
			
			
			Font f=new Font("FORTE",Font.BOLD,27);
			l1=new JLabel("DELETE ROOM");
			l1.setFont(f);
			l1.setForeground(Color.BLUE);
			l1.setBounds(10,5,400,30);
				
			Font f1=new Font("comic sans ms",Font.BOLD,18);
			l2=new JLabel("Enter Room Number");
			l2.setFont(f1);
			l2.setForeground(Color.RED);
			l2.setBounds(10,60,200,30);  
			
		    c.add(l1);c.add(new JLabel(""));
		    c.add(l2);c.add(room);
		    c.add(new JLabel(""));c.add(delete);
			
			 setSize(450, 250);
			 setLocation(200,100);
			 setResizable(false);
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 setVisible(true);	
	  }
	  
	  public void deleteInformation()
	     {
		  
		  
	    	 int idfoundpos = SearchRoom.searchId(room.getSelectedItem().toString());

          if(idfoundpos >= 0)
          {
         	 DeleteRoomFromFile.deleteInfoData(idfoundpos);
             JOptionPane.showMessageDialog(this, "ROOM Deleted...");
             resetFrame();
             
          }
          else
          {
             JOptionPane.showMessageDialog(this, "ROOM NOT FOUND..PLEASE ENTER ANOTHER ROOM...");
          }
          
	     }
	  void resetFrame()
	  {
		  this.dispose();
		  new DeleteRoom("Delete Room...");
	  }
	  
	  public static void main(String[] args) 
		{
			new DeleteRoom("Delete Room...");

		}
}


