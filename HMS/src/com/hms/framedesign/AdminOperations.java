package com.hms.framedesign;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AdminOperations extends JFrame
{
	  private JLabel l1,l2;
	  private JTextField tname;
	  private JButton ano,vao,ar,dr,sar,dlo,bincroom ;
	  private final JMenuBar jmenubar;
      private final JMenu jmenu;
      private final JMenuItem jmenuano,jmenuvao,jmenuar,jmenudr;
	  public  AdminOperations(String title)
	  {
		  super(title);
	  
		 /* Container c=getContentPane();
		  c.setLayout(new GridLayout(8,1));
		 Color c1= new Color(250,224,153);
		      c.setBackground(Color.CYAN);*/
		  
		  JPanel c = new JPanel();
		  c.setLayout(null);
		  setContentPane(c);
		  c.setBackground(Color.CYAN);
		  
		 /* tname.addFocusListener( new FocusAdapter() 
		                          {
			                         public void focusGained(FocusEvent e)
			                         {
       	                                  tname.setBackground(Color.GRAY);
			                         }
		                          }
			                    );
		 
		 */
				
			ano =new JButton("Add New Operator");
			ano.setBounds(70,60,300,30);
			ano.addActionListener((e) ->
			                             {
			                            	new OperatorRegistration("Operator Registration...");
			                            	
			                              }
			                            );
				
			vao=new JButton("View All Operator");
			vao.setBounds(70,100,300,30);
			vao.addActionListener((e) ->
            							{
            							   new DisplayAllData();
            							}
									  );
				
			ar=new JButton("Add Room");
			ar.setBounds(70,140,300,30);
			ar.addActionListener((e) ->
			                           {
				                         new AddRoom("ADD ROOM..");
				                       }
					 				 );
				
			dr=new JButton("Delete Room");
			dr.setBounds(70,180,300,30);
			dr.addActionListener((e) ->
                                       {
                                    	  new DeleteRoom("Delete Room...");
                                       }
			                        );
			
			dlo=new JButton("Delete Operator");
			dlo.setBounds(70,220,300,30);
			dlo.addActionListener((e) ->
                                       {
                                    	  new DeleteOperator("Delete Operator...");
                                       }
			                        );
			bincroom = new JButton("Show Room Income");
			bincroom.setBounds(70,260,300,30);
			bincroom.addActionListener( (e) ->
			{
				new ShowRoomIncome("Income From Rooms..");
			}
					
					);
			JButton showall = new JButton("Show ROOMS");
			showall.setBounds(70,300,300,30);
			
			//showall.setBackground(b);
			showall.addActionListener((e) ->
			                             {
			                            	new DisplayAllRoom();
			                            	
			                              }
			                            );
			
			
			Font f=new Font("FORTE",Font.BOLD,27);
			l1=new JLabel("WELCOME ADMIN");
			l1.setFont(f);
			l1.setForeground(Color.blue);
			l1.setBounds(100,10,300,30);
				
			

			c.add(l1);
			c.add(ano);c.add(ar);
			c.add(vao);c.add(showall);
		    c.add(dlo);c.add(dr);c.add(bincroom);
		    
			jmenubar = new JMenuBar();
            
		    jmenu = new JMenu("OPTION");
		    jmenu.setMnemonic(KeyEvent.VK_O);
		                
		     jmenuano = new JMenuItem("Add New Operator");
		     jmenuano.setMnemonic(KeyEvent.VK_A);
		     jmenuano.addActionListener((e) ->
                                              {
                                            	  new OperatorRegistration("Operator Registration...");
                                              }
                                            );
		                
		     jmenuvao = new JMenuItem("View All Operator");
		     jmenuvao.setMnemonic(KeyEvent.VK_A);
		    
		     jmenuvao.addActionListener((e) ->
                                             {
                                            	 new DisplayAllData();
                                             }
                                           );
		                
		     jmenuar = new JMenuItem("Add Room");
		     jmenuar.setMnemonic(KeyEvent.VK_R);
		    
		     jmenuar.addActionListener((e) ->
                                           {
                                        	   new AddRoom("ADD ROOM..");
                                           }
		    		                      );
		                
		     
		     jmenudr = new JMenuItem("Delete Room");
		     jmenudr.setMnemonic(KeyEvent.VK_D);
		     
		     jmenudr.addActionListener((e) ->
                                            {
                                            	new DeleteRoom("Delete Room...");
                                            }
		    		 		    		 );
		             
		     jmenu.add(jmenuano);
		     jmenu.add(jmenuvao);
		     jmenu.add(jmenuar);
		     jmenu.add(jmenudr);
		                
		     jmenubar.add(jmenu);
		     setJMenuBar(jmenubar);
			 
			setSize(450, 400);
		    setLocation(200,200);
		    setResizable(false);
			
			setVisible(true);	
	   }
	     
	  
	  
	  public static void main(String[] args) 
	     {
		  new AdminOperations("Admin Operations");
	     }
}

