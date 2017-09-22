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

import com.hms.filehandling.UserDataReadWriteFromFile;
import com.hms.pojo.OperatorRegistrationPojo;

public class OperatorRegistration extends JFrame
{
	  private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	  private JTextField tid,tname,temailid,tmobno;
	  private JPasswordField tpass;
	  private JTextArea tadd;
	  private JComboBox city,day,month,year;
	  private JRadioButton rmale,rfemale;
	  private JButton submit,update,delete;
	
	   ArrayList<OperatorRegistrationPojo> userlist;
	  
	  OperatorRegistrationPojo r;
	
	  public OperatorRegistration(String title)
	  {
		  super(title);
	  
		  Container c=getContentPane();
		  c.setLayout(new GridLayout(11,2));
		  c.setBackground(Color.CYAN);
				
		  tid=new JTextField(20);
		  
		  Random r = new Random();
		  int x= r.nextInt(90000);
		  tid.setText(""+x);
		  tid.setEditable(false);
		  
		  tpass=new JPasswordField(20);
		  tname = new JTextField(20);
		 /* tname.addFocusListener( new FocusAdapter() 
		                          {
			                         public void focusGained(FocusEvent e)
			                         {
       	                                  tname.setBackground(Color.WHITE);
			                         }
		                          }
			                    );
		 */
		  temailid = new JTextField(20);
		  tmobno = new JTextField(20);
		  
		  tadd=new JTextArea(5,20);
		  JScrollPane tapan=new JScrollPane(tadd);
				
		  String ctvalue[]={"Kolkata","Delhi","Mumbai","Chennai","Hydrabad","Pune","Bangalore"};
		  city=new JComboBox(ctvalue);
		 				
		  rmale=new JRadioButton("Male");
		  rfemale=new JRadioButton("Female");
		 
		   ButtonGroup rgroup=new ButtonGroup();
		   rgroup.add(rmale);
		   rgroup.add(rfemale);
		   
		   JPanel gpanel=new JPanel();
		   gpanel.add(rmale);
		   gpanel.add(rfemale);
				
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
				
		   String yvalue[]=new String[100];
		   int cnt=0;
		   for(int i=1950;i<=2015;i++)
		   {
				yvalue[cnt]=String.valueOf(i);
				cnt++;	
		   }
		   year=new JComboBox(yvalue);
			
		    JPanel cpanel=new JPanel();
		    cpanel.add(day);
			cpanel.add(month);
			cpanel.add(year);
			submit =new JButton("SUBMIT");
			
			submit.addActionListener((e) ->
			                             {
			                            	addInformation();
			                              }
			                            );
				
            update =new JButton("UPDATE");
			
			update.addActionListener((e) ->
			                             {
			                            	updateInformation();
			                              }
			                            );
            delete =new JButton("DELETE");
			
			delete.addActionListener((e) ->
			                             {
			                            	deleteInformation();
			                              }
			                            );
			Font f=new Font("FORTE",Font.BOLD,20);
			l1=new JLabel("OPERATOR REGISTRA");
			l1.setFont(f);
			l1.setForeground(Color.BLUE);
			
			l8=new JLabel("TION FORM");
			l8.setFont(f);
			l8.setForeground(Color.BLUE);
				
			Font f1=new Font("comic sans ms",Font.BOLD,18);
			l2=new JLabel("Enter User Id");
			l2.setFont(f1);
			l2.setForeground(Color.RED);
				
			l3=new JLabel("Enter Pasword");
			l3.setFont(f1);
			l3.setForeground(Color.RED);
			
			l13=new JLabel("Enter Name");
			l13.setFont(f1);
			l13.setForeground(Color.RED);
			
			l14=new JLabel("Enter EmailId");
			l14.setFont(f1);
			l14.setForeground(Color.RED);
			
			l15=new JLabel("Enter Mob No");
			l15.setFont(f1);
			l15.setForeground(Color.RED);
				
			l4=new JLabel("Enter Address");
			l4.setFont(f1);
			l4.setForeground(Color.RED);
			
			l5=new JLabel("Select City");
			l5.setFont(f1);
			l5.setForeground(Color.RED);
				
			l6=new JLabel("Select Gender");
			l6.setFont(f1);
			l6.setForeground(Color.RED);
				
			l7=new JLabel("Select DOB");
			l7.setFont(f1);
			l7.setForeground(Color.RED);
				
				
			c.add(l1);c.add(l8);
			c.add(l2);c.add(tid);
			c.add(l3);c.add(tpass);
			c.add(l13);c.add(tname);
			c.add(l14);c.add(temailid);
			c.add(l15);c.add(tmobno);
			c.add(l4);c.add(tapan);
			c.add(l5);c.add(city);
			c.add(l6);c.add(gpanel);
			c.add(l7);c.add(cpanel);
		
			
			c.add(submit);
			c.add(update);
			//c.add(delete);
			//c.add(new JLabel(""));
			//c.add(new JLabel(""));
			           
		    setSize(450, 600);
			 setLocation(200,100);
			 setResizable(false);
			 //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 setVisible(true);	
	   }
	
	   public void createRegObj()
	   {
		    String id,pass,name,emailid,mobno,add,ct,gn,dob;
			
			id=tid.getText().trim();
			pass=tpass.getText().trim();
			name = tname.getText().trim();
			emailid = temailid.getText().trim();
			mobno = tmobno.getText().trim();
			add=tadd.getText().trim();
			ct=(String)city.getSelectedItem();
			
			gn="";
			if(rmale.isSelected())
			{
				gn="Male";
			}
			else if(rfemale.isSelected())
			{
				gn="Female";
			}
			
			String d=(String)day.getSelectedItem();
			String m=(String)month.getSelectedItem();
			String y=(String)year.getSelectedItem();
			dob=d + "-" + m + "-" + y;
			
			
			r=new OperatorRegistrationPojo(id, pass,name,emailid,mobno, add, ct, gn, dob);
		 }
	   
	     public void addInformation()
	     {
	       	int idfoundpos = Search.searchId(tid.getText().trim());
         	
         	if(idfoundpos >= 0)
         	{
         	   JOptionPane.showMessageDialog(this, "ID ALREADY EXIST..PLEASE ENTER ANOTHER ID...");
         	}
         	else
         	{
         		   createRegObj();
         	       
         		   int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Register?");
  			       if(con==JOptionPane.YES_OPTION)
  			       {
  				      userlist = UserDataReadWriteFromFile.readDataFromFile();
  				      userlist.add(r);
  				      UserDataReadWriteFromFile.writeDatatoFile(userlist);
  				      JOptionPane.showMessageDialog(this, "Registration Successful...");
  				    
  				      resetFrame();
  			       }
         	 }
	      }
	   
	     public void updateInformation()
	     {
	    	 
             int idfoundpos = Search.searchId(tid.getText().trim());

             if(idfoundpos >= 0)
             {
            	createRegObj();
            	
            	UpdateInfo.UpdateInfodata(r, idfoundpos);
                JOptionPane.showMessageDialog(this, "Information Updated...");
             }
             else
             {
                JOptionPane.showMessageDialog(this, "ID NOT FOUND..PLEASE ENTER ANOTHER ID...");
             }
	     }
	     
	     public void deleteInformation()
	     {
	    	 int idfoundpos = Search.searchId(tid.getText().trim());

             if(idfoundpos >= 0)
             {
            	 DeleteInfo.deleteInfoData(idfoundpos);
                JOptionPane.showMessageDialog(this, "Information Deleted...");
             }
             else
             {
                JOptionPane.showMessageDialog(this, "ID NOT FOUND..PLEASE ENTER ANOTHER ID...");
             }
	     }
	   
	    
	     public void resetFrame()
	     {
	    	 this.dispose();
        	 new OperatorRegistration("Operator Registration...");
	     }
	     
	     public static void main(String[] args) 
	     {
		  new OperatorRegistration("Operator Registration...");
	     }
}
