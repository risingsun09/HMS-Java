package com.hms.framedesign;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hms.framedesign.AdminOperations;



public class AdminLoginPage extends JFrame
{
	private JLabel l1,l2,l3;
	  private JTextField userid;
	  private JPasswordField password;
	 
	  private JButton submit;
	  
	  public AdminLoginPage(String title)
	  {
		super(title);
		//Container c=getContentPane();
		JPanel c = new JPanel();
		  c.setLayout(null);
		  setContentPane(c);
		c.setBackground(Color.BLUE);
		
		userid=new JTextField();
		userid.setBounds(150,80,200,30);
		  password=new JPasswordField();
		  password.setBounds(150,120,200,30);
		  
		  submit =new JButton("Submit");
		  submit.setBounds(150,180,200,30);
		  submit.addActionListener((e) ->
          {
         	addinfo();
         	
           }
         );
		  
		  	  
		  
		  Font f=new Font("FORTE",Font.BOLD,30);
			l1=new JLabel("ADMIN LOGIN");
			l1.setFont(f);
			l1.setForeground(Color.PINK);
			l1.setBounds(30,5,300,80);
				
			Font f1=new Font("comic sans ms",Font.BOLD,25);
			l2=new JLabel("User Id");
			l2.setFont(f1);
			l2.setForeground(Color.RED);
			l2.setBounds(30,80,200,30);
				
			l3=new JLabel("Pasword");
			l3.setFont(f1);
			l3.setForeground(Color.RED);
			l3.setBounds(30,120,200,30);
			
			c.add(l1);c.add(new JLabel(""));
			c.add(l2);c.add(userid);
			c.add(l3);c.add(password);
			c.add(new JLabel(""));c.add(submit);
		  
		  setSize(450,300);
			 setLocation(200,200);
			 setResizable(false);
			 
			 setVisible(true);	
	  } 
	  @SuppressWarnings("deprecation")
			 public void addinfo()
			   {
				    String id,pass;
					
					id=userid.getText().trim();
					pass=password.getText().trim();
					
					if(id.equals("ADMIN")&&pass.equals("ADMIN"))
		         	{
		         	   new AdminOperations("Admin Operations");
		         	}
		         	else
		         	{
		         		  
		  				      JOptionPane.showMessageDialog(this, "wrong id or password");
		  				    
		  				      resetFrame();
		  			 }
		         }
			      
			   
			    
			   
			     public void resetFrame()
			     {
			    	 this.dispose();
		        	 new AdminLoginPage("LOGIN PAGE");
			     }
		

	public static void main(String[] args)
	{
	     new AdminLoginPage("LOGIN PAGE");
		
	}

}
