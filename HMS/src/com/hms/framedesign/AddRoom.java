package com.hms.framedesign;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.hms.filehandling.RoomDataReadWriteFromFile;
import com.hms.pojo.RoomPojo;

public class AddRoom extends JFrame
{
	  private JLabel l1,l2,l3,l4,l5,l6;
	  private JTextField roomno,roomtype,tarrif,numofpersons;
	  public JRadioButton rac,rnac;
	  private JButton submit,update,delete,showall;
	  
	  ArrayList<RoomPojo> userlist;
	  
	  RoomPojo r;
	
	  public AddRoom(String title)
	  {
		  super(title);
		  Color c1= new Color(250,224,153);
		  Container c=getContentPane();
		  c.setLayout(new GridLayout(7,2));
		  c.setBackground(Color.CYAN);
		  
		  roomno=new JTextField(20);
		  roomtype=new JTextField(20);
		  tarrif = new JTextField(20);
		  numofpersons = new JTextField(20);
		 
		  /*tarrif.addFocusListener( new FocusAdapter() 
          {
             public void focusGained(FocusEvent e)
             {
            	 tarrif.setBackground(Color.red);
             }
          }
        );		*/	
		  rac=new JRadioButton("A.C");
		  rnac=new JRadioButton("NON A.C");
		 
		   ButtonGroup rgroup=new ButtonGroup();
		   rgroup.add(rac);
		   rgroup.add(rnac);
		   
		   JPanel gpanel=new JPanel();
		   gpanel.add(rac);
		   gpanel.add(rnac);
				
		  // Color a=new Color(125,170,250);	
			submit = new JButton("Submit");
			//submit.setBackground(a);
			submit.addActionListener((e) ->
			                             {
			                            	addInformation();
			                            	
			                              }
			                            );
			
			//Color b=new Color(150,250,25);
			showall =new JButton("Show All");
			//showall.setBackground(b);
			showall.addActionListener((e) ->
			                             {
			                            	new DisplayAllRoom();
			                            	
			                              }
			                            );
			
			//Color d=new Color(215,250,250);			
			update=new JButton("Update");
			//update.setBackground(d);
			update.addActionListener((e) ->
                                       {
                                    	   updateInformation();
                                    	   resetFrame();
                                       }
			                        );
			
			//Color g=new Color(125,120,50);
			delete = new JButton("Delete");
			//delete.setBackground(g);
			delete.addActionListener((e) ->
                                       {
                                    	   deleteInformation();
                                       }
									 );
			
			Font f=new Font("FORTE",Font.TRUETYPE_FONT,24);
			l1=new JLabel("ADD ROOMS");
			l1.setFont(f);
			l1.setForeground(Color.BLUE);
				
			Font f1=new Font("comic sans ms",Font.BOLD,18);
				
			l2=new JLabel("SELECT ROOM NUMBER");
			l2.setFont(f1);
			l2.setForeground(Color.RED);
				
			l3=new JLabel("SELECT ROOM TYPE");
			l3.setFont(f1);
			l3.setForeground(Color.RED);
				
			l4=new JLabel("TARRIF");
			l4.setFont(f1);
			l4.setForeground(Color.RED);
				
			l5=new JLabel("NUMBER OF PERSONS");
			l5.setFont(f1);
			l5.setForeground(Color.RED);
			
			c.add(l1);c.add(new JLabel(""));
			c.add(l2);c.add(roomno);
			c.add(l4);c.add(tarrif);
			c.add(l5);c.add(numofpersons);
			c.add(l3);c.add(gpanel);
			c.add(submit);c.add(update);
			c.add(showall); c.add(delete);
			
			
		               
    		 setSize(450, 400);
			 setLocation(200,200);
			 setResizable(false);
			 
			 setVisible(true);	
	   }
	
	   public void createRegObj()
	   {
		    String rroomno,rtarrif,rnumofperson,gn;
			
			rroomno=roomno.getText().trim();
			rtarrif=tarrif.getText().trim();
			rnumofperson= numofpersons.getText().trim();
			gn="";
			if(rac.isSelected())
			{
				gn="A.C";
				
			}
			else if(rnac.isSelected())
			{
				gn="NON A.C";
				
			}
			
			r=new RoomPojo(rroomno,gn,rtarrif,rnumofperson,false);
		 }
	   
	     public void addInformation()
	     {
	       	int idfoundpos = SearchRoom.searchId(roomno.getText().trim());
         	
         	if(idfoundpos >= 0)
         	{
         	   JOptionPane.showMessageDialog(this, "");
         	}
         	else
         	{
         		   createRegObj();
         	       
         		   int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Add Room?");
  			       if(con==JOptionPane.YES_OPTION)
  			       {
  				      userlist = RoomDataReadWriteFromFile.readDataFromFile();
  				      userlist.add(r);
  				      RoomDataReadWriteFromFile.writeDatatoFile(userlist);
  				      JOptionPane.showMessageDialog(this, "Successfully Added...");
  				    
  				      resetFrame();
  			       }
         	 }
	      }
	   
	     public void updateInformation()
	     {
	    	 
             int idfoundpos = SearchRoom.searchId(roomno.getText().trim());

             if(idfoundpos >= 0)
             {
            	createRegObj();
            	
            	UpdateRoom.UpdateInfodata(r, idfoundpos);
                JOptionPane.showMessageDialog(this, "Information Updated...");
             }
             else
             {
                JOptionPane.showMessageDialog(this, "ROOM NOT FOUND..PLEASE ENTER ANOTHER ROOM...");
             }
	     }
	     
	     public void deleteInformation()
	     {
	    	 int idfoundpos = SearchRoom.searchId(roomno.getText().trim());

             if(idfoundpos >= 0)
             {
            	 DeleteRoomFromFile.deleteInfoData(idfoundpos);
                JOptionPane.showMessageDialog(this, "Room Deleted...");
             }
             else
             {
                JOptionPane.showMessageDialog(this, "ROOM NOT FOUND..PLEASE ENTER ANOTHER ROOM...");
             }
	     }
	   
	     public void resetFrame()
	     {
	    	 this.dispose();
        	 new AddRoom("Add Room");
	     }
	     
	     public static void main(String[] args) 
	     {
		  new AddRoom("Add Room");
	     }
}

