package com.hms.framedesign;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hms.filehandling.BookDetailsReadWriteFromFile;
import com.hms.filehandling.RoomDataReadWriteFromFile;
import com.hms.pojo.BookRoomPojo;
import com.hms.pojo.RoomPojo;



public class BookRoom extends JFrame
{
	private JLabel l1,l2,l3,l4,l5,l7,l8,l9,l10,l11,l12,l16,l17,l18,l19,l21;
	private JTextField billno, tname, tidno, temail, tmobno;
	private JTextArea tadd;
	private JComboBox idtype,day,month,year,rno;
	private JRadioButton rindia, rforeign, rmale, rfemale;
	private JButton bsubmit,bViewAll;
	
	private String sysdate, systime;
	
	
    
	ArrayList<BookRoomPojo> userlist;
	 ArrayList<RoomPojo> arr;
	  BookRoomPojo r;
     RoomPojo a;
	  	
	public BookRoom(String title)
	{
		super(title);
		
		Container c= getContentPane();
		c.setLayout(new GridLayout (15,2));
		//Color c1= new Color(250,224,153);
		c.setBackground(Color.CYAN);
		//c.setBackground(Color.LIGHT_GRAY);
		
		 /*tname.addFocusListener( new FocusAdapter() 
        {
           public void focusGained(FocusEvent e)
           {
                   tname.setBackground(Color.orange);
           }
        }
      );


		  
		 */
		
		tname= new JTextField(30);
		tidno= new JTextField(20);
		
		temail= new JTextField(30);
		tmobno= new JTextField(15);
		
		
		billno = new JTextField(20);
		
		Random r = new Random();
		int x= r.nextInt(9000);
		billno.setText(""+x);
		billno.setEditable(false);
		
		
		
		tadd= new JTextArea(5,20);
		JScrollPane ta= new JScrollPane(tadd);
		
		rindia= new JRadioButton("India");
		rforeign= new JRadioButton("Foreign");
		rmale= new JRadioButton("Male");
		rfemale= new JRadioButton("Female");
		
		
		 ButtonGroup rgroup1=new ButtonGroup();
		 rgroup1.add(rindia);
		 rgroup1.add(rforeign);
		 ButtonGroup rgroup2=new ButtonGroup();
		 rgroup2.add(rmale);
		 rgroup2.add(rfemale);
		 ButtonGroup rgroup3=new ButtonGroup();
		 
		 
		 JPanel gpanel= new JPanel();
		 gpanel.add(rindia);
		 gpanel.add(rforeign);
		 
		 JPanel hpanel= new JPanel();
		 hpanel.add(rmale);
		 hpanel.add(rfemale);
		 
		 
		 
	
		 String dvalue[]=new String[31];
		   for(int i=0;i<=30;i++)
		   {
				dvalue[i]=String.valueOf(i+1);
		   }
		   day=new JComboBox(dvalue);
				
		   String mvalue[]=new String[12];
		   for(int i=0;i<=11;i++)
		   {
				mvalue[i]=String.valueOf(i+1);
		   }
		   month=new JComboBox(mvalue);
				
		   String yvalue[]=new String[90];
		   int cnt=0;
		   for(int i=1926;i<=2015;i++)
		   {
				yvalue[cnt]=String.valueOf(i);
				cnt++;	
		   }
		   year=new JComboBox(yvalue);
			
		    JPanel cpanel=new JPanel();
		    cpanel.add(day);
			cpanel.add(month);
			cpanel.add(year);
	
			String idvalue[]={"Passport","Voter ID","UID Aadhar","Others"};
            idtype= new JComboBox(idvalue);
            	 
            
            rno = new JComboBox<String>();
            
            ArrayList<RoomPojo> arrm = RoomDataReadWriteFromFile.readDataFromFile();
            
            for(RoomPojo rm : arrm )
            {
            	if(!rm.isAllocate())
            		rno.addItem(rm.getRoomno());
            	
            	
            }
			Font f=new Font("AR DESTINY",Font.BOLD,22);
			l1=new JLabel("GUEST Information");
			l1.setFont(f);
			l1.setForeground(Color.BLUE);
			
			Font f1=new Font("comic sans ms",Font.BOLD,19);
			l2=new JLabel("Room No.");
			l2.setFont(f1);
			l2.setForeground(Color.RED);
			
			l3=new JLabel("Name");
			l3.setFont(f1);
			l3.setForeground(Color.RED);
			
			l4=new JLabel("Nationality");
			l4.setFont(f1);
			l4.setForeground(Color.RED);
			
			l5=new JLabel("Gender");
			l5.setFont(f1);
			l5.setForeground(Color.RED);
			
			
			l7=new JLabel("types of ID Card");
			l7.setFont(f1);
			l7.setForeground(Color.RED);
			
			l8=new JLabel("Identification No.");
			l8.setFont(f1);
			l8.setForeground(Color.RED);
			
			l9=new JLabel("Email ID");
			l9.setFont(f1);
			l9.setForeground(Color.RED);
			
			l10=new JLabel("Mobile No.");
			l10.setFont(f1);
			l10.setForeground(Color.RED);
			
			l11=new JLabel("Address");
			l11.setFont(f1);
			l11.setForeground(Color.RED);
			
			l12=new JLabel("Date of Birth");
			l12.setFont(f1);
			l12.setForeground(Color.RED);
			
			
			
			
			l16=new JLabel("Date");
			l16.setFont(f1);
			l16.setForeground(Color.RED);
			
			LocalDate today = LocalDate.now();
			int day = today.getDayOfMonth();
	  		int month = today.getMonthValue();
	  		int year = today.getYear();
				
			sysdate = day+"/"+month+"/"+year;
			l18=new JLabel(sysdate);		
			
			LocalTime time = LocalTime.now();
			int hr = time.getHour();
	 		int min = time.getMinute();
	 		int sec = time.getSecond();
			
	 		
			
			l17=new JLabel("Check_In Time");
			l17.setFont(f1);
			l17.setForeground(Color.RED);
			
			systime = hr+":"+min+":"+sec;
			l19=new JLabel(systime);	
			
			l21=new JLabel("Bill No. ");
			l21.setFont(f1);
			l21.setForeground(Color.RED);
			
			//Color a=new Color(250,75,125);	
			bsubmit = new JButton("Submit");
			//bsubmit.setBackground(a);
			
			bsubmit.addActionListener((e) ->
                                       {
                                    	   addInformation();
                                       }
									 );
				
			   
			//Color d=new Color(20,180,215);	
			bViewAll = new JButton("ViewAll");
			//bViewAll.setBackground(d);
			bViewAll.addActionListener((e) ->
                                       {
                                    	   new ViewAllBookedRooms();
                                       }
									 );
			c.add(l1);c.add(new JLabel(""));
			c.add(l21);c.add(billno);
			c.add(l2);c.add(rno);
			c.add(l3);c.add(tname);
			c.add(l4);c.add(gpanel);  
			c.add(l5);c.add(hpanel);
			c.add(l7);c.add(idtype);
			c.add(l8);c.add(tidno);
			c.add(l9);c.add(temail);
			c.add(l10);c.add(tmobno);
			c.add(l11);c.add(ta);
			c.add(l12);c.add(cpanel);
			c.add(l16);c.add(l18);
			c.add(l17);c.add(l19);
			c.add(bsubmit);c.add(bViewAll);
			
			
		    
		    
			 setSize(450, 600);
			 setLocation(350,75);
			 setResizable(true);
			// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 setVisible(true);	
			 
			 
	   }
	
	
	public boolean dataValidation()
	   {
		   boolean namevalidation = nameCheck();
		   boolean emailvalidation = emailcheck();
		   boolean mobnovalidation = mobnocheck();
		                                                                       
		   if (namevalidation && emailvalidation && mobnovalidation )
			   return true;
		
		   return false;
	   }
	public boolean nameCheck()
	   {
		  boolean namevalid = true;
	      String namepattern = "^[a-zA-Z]{3,20}$";
	    	
	      Scanner sc1 = new Scanner(tname.getText().trim());
	    	
	      String match = sc1.findInLine(namepattern);
	    	
	      if (match == null)
	      {
	    	  JOptionPane.showMessageDialog(this, "Invalid Name..Please Enter Another Name");
	    	  tname.setText("");
	    	  tname.setBackground(Color.RED);
	       	  namevalid = false;
	      }
	      return namevalid;
	   }
	   
	   public boolean emailcheck()
	    {
		    boolean emailvalid = true;
	    	String emailpattern = "^(\\w)+@(\\w+\\.)(\\w+\\.)?[A-Za-z]+$";
	    	
	    	Scanner sc2 = new Scanner(temail.getText().trim());
	    	
	    	String match1 = sc2.findInLine(emailpattern);
	    	
	    	if (match1 == null)
	    	{
	    	   JOptionPane.showMessageDialog(this, "Invalid EmailId..Please Enter Another Email");
		       temail.setText("");
		      // temailid.setBackground(Color.RED);
		       emailvalid = false;
	    	}
	    	
	    	return emailvalid;
	    }
	
	   public boolean mobnocheck()
	   {
		   boolean mobilenovalid = true;
		   
		   String mobnopattern = "^[0-9]{10}$";
	    	
	       Scanner sc3 = new Scanner(tmobno.getText().trim());
	    	
	       String match2 = sc3.findInLine(mobnopattern);
	    	
	    	if (match2 == null)
	    	{
	    		 JOptionPane.showMessageDialog(this, "Invalid Mobno..Please Enter Another MobNo");
			     tmobno.setText("");
			   //  tmobno.setBackground(Color.RED);
			     mobilenovalid = false;
	    	}
		   	return mobilenovalid;
	    }
	
	   

	   
	   
	   
	   public void createRegObj()
	   {
		    String billn,roomno,name,id,idno,emailid,mobno,add,dob,adultno,childno,gn,sta,con;
			
		    billn=billno.getText().trim();
		    
			roomno=rno.getSelectedItem().toString();
			name = tname.getText().trim();
			emailid = temail.getText().trim();
			mobno = tmobno.getText().trim();
			add=tadd.getText().trim();
			idno=tidno.getText().trim();
			
			
			id=(String)idtype.getSelectedItem();
			
			gn="";
			if(rmale.isSelected())
			{
				gn="Male";
			}
			else if(rfemale.isSelected())
			{
				gn="Female";
			}
			
			
			con="";
			if(rindia.isSelected())
			{
				con="India";
			}
			else if(rforeign.isSelected())
			{
				con="Foreign";
			}
			
			String d=(String)day.getSelectedItem();
			String m=(String)month.getSelectedItem();
			String y=(String)year.getSelectedItem();
			dob=d + "-" + m + "-" + y;
			
			r=new BookRoomPojo(billn,roomno,name,gn,con,id,idno,dob,add,emailid,mobno,sysdate,systime);
		
	   }
	   
	   public void addInformation()
	     {
		   
	    	boolean isdatavalidate = dataValidation(); 
       	if(isdatavalidate)
       	{
       		arr = RoomDataReadWriteFromFile.readDataFromFile();
	    	   createRegObj();
	    	
       	/*   int roomfoundpos = BookRoomSearch.searchRoomno(r);
       	
       	   if(roomfoundpos >= 0)
       	   {
       		   JOptionPane.showMessageDialog(this, "ROOM BOOKED..PLEASE ENTER ANOTHER ROOM_NO...");
       	   }
       	   else
       	   {*/
       	       int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Book?");
			       if(con==JOptionPane.YES_OPTION)
			       {
				      userlist = BookDetailsReadWriteFromFile.readDataFromFile();
				      userlist.add(r);
				      BookDetailsReadWriteFromFile.writeDatatoFile(userlist);
				      JOptionPane.showMessageDialog(this, "Booking Successful...");
				      
				      int x = 0;
				   
						for(RoomPojo re : arr)
						{
							if(re.getRoomno().equals(rno.getSelectedItem().toString()))
							{
							   re.setAllocate(true);
							   arr.set(x, re);
							   break;
							}
							x++;
						}   
						RoomDataReadWriteFromFile.writeDatatoFile(arr);
						
						
				      resetFrame();
			       }
       	    }
       //	}
	 }
	   
	   
	  
	   public void resetFrame()
    {
   	 this.dispose();
   	 new BookRoom("Book_Room");
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new BookRoom("Book_Room");
	}
	
}
