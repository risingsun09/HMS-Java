package com.hms.framedesign;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.hms.filehandling.BookDetailsReadWriteFromFile;
import com.hms.filehandling.FoodDetailsReadWriteFromFile;
import com.hms.filehandling.RoomDataReadWriteFromFile;
import com.hms.pojo.BookRoomPojo;
import com.hms.pojo.FoodPojo;
import com.hms.pojo.RoomPojo;

@SuppressWarnings("serial")
public class FoodBill extends JFrame
{
		private JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
		private JTextField tbillno,tname,tbreak,tlun,tdin,ttotal,tqb,tql,tqt,tqd;
		private JRadioButton rveg,rnveg;
		private JButton btotal,bbreak,blun,bdin,name;
		private String sysdate,systime, foodType;
        String n;
        boolean al;
	    ArrayList<FoodPojo> userlist;
	    FoodPojo r;
	    ArrayList<BookRoomPojo> ar;
		  BookRoomPojo b;
              ArrayList<RoomPojo> ab;
		  RoomPojo c;
		public FoodBill(String title)
		  {
			  super(title);
		  
			  Container c=getContentPane();
			  c.setLayout(new GridLayout(9,4));
			 // c.setBackground(Color.orange);
			  //Color c1= new Color(250,224,153);
		      c.setBackground(Color.CYAN);
			  tbillno=new JTextField(6);
			  tname = new JTextField(20);
			  tbreak = new JTextField(2);
			  tlun = new JTextField(2);
			 
			  tdin = new JTextField(2);
			  tqb = new JTextField(2);
			  tql = new JTextField(2);
			  tqt = new JTextField(2);
			  tqd = new JTextField(2);
			  ttotal = new JTextField(2);
			  
			  rveg=new JRadioButton("Veg");
			  rnveg=new JRadioButton("Non-Veg");
			 
			   ButtonGroup rgroup=new ButtonGroup();
			   rgroup.add(rveg);
			   rgroup.add(rnveg);
			   
			   
			   Font f1=new Font("comic sans ms",Font.BOLD,20);
				l0=new JLabel("Food-Bill");
				l0.setFont(f1);
				l0.setForeground(Color.BLUE);
			   
			   Font f=new Font("comic sans ms",Font.BOLD,14);
				l1=new JLabel("Bill No");
				l1.setFont(f);
				l1.setForeground(Color.RED);
				
				l2=new JLabel("    Date:");
				l2.setFont(f);
				l2.setForeground(Color.RED);
				
				l9=new JLabel("Food_Type:");
				l9.setFont(f);
				l9.setForeground(Color.RED);

				
				l4=new JLabel("Quantity");
				l4.setFont(f);
				l4.setForeground(Color.black);
				
				l5=new JLabel("Amounts");
				l5.setFont(f);
				l5.setForeground(Color.black);
				
				LocalDate today = LocalDate.now();
				int day = today.getDayOfMonth();
		  		int month = today.getMonthValue();
		  		int year = today.getYear();
					
				sysdate = day+"/"+month+"/"+year;
				l6=new JLabel(sysdate);
				
				l8=new JLabel("    Time:");
				l8.setFont(f);
				l8.setForeground(Color.RED);
				
				LocalTime time = LocalTime.now();
				int hr = time.getHour();
		 		int min = time.getMinute();
		 		int sec = time.getSecond();
				
		 		systime = hr+":"+min+":"+sec;
				l7=new JLabel(systime);
				
				btotal =new JButton("Total Amount");
				//Color i=new Color(150,100,210);	
				//btotal.setBackground(i);
				bbreak =new JButton("Rupees");
				//Color j=new Color(250,224,253);	
				//bbreak.setBackground(j);
				blun =new JButton("Rupees");
				
				bdin =new JButton("Rupees");
				//Color w=new Color(250,224,153);	
				//bdin.setBackground(w);
				
				Font f2=new Font("Lucida Sans",Font.BOLD,14);
				l10=new JLabel("Breakfast");
				l10.setFont(f2);
				l10.setForeground(Color.BLACK);
				
				l11=new JLabel("Lunch");
				l11.setFont(f2);
				l11.setForeground(Color.BLACK);
				
				
				l13=new JLabel("Dinner");
				l13.setFont(f2);
				l13.setForeground(Color.BLACK);
				bbreak.addActionListener((e) ->
				                             {
				                            	breaktot();
				                            	
				                              }
				                            );
				name=new JButton("NAME");
				//Color x=new Color(100,185,200);	
				//name.setBackground(x);

				name.addActionListener((e) ->
	            							{
	            							   nam();
	            							}
										  );
				blun.addActionListener((e) ->
                {
               	luntot();
               	
                 }
               );
				
				bdin.addActionListener((e) ->
                {
               	dintot();
               	
                 }
               );
				btotal.addActionListener((e) ->
                {
               	tot();
               	
                 }
               );
				c.add(l0);c.add(new JLabel(""));c.add(new JLabel(""));c.add(new JLabel(""));
				c.add(l1);c.add(tbillno);c.add(l2);c.add(l6);
				c.add(name);c.add(tname);c.add(l8);c.add(l7);
				c.add(l9);c.add(new JLabel(""));c.add(rveg);c.add(rnveg);
				c.add(new JLabel(""));c.add(l4);c.add(new JLabel(""));c.add(l5);
				c.add(l10);c.add(tqb);c.add(bbreak);c.add(tbreak);
				c.add(l11);c.add(tql);c.add(blun);c.add(tlun);
				
				c.add(l13);c.add(tqd);c.add(bdin);c.add(tdin);
				c.add(new JLabel(""));c.add(new JLabel(""));c.add(btotal);c.add(ttotal);
				
				setSize(450, 600);
				 setLocation(400,100);
				 setResizable(false);
				 //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 setVisible(true);	
		   }
		 public void createRegObj()
		   {
			    String roomno, name,breakfast,lunch,tiffin, dinner, quanb,quanl,quant,quand, date, time;
			    roomno=tbillno.getText().trim();
				name=tname.getText().trim();
				breakfast= tbreak.getText().trim();
				lunch=tlun.getText().trim();
				
				dinner=tdin.getText().trim();
				quanb=tqb.getText().trim();
				quanl=tql.getText().trim();
				quant=tqt.getText().trim();
				quand=tqd.getText().trim();
			    foodType="";
				if(rveg.isSelected())
				{
					foodType="VEG";
					
				}
				else if(rnveg.isSelected())
				{
					foodType="NON VEG";
					
				}
				String t = ttotal.getText();
				r=new FoodPojo( roomno,name,t,foodType,breakfast,lunch,tbillno.getText(),dinner,quanb,quanl,quant,quand,sysdate,systime);
			 }
		 
		 public void nam()
		  {
			  ArrayList<BookRoomPojo> ar = BookDetailsReadWriteFromFile.readDataFromFile();
		  		 int x = 0;
				   
					for(BookRoomPojo re : ar)
					{
						if(re.getBillno().equals(tbillno.getText().trim()))
						{ 
						   n=re.getName(); 
						  
						  
						}
						x++;
					}   
					tname.setText(n);
		  }
		 
		/* public void nam()
		  {
			 //ab = RoomDataReadWriteFromFile.readDataFromFile();
			  //ar = BookDetailsReadWriteFromFile.readDataFromFile();
		  		 int x = 0;
		  		ArrayList<FoodPojo> fpo = FoodDetailsReadWriteFromFile.readDataFromFile();
		  		
		  		 for(FoodPojo fp : fpo)
		  		 {
		  			 if(tbillno.getText().trim().equals(fp.getBillno()))
		  			 {
		  				 tname.setText(fp.getName());
		  				 break;
		  			 }	
		  			 else
		  			 {
		  				 JOptionPane.showMessageDialog(this, "Enter Valid Bill No.");
		  			 }
		  		 }
		  		 
		  		/*for(RoomPojo are : ar)
				{
					if(are.get().equals(troomno.getText().trim()))
					{ 
					    al=are.isAllocate(); 
					}
				}
		  		if(al)
		  		{
					for(BookRoomPojo re : ar)
					{
						if(re.getRoomno().equals(troomno.getText().trim()))
						{ 
						   n=re.getName(); 
						  
						  
						}
						x++;
					}   
					tname.setText(n);
		  		}
		  		else
		  		{
		  			JOptionPane.showMessageDialog(this, " ROOM NOT ALLOCATED...");
		  		}
		  }   */
		public void breaktot()
		{
			String brea;
			int b;
			if(rveg.isSelected())
			{
			brea=tqb.getText();
			b=Integer.parseInt(brea)*150;
			tbreak.setText(""+b);
			}
			else if(rnveg.isSelected())
			{
				brea=tqb.getText();
				b=Integer.parseInt(brea)*200;
				tbreak.setText(""+b);
			}
		}
		public void luntot()
		{
			String lun;
			int l;
			if(rveg.isSelected())
			{
				lun=tql.getText();
				
				l=Integer.parseInt(lun)*450;
				
				tlun.setText(""+l);
			}
			else if(rnveg.isSelected())
			{
                lun=tql.getText();
				
				l=Integer.parseInt(lun)*500;
				
				tlun.setText(""+l);
			}
		}
		public void addInfo()
		{
			createRegObj();
			ArrayList<FoodPojo> fp = FoodDetailsReadWriteFromFile.readDataFromFile();
			fp.add(r);
			FoodDetailsReadWriteFromFile.writeDatatoFile(fp);
			
		}
		
		public void dintot()
		{
			String din;
			int d;
			if(rveg.isSelected())
			{
			din=tqd.getText();
			
			d=Integer.parseInt(din)*350;
			
			tdin.setText(""+d);
			}
			else if(rnveg.isSelected())
			{
				din=tqd.getText();
				
				d=Integer.parseInt(din)*400;
				
				tdin.setText(""+d);
			}
		}
		public void tot()

		{
			
			String brea,lun,din;
			int b,l,t,d,tot,to;
			if(rveg.isSelected())
			{
			brea=tqb.getText();
			lun=tql.getText();
			
			din=tqd.getText();
			b=Integer.parseInt(brea)*150;
			l=Integer.parseInt(lun)*450;
			
			d=Integer.parseInt(din)*350;
			to=b+l+d;
			
			ttotal.setText(""+to);
			}
			else if(rnveg.isSelected())
			{
				brea=tqb.getText();
				lun=tql.getText();
				
				din=tqd.getText();
				b=Integer.parseInt(brea)*200;
				l=Integer.parseInt(lun)*500;
				
				d=Integer.parseInt(din)*400;
				tot=b+l+d;
				ttotal.setText(""+tot);
				
			}
			
			addInfo();
			
			
			
		}
		public static void main(String[] args) 
	     {
		
			new FoodBill("Food_Bill...");
	     }
}
