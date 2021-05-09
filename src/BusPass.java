import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class BusPass extends Frame implements ActionListener
{
	Button btn,add2,exit,print;;
	Label lbl_emp_code,lbl_dept,lbl_presentees,lbl_leaves,lbl_absentees,lbl_basic;
	TextField txt_emp_code,txt_presentees,txt_dept,txt_leaves,txt_absentees,txt_basic;
	Label l1,l2,l3,l4,l5,l6;
	TextField t1,t2,t3,t4,t5,t6;
	Button b1,b2;
	public BusPass()
	{
		super("BusPass");
		setFont(new Font("Courier New",Font.BOLD,14));
		btn=new Button("MAIN MENU");
		add2=new Button("ADD");
		exit=new Button("EXIT");
		print=new Button("PRINT PRESENTIES");
		/*txt_emp_code=new TextField(20);
		txt_presentees=new TextField(20);
		txt_dept=new TextField(20);
		txt_leaves=new TextField(20);
		txt_absentees=new TextField(20);*/
	
		l1=new Label("Name:");
		//l1.setBounds(10,50,100,30);
		add(l1);
		t1=new TextField();
		//t1.setBounds(120,50,150,30);
		add(t1);
			
		l2=new Label("Class:");
		//l2.setBounds(10,100,100,30);
		add(l2);
		t2=new TextField();
		//t2.setBounds(120,100,100,30);
		add(t2);
		
		l3=new Label("Bus Stop:");
		//l3.setBounds(10,150,100,30);
		add(l3);
		t3=new TextField("jay");
		//t3.setBounds(120,150,100,30);
		add(t3);
		
		l4=new Label("Semster:");
		//l4.setBounds(10,200,100,30);
		add(l4);
		t4=new TextField();
		//t4.setBounds(120,200,100,30);
		add(t4);

		l5=new Label("Route No:");
		//l5.setBounds(10,250,100,30);
		add(l5);
		t5=new TextField();
		//t5.setBounds(120,250,100,30);
		add(t5);
		
		l6=new Label("Receipt No:");
		//l6.setBounds(10,300,100,30);
		
		add(l6);
		t6=new TextField();
		//t6.setBounds(120,300,100,30);
		add(t6);

		
		/*lbl_emp_code=new Label("EMPLOYEE CODE");
		lbl_presentees=new Label("EMPLOYEE PRESETEES");
		lbl_dept=new Label("EMPLOYEE DEPARTMENT");
		lbl_leaves=new Label("LEAVES TAKEN");
		lbl_absentees=new Label("EMPLOYEE ABSENTES");
		
		
		add(lbl_emp_code);
		add(txt_emp_code);
		add(lbl_dept);
		add(txt_dept);
		add(lbl_leaves);
		add(txt_leaves);
		add(lbl_absentees);
		add(txt_absentees);
		add(lbl_presentees);
		add(txt_presentees);*/
		
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
			addinfo();
			setVisible(true);
		}
		if(e.getSource()==exit)
		{
			System.exit(0);
		}
		/*if(e.getSource()==print)
		{
			String s4=txt_leaves.getText();
		    String s5=txt_absentees.getText();
			int a,b;
			a=Integer.parseInt(s4);
			b=Integer.parseInt(s5);
			int total=0;
			total=30-(a+b);
			txt_presentees.setText(""+total);
		}*/
		
	}
	public void addinfo()
	{
		String s1=txt_emp_code.getText();
		String s2=txt_dept.getText();
		String s4=txt_leaves.getText();
		String s5=txt_absentees.getText();
              Label lab2;
	
	    String dbuser = "";
        String dbpasswd = "";
        String DriverPrefix = "jdbc:odbc:";
        String DataSource ="payrolldsn";
		
		 Statement stmt3 = null;
         Connection con3 = null;
		
		String SQLString = "INSERT INTO Monthlypay VALUES('" +s1+ "','"+s2+"','"+s4+"','"+s5+"')";
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
     
	}
	public static void main(String args[])
	{
		BusPass bp=new BusPass();
		bp.addWindowListener(new winExit3());
	}

};
class winExit3 extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	};
