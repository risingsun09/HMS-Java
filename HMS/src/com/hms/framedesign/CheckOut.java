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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hms.filehandling.BookDetailsReadWriteFromFile;
import com.hms.filehandling.FoodDetailsReadWriteFromFile;
import com.hms.filehandling.RoomDataReadWriteFromFile;
import com.hms.filehandling.RoomIncomeReadWriteFromFile;
import com.hms.pojo.BookRoomPojo;
import com.hms.pojo.FoodPojo;
import com.hms.pojo.RoomIncomePojo;
import com.hms.pojo.RoomPojo;



public class CheckOut extends JFrame
{
	  private JLabel l1,l2,l3,l4,l5,l6,l7,l9,l10,l11,l12,l13,l14;
	  private JTextField troomno,tfoodbill,tname,ttariff,troomrent,tstayingdays,tvatcharge,ttotal,tbill;
	  private JButton broomrent,bvat,btotal,paid,tarrif,bname,foodbill;
	  private String sysdate,systime;
	  double roomtot;
	  String t,n;
	  ArrayList<RoomPojo> arr;
	  RoomPojo a;
	  
	  BookRoomPojo b;
	  ArrayList<FoodPojo> arfood;
	  
	  
	  public CheckOut(String title)
	  {
		  super(title);
	  
		  Container c=getContentPane();
		  c.setLayout(new GridLayout(14,2));
		  c.setBackground(Color.yellow);
		  Color c1= new Color(250,224,153);
	      c.setBackground(Color.cyan);
		  tname = new JTextField(20);
		  troomno =new JTextField(6);
		  ttariff =new JTextField(5);
		  tstayingdays=new JTextField(3);
		  troomrent = new JTextField(6);
		  tvatcharge = new JTextField(4);
		  tbill = new JTextField(10);
		  ttotal = new JTextField(7);
		  		tbill = new JTextField(10); 
		  		tfoodbill = new JTextField(10);
		  /*troomno.addFocusListener( new FocusAdapter() 
		                          {
			                         public void focusGained(FocusEvent e)
			                         {
			                        	 troomno.setBackground(Color.white);
			                         }
		                          }
			                    );
		 */
		  tstayingdays.addFocusListener( new FocusAdapter() 
          {
             public void focusGained(FocusEvent e)
             {
            	 tstayingdays.setBackground(Color.LIGHT_GRAY);
             }
          }
        );
	
			Font f=new Font("Algerian",Font.BOLD,27);
			l1=new JLabel("CHECK OUT");
			l1.setFont(f);
			l1.setForeground(Color.BLUE);
				
			Font f1=new Font("Times New Roman",Font.BOLD,18);
			l2=new JLabel("Name");
			l2.setFont(f1);
			l2.setForeground(Color.RED);
				
			l3=new JLabel("Room No ");
			l3.setFont(f1);
			l3.setForeground(Color.RED);
			
			l4=new JLabel("Tariff");
			l4.setFont(f1);
			l4.setForeground(Color.RED);
			
			l5=new JLabel("Staying Days");
			l5.setFont(f1);
			l5.setForeground(Color.RED);
			
			l6=new JLabel("Room_Rent");
			l6.setFont(f1);
			l6.setForeground(Color.RED);
			
			l7=new JLabel("Vat Charge");
			l7.setFont(f1);
			l7.setForeground(Color.RED);
			
			
				
			l9=new JLabel("Total");
			l9.setFont(f1);
			l9.setForeground(Color.RED);
		
			l10=new JLabel("Date:");
			l10.setFont(f1);
			l10.setForeground(Color.RED);
			
			LocalDate today = LocalDate.now();
			int day = today.getDayOfMonth();
	  		int month = today.getMonthValue();
	  		int year = today.getYear();
				
			sysdate = day+"/"+month+"/"+year;
			l11=new JLabel(sysdate);
			
			l12=new JLabel("Time:");
			l12.setFont(f1);
			l12.setForeground(Color.RED);
			
			
			l14=new JLabel("Bill No");
			l14.setFont(f1);
			l14.setForeground(Color.RED);
			
			LocalTime time = LocalTime.now();
			int hr = time.getHour();
	 		int min = time.getMinute();
	 		int sec = time.getSecond();
			
	 		systime = hr+":"+min+":"+sec;
			l13=new JLabel(systime);

				
			btotal =new JButton("Total Amount");
			foodbill = new JButton("Food Bill");
			
				
			broomrent =new JButton("Room_Rent");
			
			
			
			bvat =new JButton("Vat Charges");
		
			
			
			
			
			
				
			paid=new JButton("PAY NOW");
			
			paid.addActionListener((e) ->
            							{
            							   addInfo();
            							}
									  );
				
			
			
			tarrif=new JButton("Tariff");
			
			tarrif.addActionListener((e) ->
            							{
            							   tarr();
            							}
									  );
			
			bname=new JButton("Name");
			
			bname.addActionListener((e) ->
            							{
            							   nam();
            							}
									  );
			broomrent.addActionListener((e) ->
            								{
            										rrent();
           	
            								}
											);
			
			bvat.addActionListener((e) ->
										{
													vat();

										}
										);

			
			btotal.addActionListener((e) ->
			{
						total();

			}
			);	
			foodbill.addActionListener((e) ->
			{
				//JOptionPane.showMessageDialog(this, "HI....");		
				getFoodBill();

			}
			);
			
			c.add(l1);c.add(new JLabel(""));
			c.add(l14);c.add(tbill);
			c.add(l3);c.add(troomno);
			c.add(bname);c.add(tname);
			c.add(tarrif);c.add(ttariff);
			c.add(l5);c.add(tstayingdays);
			c.add(broomrent);c.add(troomrent);
			c.add(bvat);c.add(tvatcharge);
			
			c.add(foodbill);c.add(tfoodbill);
			
			c.add(btotal);c.add(ttotal);
			c.add(l10);c.add(l11);
			c.add(l12);c.add(l13);
			c.add(new JLabel(""));c.add(paid);
	
		  
		                
			 setSize(450, 600);
			 setLocation(200,100);
			 setResizable(true);
			 //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 setVisible(true);	
	   }
	  public void nam()
	  {
		  ArrayList<BookRoomPojo> ar = BookDetailsReadWriteFromFile.readDataFromFile();
	  		 int x = 0;
			   
				for(BookRoomPojo re : ar)
				{
					if(re.getBillno().equals(tbill.getText().trim()))
					{ 
					   n=re.getName(); 
					  
					  
					}
					x++;
				}   
				tname.setText(n);
	  }
        public void tarr()
        {
        	arr = RoomDataReadWriteFromFile.readDataFromFile();
	  		 int x = 0;
			   
				for(RoomPojo re : arr)
				{
					if(re.getRoomno().equals(troomno.getText().trim()))
					{ 
					   t=re.getTarrif(); 
					  
					  
					}
					x++;
				}   
				ttariff.setText(t);
        }
	  	public void rrent()
		{
			String btarif,bdays;
			int rr;
			btarif=t;
			bdays=tstayingdays.getText();
			rr=Integer.parseInt(btarif)*Integer.parseInt(bdays);
			troomrent.setText(""+rr);
		}
	
	  	public void vat()
		{
			String bvat;
			double v;
			bvat=troomrent.getText();
			v=Integer.parseInt(bvat)*(0.14);
			tvatcharge.setText(""+v);
		}
	  	
	  	
	  	
	  	public void total()
		{
	  		String broom,vat,bvat,btarif,bdays,fbill;
			double r,v,s,tot;
			broom=troomrent.getText();
			vat=tvatcharge.getText();
			
			fbill=tfoodbill.getText();
			
			bvat=troomrent.getText();
			btarif=t;
			bdays=tstayingdays.getText();
			r= Integer.parseInt(btarif)*Integer.parseInt(bdays);
			v=Integer.parseInt(bvat)*(0.14);
			s=Integer.parseInt(fbill);
			tot=r+v+s;
		    roomtot = r+v;
			
			
			ttotal.setText(""+tot);
			
		}
	  	
	  	
	  	public void getFoodBill()
	  	{
	  		
	  		ArrayList<FoodPojo> qw;
	  		qw = FoodDetailsReadWriteFromFile.readDataFromFile();
	  		
	  		for(FoodPojo f : qw)
	  		{
	  			
	  			if(f.getBillno().equals(tbill.getText()))
	  			{
	  				
	  				tfoodbill.setText(f.getTotal().toString());
	  				break;
	  			}
	  		}
	  		
	  	}
	  	public void addInfo()
	  	{
	  		
	  		boolean q=true,fl=false;
	  		arr = RoomDataReadWriteFromFile.readDataFromFile();
	  		ArrayList<BookRoomPojo> arbookr;
	  		arbookr = BookDetailsReadWriteFromFile.readDataFromFile();
	  		
	  		 int x = 0;
			   
	  		 for(BookRoomPojo br : arbookr)
	  		 {
	  			 if(br.getBillno().equals(tbill.getText().trim()))
	  			 {
	  				 fl=true;
	  			 }
	  		 }
				for(RoomPojo re : arr)
				{
					
					if(fl && re.getRoomno().equals(troomno.getText().trim())  )
					{ 
						q=false;
					   re.setAllocate(false);
					   arr.set(x, re);
					   addInfoToRoomIncome();
					   JOptionPane.showMessageDialog(this, " THANK YOU FOR STAYING WITH US...");
					    
					    
					   break;
					}
					x++;
				} 
				
				if(q)
				{	JOptionPane.showMessageDialog(this, " PLEASE ENTER CORRECT DETAILS.");
					return;
				}
				
				RoomDataReadWriteFromFile.writeDatatoFile(arr);
				
				
	                                     
				
		      resetFrame();   
	  	}
	  	
	  	public void addInfoToRoomIncome()
	  	{
	  		String rtotal,rno;
	  		RoomIncomePojo rip;
	  		ArrayList<RoomIncomePojo> arip;
	  		rtotal=Double.toString(roomtot);
	  		rno=troomno.getText();
	  		int x = SearchRoomIncome.searchRoomIncome(rno);
	  		
	  		try
	  		{
	  		if( x >=0)
	  		{
	  			
	  			
	  			arip=RoomIncomeReadWriteFromFile.readDataFromFile();
	  			String totinc = arip.get(x).getTotalincome();
	  			double dd = Double.parseDouble(rtotal)+Double.parseDouble(totinc);
	  			rtotal=Double.toString(dd);
	  			rip=new RoomIncomePojo(rno, rtotal);
	  			arip.set(x, rip);
	  			
	  			RoomIncomeReadWriteFromFile.writeDataIntoFile(arip);
	  		}
	  		else
	  		{
	  			rip=new RoomIncomePojo(rno, rtotal);
	  			arip=RoomIncomeReadWriteFromFile.readDataFromFile();
	  			arip.add(rip);
	  			RoomIncomeReadWriteFromFile.writeDataIntoFile(arip);
	  			
	  		}
	  		}catch(Exception e)
	  		{
	  			System.out.println(e);
	  			
	  		}
	  		
	  	} 
	  /*	public void addInfoToRoomIncome()
	  	{
	  		String rtotal,rno;
	  		RoomIncomePojo rip;
	  		ArrayList<RoomIncomePojo> arip;
	  		rtotal=Double.toString(roomtot);
	  		rno=troomno.getText();
	  		
	  		
	  		try
	  		{
	  		
	  			
	  			
	  			arip=RoomIncomeReadWriteFromFile.readDataFromFile();
	  			
	  			
	  			rip=new RoomIncomePojo(rno, rtotal);
	  			arip.add(rip);
	  			
	  			RoomIncomeReadWriteFromFile.writeDataIntoFile(arip);
	  		
	  		}catch(Exception e)
	  		{
	  			System.out.println(e);
	  			
	  		}
	  		
	  	} */
	  	
	    public void resetFrame()

	    {
	   	 this.dispose();
	   	 new CheckOut("Check Out...");
	    }
	   
	    public void deleteInformation()
	     {
	    	 
          int roomnofoundpos = BookRoomSearch.searchRoomno(troomno.toString());

          if(roomnofoundpos >= 0)
          {
         	 BookRoomDetailsDelete.deleteInfoData(roomnofoundpos);
             
          }
          
	     }
		
	    
	  	public static void main(String[] args) 
	     {
		  new CheckOut("Check_Out......");
	     }
}

