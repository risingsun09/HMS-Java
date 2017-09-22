package com.hms.framedesign;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.hms.framedesign.AdminLoginPage;

public class Welcome extends JFrame
{
	private JLabel l1,l2;
	 
	  private JButton admin,operator;
	  
	  public Welcome()
	  {
		  super("WELCOME");
		  Container c=getContentPane();
		  c.setLayout(new GridLayout(4,4));
		  c.setBackground(Color.BLUE);
		  
		  Color r=new Color(200,200,200);	
		  admin =new JButton("ADMIN");
		 // admin.setBackground(r);
			admin.addActionListener((e) ->
			                             {
			                            	new AdminLoginPage("LOGIN PAGE");
			                            	
			                              }
			                            );
         
		  
		  operator =new JButton("OPERATOR");
		  operator.addActionListener((e)->
		                                 {
			                               new OperatorLoginPage("OPERATOR LOGIN");
		                                 }
	                                   );
		  
		  Font f=new Font("ALGERIAN",Font.BOLD,38);
		  {
			l1 = new JLabel("         WELCOME TO THE ");
			l1.setFont(f);
			l1.setForeground(Color.BLACK);
		  }
         
				
		  Font f1=new Font("ALGERIAN",Font.BOLD,50);
		  {
			l2=new JLabel("    BLUE SAPPHIRE");
			l2.setFont(f1);
			l2.setForeground(Color.RED);
		  }

			c.add(l1);c.add(l2);
			c.add(admin);
			c.add(operator);
						
	  
		  setSize(550, 400);
		 setLocation(200,200);
		 setResizable(false);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setVisible(true);	
	  }

	public static void main(String[] args) 
	{
		Welcome obj = new Welcome();
		
    }

}
