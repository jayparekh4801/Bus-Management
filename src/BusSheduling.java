import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class BusSheduling extends Frame implements ActionListener
{
	Button btn,add2,exit,print;;
	Label lbl_emp_code,lbl_dept,lbl_presentees,lbl_leaves,lbl_absentees,lbl_basic;
	TextField txt_emp_code;
	static TextField txt_t1;
	TextField txt_dept;
	TextField txt_leaves;
	TextField txt_absentees;
	TextField txt_basic;
	TextField txt_name;
	
	public BusSheduling()
	{
		super("Monthly Paymaster");
		setFont(new Font("Courier New",Font.BOLD,14));
		btn=new Button("MAIN MENU");
		add2=new Button("OK");
		exit=new Button("EXIT");
		print=new Button("PRINT PRESENTIES");
		txt_emp_code=new TextField(20);
		txt_t1=new TextField(20);
		
		


		TextField txt_emp_code1=new TextField(20);
		TextField txt_name=new TextField(20);
		
		Label lbl_emp_code1=new Label("Stop Name:");
		Label lbl_name=new Label("Time");
		
		
		add(lbl_emp_code1);
		add(txt_emp_code1);
		add(lbl_name);
		add(txt_name);



		lbl_emp_code=new Label("Enter rout number from 1,2,3,4:");
		lbl_absentees=new Label("Route No:");
		
		
		add(lbl_emp_code);
		add(lbl_absentees);
		add(txt_t1);
		
		add(btn);
		add(add2);
		add(exit);
		add(print);
		exit.addActionListener(this);
		add2.addActionListener(this);
		btn.addActionListener(this);
		print.addActionListener(this);
		setLayout(new FlowLayout());
		setLayout(new GridLayout(10,2));
		setBackground(Color.pink);
		setLocation(50,50);
		setSize(500,500);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn)
		{
			setVisible(false);
			Options o=new Options();
		}
		if(e.getSource()==add2)
		{
			//addinfo();
			setVisible(false);
			//public void addinfo()
		//{
		
		
		String s1=txt_emp_code.getText();
	//String s3=txt_dept.getText();
	String s2=txt_name.getText();
    /*String s4=txt_address.getText();
	String s5=txt_birth_date.getText();
	String s6=txt_doj.getText();*/
	
	Label lab1;
        int i=Integer.parseInt(txt_t1.getText());
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:shedule");
		Statement st=con.createStatement();
		String a="select * from Shedule where (Route No="+i+") ";
			  ResultSet rs=st.executeQuery(a);	
		  
        //try {
          //  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           
		   //ResultSet rs=st.executeQuery("Select Stop Name,Time from schedule where Route Number=BusSheduling.txt_t1.getText()");
			} 
			
         catch(Exception e2) 
            {
            
            System.out.println("JDBC DRIVER ERROR");
           return;
            }
        
        
       
        //Creates connection to database
       /* try {
              Connection con1 = DriverManager.getConnection(DriverPrefix+DataSource,dbuser, dbpasswd);
              Statement stmt1 = con1.createStatement();
            } 
        catch (Exception e) 
         {
             System.out.println("CONNECTION ERROR");
         }*/
        
        //Updates the database with data
        try {
             
            // stmt1.executeUpdate(SQLString);          
             //con1.close();
             this.dispose();
             }
          catch (Exception e1) 
          	{
             //JOptionPane.showMessageDialog(null,"Check that all TextFields have been completed.\n"+e.getMessage(),"Communication Error",JOptionPane.WARNING_MESSAGE);
            } 
            	 lab1=new Label("Added Successfully");
            	add(lab1);
            	lab1.setLocation(50,490);     
     


	}
			//Shedule s=new Shedule();

		//}







		if(e.getSource()==exit)
		{
			System.exit(0);
		}
		/*if(e.getSource()==print)
		{
			String s1=txt_absentees.getText();
			int a,b;
			a=Integer.parseInt(s1);
			//b=Integer.parseInt(s5);
			int total=0;
			total=30-(a+b);
			txt_presentees.setText(""+total);
		}*/
		
	}
	/*public void addinfo()
	{
		//String s1=txt_emp_code.getText();
		//String s2=txt_dept.getText();
		//String s4=txt_leaves.getText();
		String s5=txt_presentees.getText();
          Label lab2;
	
	    String dbuser = "";
        String dbpasswd = "";
        String DriverPrefix = "jdbc:odbc:";
        String DataSource ="payrolldsn";
		
		 Statement stmt3 = null;
         Connection con3 = null;
		
		//String SQLString = "INSERT INTO Monthlypay VALUES('" +s1+ "','"+s2+"','"+s4+"','"+s5+"')";
		  //Loads JDBC/ODBC driver
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           	} 
			
         catch(Exception e) 
            {
            //Uses the JFC Swing to display warning message in Option Pane with
            //relevant information about the error.
             System.out.println("JDBC DRIVER ERROR");
		     return;
            }
        
        
       
        //Creates connection to database
        try {
              con3 = DriverManager.getConnection(DriverPrefix+DataSource,dbuser, dbpasswd);
              stmt3 = con3.createStatement();
            } 
        catch (Exception e) 
         {
            System.out.println("CONNECTION ERROR");
			
         }
        
        //Updates the database with data
        try {
             
             stmt3.executeUpdate(SQLString);          
             con3.close();
             this.dispose();
             }
          catch (Exception e) 
          	{
             System.out.println("CHECK ALL FIELDS");
			
            }    
            	lab2=new Label("Added Successfully");
            	add(lab2);
            	lab2.setLocation(50,490);   
     
	}*/
	public static void main(String args[])
	{
		BusSheduling bs=new BusSheduling();
		bs.addWindowListener(new winExit6());
	}

};
class winExit6 extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	};
