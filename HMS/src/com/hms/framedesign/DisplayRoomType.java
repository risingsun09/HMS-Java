package com.hms.framedesign;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.hms.pojo.RoomPojo;

public class DisplayRoomType extends JFrame
{
	  private JLabel l1,l2,l3,l4,l5;
	  
	 
	  private JComboBox roomType,nop;
	  
	  private JButton submit;
	
	  
	  ArrayList<RoomPojo> userlist;
	  
	  RoomPojo r;
	
	  public DisplayRoomType(String title)
	  {
		  super(title);
	  
		  /*Container c=getContentPane();
		  c.setLayout(new GridLayout(4,2));
		  c.setBackground(Color.BLUE);
			*/	
		  JPanel c = new JPanel();
		  c.setLayout(null);
		  setContentPane(c);
		  c.setBackground(Color.CYAN);
		  
		 /* tname.addFocusListener( new FocusAdapter() 
		                          {
			                         public void focusGained(FocusEvent e)
			                         {
       	                                  tname.setBackground(Color.WHITE);
			                         }
		                          }
			                    );
		 */
		 
		  String type[]={"A.C","NON A.C"};
		  roomType=new JComboBox(type);
		  roomType.setBounds(200,80,200,30);
		
		   String dvalue[]=new String[5];
		   for(int i=0;i<=4;i++)
		   {
				dvalue[i]=String.valueOf(i+1);
		   }
		   nop=new JComboBox(dvalue);
		   nop.setBounds(200,120,200,30);
				
		   
		   
			submit =new JButton("SUBMIT");
			submit.setBounds(200,200,200,30);
			submit.addActionListener((e) ->
			                             {
			                            	addInformation();
			                            	
			                              }
			                            );
				
			
			
			Font f=new Font("FORTE",Font.BOLD,27);
			l1=new JLabel("DISPLAY ROOMS");
			l1.setFont(f);
			l1.setForeground(Color.BLUE);
			l1.setBounds(10,10,400,50);
				
			Font f1=new Font("comic sans ms",Font.BOLD,18);
			l2=new JLabel("ROOM TYPE");
			l2.setFont(f1);
			l2.setForeground(Color.RED);
			l2.setBounds(10,80,200,30);
				
			l3=new JLabel("No. OF PERSONS");
			l3.setFont(f1);
			l3.setForeground(Color.RED);
			l3.setBounds(10,120,300,30);
			
			

			c.add(l1);c.add(new JLabel(""));
			c.add(l2);c.add(roomType);
			c.add(l3);c.add(nop);
			
			c.add(new JLabel(""));c.add(submit);
			
		                
		  
		                
			 setSize(450, 300);
			 setLocation(200,200);
			 setResizable(false);
			 
			 setVisible(true);	
	   }
	
	   public void createRegObj()
	   {
		   
			
			
			
			String d=(String)roomType.getSelectedItem();
			String m=(String)nop.getSelectedItem();
			
			
				 }
	   
	     public void addInformation()
	     {
	    	 String d=(String)roomType.getSelectedItem();
				String m=(String)nop.getSelectedItem();
	      
         	
         	
        
         	      new SearchType(d,m);
         	  
	     }
	         
	    
	   
	     public void resetFrame()
	     {
	    	 this.dispose();
        	 new DisplayRoomType("Room Type");
	     }
	     
	     public static void main(String[] args) 
	     {
		  new DisplayRoomType("Room Type...");
	     }
}
