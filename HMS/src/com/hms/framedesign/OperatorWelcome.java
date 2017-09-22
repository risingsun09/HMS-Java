package com.hms.framedesign;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;





public class OperatorWelcome extends JFrame
{
	  private JLabel l1;
	  private JButton bsearchroom,bbookroom,bcheckout,bfoodbill;
	  private final JMenuBar jmenubar;
      private final JMenu jmenu;
      private final JMenuItem jmenusearchroom,jmenubookroom,jmenucheckout,jmenufoodbill;
	  
	  public OperatorWelcome(String title)
	  {
		  super(title);
	  
		 /* Container c=getContentPane();
		  c.setLayout(new GridLayout(3,2));
		   c.setBackground(Color.BLUE);
		   */
		   JPanel c = new JPanel();
			  c.setLayout(null);
			  setContentPane(c);
			  c.setBackground(Color.CYAN);
		   
		  Font f=new Font("comic sans ms",Font.BOLD,26);
			l1=new JLabel("Ready To Operate");
			l1.setFont(f);
			l1.setForeground(Color.RED);
			l1.setBounds(100,10,400,30);

		  bsearchroom =new JButton("SEARCH ROOM");
		  bsearchroom.setBounds(70,80,300,30);
		  bbookroom=new JButton("BOOK ROOM");
		  bbookroom.setBounds(70,120,300,30);
		  bcheckout=new JButton("CHECK OUT");
		  bcheckout.setBounds(70,160,300,30);
		  bfoodbill= new JButton("FOOD_BILL");
		  bfoodbill.setBounds(70,200,300,30);
		   bsearchroom.addActionListener((e) ->
          {
         	new DisplayRoomType("Display rooms");
         	
           }
         );
			bcheckout.addActionListener((e) ->
			                             {
			                            	addcheckout();
			                            	
			                              }
			                            );
			bbookroom.addActionListener((e) ->
            {
           	  new BookRoom("Book Room");
           	
             }
           );
			
			bfoodbill.addActionListener((e) ->
            {
           	             new FoodBill("FoodBill");
           	
             }
           );
			
			c.add(l1);	
		  c.add(bsearchroom);c.add(bbookroom);
		  c.add(bcheckout);c.add(bfoodbill);
		  
          
		    jmenubar = new JMenuBar();
		                
		    jmenu = new JMenu("OPTION");
		    jmenu.setMnemonic(KeyEvent.VK_O);
		                
		     jmenusearchroom = new JMenuItem("Search Room");
		     jmenusearchroom.setMnemonic(KeyEvent.VK_R);
		     jmenusearchroom.setToolTipText("Search Room....");
		     jmenusearchroom.addActionListener((e) ->
		     {
		         	new DisplayRoomType("Display rooms");
		         	
		           }
		         );
		                
		     jmenubookroom = new JMenuItem("Book Room");
		     jmenubookroom.setMnemonic(KeyEvent.VK_A);
		     jmenubookroom.setToolTipText("Book Room.....");
		     jmenubookroom.addActionListener((e) ->
		     {
	           	//  new BookRoom("Book Room");
	           	
	             }
	           );
		                
		     jmenucheckout = new JMenuItem("Check Out");
		     jmenucheckout.setMnemonic(KeyEvent.VK_S);
		     jmenucheckout.setToolTipText("Check Out.....");
		     jmenucheckout.addActionListener((e) ->
		     {
             	addcheckout();
             	
               }
             );
		     jmenufoodbill = new JMenuItem("Food_Bill");
		     jmenufoodbill.setMnemonic(KeyEvent.VK_U);
		     jmenufoodbill.setToolTipText("Food_Bill.....");
		     jmenufoodbill.addActionListener((e) ->
		     {
   	           //  new Food Bill("Food Bill");
   	
     }
   );
		                
		     jmenu.add(jmenusearchroom);
		     jmenu.add(jmenubookroom);
		     jmenu.add(jmenucheckout);
		     jmenu.add(jmenufoodbill);
		                
		     jmenubar.add(jmenu);
		     setJMenuBar(jmenubar);
		  
			
			 setSize(450, 300);
			 setLocation(200,200);
			 setResizable(false);
			 //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 setVisible(true);	
	  }
	  
	  public void addcheckout()
	  {
		  {
       	   new CheckOut("Operator Operations...");
       	}
	  }
	  
	  public static void main(String[] args) 
		{
			new OperatorWelcome("Operator_Operation...");

		}
}

