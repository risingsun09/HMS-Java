package com.hms.framedesign;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hms.pojo.OperatorRegistrationPojo;

public class OperatorLoginPage extends JFrame
{
	  private JLabel l1,l2,l3,l4,l5,l6;
	  private JTextField tid,tname;
	  private JPasswordField pass;
	 
	  private JButton submit;
	
       ArrayList<OperatorRegistrationPojo> userlist;
	  
	  OperatorRegistrationPojo r;
		
	 
	  public OperatorLoginPage(String title)
	  {
		  super(title);
	  
		  //Container c=getContentPane();
		  JPanel c = new JPanel();
		  c.setLayout(null);
		  setContentPane(c);
		  c.setBackground(Color.BLUE);
				
		  tid=new JTextField();
		  tid.setBounds(150,80,200,30);
		  pass=new JPasswordField();
		  pass.setBounds(150,120,200,30);
		  
		 /* tname.addFocusListener( new FocusAdapter() 
		                          {
			                         public void focusGained(FocusEvent e)
			                         {
       	                                  tname.setBackground(Color.GRAY);
			                         }
		                          }
			                    );
		 */
		  
		 
		  
				
			submit =new JButton("Submit");
			submit.setBounds(180,200,100,30);
			submit.addActionListener((e) ->
			                             {
			                            	addInformation();
			                            	
			                              }
			                            );
				
			
			Font f=new Font("FORTE",Font.BOLD,28);
			l1=new JLabel("OPERATOR LOGIN");
			l1.setFont(f);
			l1.setBounds(30,5,400,30);
			l1.setForeground(Color.PINK);
			
			/*l4=new JLabel("LOGIN");
			l4.setFont(f);
			l4.setBounds(150,80,200,30);
			l4.setForeground(Color.PINK);*/
				
			Font f1=new Font("comic sans ms",Font.BOLD,20);
			l2=new JLabel("User Id");
			l2.setFont(f1);
			l2.setBounds(30,80,200,30);
			l2.setForeground(Color.RED);
				
			l3=new JLabel("Pasword");
			l3.setFont(f1);
			l3.setBounds(30,120,200,30);
			l3.setForeground(Color.RED);
			
			
			c.add(l1);//c.add(l4);
			c.add(l2);c.add(tid);
			c.add(l3);c.add(pass);
			c.add(new JLabel(""));c.add(submit);
			
		                
		    
			 setSize(450, 300);
			 setLocation(200,200);
			 setResizable(false);
			// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 setVisible(true);	
	   }
	
	   
		
			 public void addInformation()
		     {
		       	int idfoundpos = Search.searchId(tid.getText().trim());
	         	
	         	if(idfoundpos >= 0)
	         	{
	         		new OperatorWelcome("Operator_Operation...");
	         	}
	         	else
	         	{
	         		   
	         	       
	         		  
	  				      JOptionPane.showMessageDialog(this, "INVALID USERID OR PASSWORD...");
	  				    
	  				      resetFrame();
	  			       }
	         	 }
		     
	   
	     public void resetFrame()
	     {
	    	 this.dispose();
        	 new OperatorLoginPage("LOGIN PAGE...");
	     }
	     
	     public static void main(String[] args) 
	     {
		  new OperatorLoginPage("LOGIN PAGE...");
	     }
}

