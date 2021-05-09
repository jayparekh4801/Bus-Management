import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.print.*;

class abc extends Frame implements ActionListener,ItemListener{	
int cnt=0;
	Button ad1,exit,btn,b1,b2,b3,b4,b5,b6;
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,lab,lb;
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	Choice ch;
List lt;
	int k=1;
	//PageFormat pgfrmt;
	//int pgindex;
	public abc()
	{

		super("DataEntry");
		setFont(new Font("Courier New",Font.BOLD,14));
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:DataEntry1");
		Statement st=con.createStatement();
		//boolean f=st.execute("insert into DataEntry1 values('"+s1+"',"+s2+",'"+s3+"',"+s4+",'"+s5+"',"+s6+","+s7+","+s8+","+s9+",'"+s10+"')");
		
		ResultSet rs=st.executeQuery("select * from DataEntry1");

		while(rs.next())
		{
			cnt++;
		}
		cnt=cnt+1000;
		//ResultSetMetaData rsmd=rs.getMetaData();
		}catch(Exception e5){
			e5.printStackTrace();
		}
		//setLayout(new GridLayout(7,2,10,10));
		setFont(new Font("Courier New",Font.BOLD, 14));
		btn=new Button("MAINMENU");
		ad1=new Button("ADD");
		exit=new Button("EXIT");
		
		l3=new Label("Name:");
		add(l3);
		t3=new TextField();
		add(t3);
		
		l4=new Label("Year:");
		add(l4);
		t4=new TextField();
		add(t4);
		
		l5=new Label("Department:");
		add(l5);
		t5=new TextField();
		//add(t5);
		ch=new Choice();
		ch.add("IT");
		ch.add("COMP");
		ch.add("ENTC");
		ch.add("MECH");
		add(ch);	
		
		l6=new Label("Semester:");
		add(l6);
		t6=new TextField();
		add(t6);

		
		l7=new Label("BusStop:");
		add(l7);
		t7=new TextField();
		add(t7);
		
		l8=new Label("ReceiptNo:");
		add(l8);
		t8=new TextField();
		t8.setText(""+cnt);
		add(t8);
        
	/*	lb=new Label(""+cnt);
		add(lb);
		t9=new TextField();
		add(t9);
      */  
		//t8.setText//("xbvdjfhg"); 
		l9=new Label("FeesPaid:");
		add(l9);
		t9=new TextField();
		add(t9);
		
		l10=new Label("Dues:");
		add(l10);
		t10=new TextField();
		add(t10);
		
		l11=new Label("RouteNo:");
		add(l11);
		t11=new TextField();
		add(t11);

		l12=new Label("BusTime:");
		add(l12);
		t12=new TextField();
		add(t12);
		
			
		
		add(btn);
		add(ad1);
		add(exit);
		ad1.addActionListener(this);
		btn.addActionListener(this);
		exit.addActionListener(this);
		setLayout(new FlowLayout());
		setLayout(new GridLayout(7,2,6,6));
		setBackground(Color.pink);
		setLocation(50,50);
		setSize(450,400);
		setVisible(true);
		
		
		ch.addItemListener(this);
	}
	
	
	
	public void itemStateChanged(ItemEvent it){
	if(it.getItemSelectable()==ch){
	t5.setText(""+((Choice)it.getItemSelectable()).getSelectedItem());
	}
	
	}
	
	
	
	//public int print(Graphics g,PageFormat pgfrmt,int pgindex)throws PrinterException{
			
	//}
	
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		String str=e.getActionCommand();
		lt=new List();
		add(lt);	
		try{

		if(str.equals("MAINMENU"))
		{
			setVisible(false);
			Options o=new Options();
		}
		if(str.equals("ADD"))
		{
			//String s0=ch.getSelectedItem();
			String s1=t3.getText();
			String s2=t4.getText();
			String s3=t5.getText();
			String s4=t6.getText();
			String s5=t7.getText();
			String s6=t8.getText();
			String s7=t9.getText();
			String s8=t10.getText();
			String s9=t11.getText();
			String s10=t12.getText();

	try{

		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:DataEntry1");
		Statement st=con.createStatement();
		
		boolean f=st.execute("insert into DataEntry1 values('"+s1+"',"+s2+",'"+s3+"',"+s4+",'"+s5+"',"+s6+","+s7+","+s8+","+s9+",'"+s10+"')");
		
		ResultSet rs=st.executeQuery("select * from DataEntry1");
		
		
		ResultSetMetaData rsmd=rs.getMetaData(); 
		
	/*	String p="select max(ReceiptNo)from DataEntry1";
		        t8.setText(""+p));
				 p=p+1;*/
				//t8.setText("+2+");	
		       /*while(rs.next())
		        {
			          //for(int i=1;i<=rsmd.getColumnCount();i++){
						int k=rs.getInt(3);
						//k++;
						t8.setText(""+k);
					//}	   
		        }
			  //t8.setText(""+(count+1));*/
			 
		
		
		
		
		
		while(rs.next())
		{
					
			System.out.print(rs.getString(1));
			System.out.print(rs.getInt(2));
			System.out.print(rs.getString(3));
			System.out.print(rs.getInt(4));
			System.out.print(rs.getString(5));
			System.out.print(rs.getInt(6));
			System.out.print(rs.getInt(7));
			System.out.print(rs.getInt(8));
			System.out.print(rs.getInt(9));
			System.out.print(rs.getString(10));
			lt.add(rs.getString(1));
		}
		con.close();
		
		}catch(Exception t)
		{
			t.printStackTrace();
		}

			lab=new Label("Added Successfully");
            	add(lab);
            	lab.setLocation(50,490);
			setVisible(true);
		
				
		
		
					
			try{
		//setVisible(false);
		
		setLayout(new FlowLayout());
		Frame f1=new Frame("Receipt");
		
		l7=new Label("ReceiptNo:");
		l7.setBounds(10,50,100,30);
		t7=new TextField();
		t7.setBounds(120,50,120,30);
		
		l1=new Label("Name:");
		l1.setBounds(10,100,100,30);
		t1=new TextField();
		t1.setBounds(120,100,100,30);

		l2=new Label("Year:");
		l2.setBounds(10,150,100,30);
		t2=new TextField();
		t2.setBounds(120,150,100,30);
		//add(t2);
		
		l3=new Label("semester:");
		l3.setBounds(10,200,100,30);
		//add(l3);
		t3=new TextField();
		t3.setBounds(120,200,100,30);
		//add(t3);
		
		l4=new Label("FeesPaid:");
		l4.setBounds(300,50,100,30);
		//add(l4);
		t4=new TextField();
		t4.setBounds(420,50,100,30);
		//add(t4);

		l5=new Label("Dues:");
		l5.setBounds(300,100,100,30);
		//add(l5);
		t5=new TextField();
		t5.setBounds(420,100,100,30);
		//add(t5);
		
		l6=new Label("Bus RouteNo:");
		l6.setBounds(300,150,100,30);
		//add(l6);
		t6=new TextField();
		t6.setBounds(420,150,100,30);
		//add(t6);
		f1.add(l7);
		f1.add(t7);
		f1.add(l1);
		f1.add(t1);
		f1.add(l2);
		f1.add(t2);
		f1.add(l3);
		f1.add(t3);
		f1.add(l4);
		f1.add(t4);
		f1.add(l5);
		f1.add(t5);
		f1.add(l6);
		f1.add(t6);

		b1=new Button("BUSPASS");
		b1.setBounds(420,200,100,30);
		f1.add(b1);
		
		b3=new Button("PRINT");
		b3.setBounds(460,200,100,30);
		f1.add(b3);
		
		b1.addActionListener(this);
		b3.addActionListener(this);
		
		
		

		f1.setLayout(new GridLayout(8,5,8,8));
		f1.setVisible(true);
		f1.pack();
		
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		      Connection con=DriverManager.getConnection("JDBC:ODBC:DataEntry1");
		      Statement st=con.createStatement();
			   String a="select * from DataEntry1 where (ReceiptNo="+t8.getText()+") ";
			  ResultSet rs=st.executeQuery(a);
			 ResultSetMetaData rsmd=rs.getMetaData(); 
              while(rs.next())
			   {
				 
				t7.setText(""+t8.getText());
		
				 String s16=rs.getString(1);
				 t1.setText(""+s16);
				  int s17=rs.getInt(2);
				 t2.setText(""+s17);
				  int s18=rs.getInt(4);
				 t3.setText(""+s18);
				 int s19=rs.getInt(7);
				 t4.setText(""+s19);
				int s20=rs.getInt(8);
				 t5.setText(""+s20);
				int s21=rs.getInt(9);
				t6.setText(""+s21);
				 

				/*tring s=rs.getString(2);
				 t3.setText(""+s);
				 t2.setText(""+i);
				  j=rs.getInt("RouteNo");
				  //k=rs.getInt("Time");
				  //t6.setText(""+k);
				  t2.setText(""+j);
				 for(i=1;i<=rsmd.getColumnCount();i++){
				 String k=rs.getString(3);
				  t6.setText(""+k);*/
				
		}
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		
		
		//addinfo();
		}

		
		
		if(str.equals("EXIT"))
		{
			
	   //	addinfo1();
		System.exit(0);
		}
	
	
		if(str.equals("BUSPASS")){
			
		try{
		setVisible(false);
		setLayout(new FlowLayout());
		Frame f2=new Frame("BussPass");
		l7=new Label("ReceiptNo:");
		l7.setBounds(10,50,100,30);
		t7=new TextField();
		t7.setBounds(120,50,120,30);
		
		l1=new Label("Name:");
		l1.setBounds(10,100,100,30);
		t1=new TextField();
		t1.setBounds(120,100,100,30);

		l2=new Label("Year:");
		l2.setBounds(10,150,100,30);
		t2=new TextField();
		t2.setBounds(120,150,100,30);
		//add(t2);
		
		l3=new Label("semester:");
		l3.setBounds(10,200,100,30);
		//add(l3);
		t3=new TextField();
		t3.setBounds(120,200,100,30);
		//add(t3);
		
		l4=new Label("Bus Stop:");
		l4.setBounds(300,50,100,30);
		//add(l4);
		t4=new TextField();
		t4.setBounds(420,50,100,30);
		//add(t4);

		l5=new Label("Bus RouteNo:");
		l5.setBounds(300,100,100,30);
		//add(l5);
		t5=new TextField();
		t5.setBounds(420,100,100,30);
		//add(t5);
		
		//l6=new Label("Bus RouteNo:");
		//l6.setBounds(300,150,100,30);
		//add(l6);
		//t6=new TextField();
		//t6.setBounds(420,150,100,30);
		//add(t6);
		f2.add(l7);
		f2.add(t7);
		f2.add(l1);
		f2.add(t1);
		f2.add(l2);
		f2.add(t2);
		f2.add(l3);
		f2.add(t3);
		f2.add(l4);
		f2.add(t4);
		f2.add(l5);
		f2.add(t5);
		//f2.add(l6);
		//f2.add(t6);

		b6=new Button("MAINMENU");
		b6.setBounds(420,200,100,30);
		f2.add(b6);

		b4=new Button("PRINT");
		b4.setBounds(460,200,100,30);
		f2.add(b4);
		
		b5=new Button("EXIT");
		b5.setBounds(420,250,100,30);
		f2.add(b5);
		
		b6.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		
		

		f2.setLayout(new GridLayout(8,5,6,6));
		f2.setVisible(true);
		f2.pack();
		
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		      Connection con=DriverManager.getConnection("JDBC:ODBC:DataEntry1");
		      Statement st=con.createStatement();
			   String a="select * from DataEntry1 where (ReceiptNo="+t8.getText()+") ";
			  ResultSet rs=st.executeQuery(a);
			 ResultSetMetaData rsmd=rs.getMetaData(); 
              while(rs.next())
			   {
				 
				t7.setText(""+t8.getText());
		
				 String s11=rs.getString(1);
				 t1.setText(""+s11);
				  int s12=rs.getInt(2);
				 t2.setText(""+s12);
				  int s13=rs.getInt(4);
				 t3.setText(""+s13);
				 String s14=rs.getString(5);
				 t4.setText(""+s14);
				int s15=rs.getInt(9);
				 t5.setText(""+s15);
				//int s6=rs.getInt(9);
				//t6.setText(""+s6);
				 

				/*tring s=rs.getString(2);
				 t3.setText(""+s);
				 t2.setText(""+i);
				  j=rs.getInt("RouteNo");
				  //k=rs.getInt("Time");
				  //t6.setText(""+k);
				  t2.setText(""+j);
				 for(i=1;i<=rsmd.getColumnCount();i++){
				 String k=rs.getString(3);
				  t6.setText(""+k);*/
				
		}
			
		}catch(Exception e2){
			e2.printStackTrace();
		}
		
	/*Public void actionPerformed(ActionEvent e)
	{
	
		if(e.getSource()==b1)
		{
			setVisible(false);
			Options o=new Options();
		}
		if(e.getSource()==b4)
		{
			setVisible(true);
		}

		if(e.getSource()==b5)
		{
			//setVisible(true);
			System.exit();
		}
	 }*/

			
			
			
		//	addinfo1();
		}
		if(str.equals("MAINMENU"))
		{
			setVisible(false);
			Options o=new Options();
		}

		if(str.equals("PRINT")){
		//	print();
		}


	}catch(Exception e3){
		e3.printStackTrace();
	}

	
	}




	public static void main(String args[])
	{
		abc d=new abc();
		d.addWindowListener(new winExit5d());
	}
};
class winExit5d extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	};
