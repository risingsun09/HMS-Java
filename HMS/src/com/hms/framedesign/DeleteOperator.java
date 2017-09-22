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
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DeleteOperator extends JFrame
{

	private JButton delete;
	private JLabel l1,l2,l3;
	  private JTextField opid;
	  
	  
	  public DeleteOperator(String title)
	  {
		  super(title);
		  
		/*  Container c=getContentPane();
		  c.setLayout(new GridLayout(3,1));
		  c.setBackground(Color.CYAN);
		  */
		  JPanel c = new JPanel();
		  c.setLayout(null);
		  setContentPane(c);
		  c.setBackground(Color.CYAN);
		  
		  opid=new JTextField();
		  opid.setBounds(200,80,200,30);
		  
		  delete =new JButton("DELETE OPERATOR");
		  delete.setBounds(200,150,200,30);
		  
			delete.addActionListener((e) ->
			                             {
			                            	 deleteInformation();
			                            	
			                              }
			                            );
			Font f=new Font("FORTE",Font.BOLD,30);
			l1=new JLabel("DELETE OPERATOR");
			l1.setFont(f);
			l1.setForeground(Color.BLUE);
			l1.setBounds(10,5,300,50);
					
			Font f1=new Font("comic sans ms",Font.BOLD,18);
			l2=new JLabel("Enter Operator Id");
			l2.setFont(f1);
			l2.setForeground(Color.RED);
			l2.setBounds(30,80,300,30);
			
		    c.add(l1);
		    c.add(l2);c.add(opid);
		    c.add(new JLabel(""));c.add(delete);
			
			 setSize(450, 300);
			 setLocation(200,100);
			 setResizable(false);
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 setVisible(true);	
	  }
	  
	  public void deleteInformation()
	     {
	    	 int idfoundpos = Search.searchId(opid.getText().trim());

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
	
	public static void main(String[] args) {
		
		new DeleteOperator("Delete Operator");
	}

}
