import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Shedule extends Frame implements ActionListener
{
	
	Button btn,add1,exit;
	Label lbl_emp_code,lbl_name,lbl_dept,lbl_address,lbl_birth_date,lbl_doj,lbl_gender;
	TextField txt_emp_code,txt_name,txt_dept,txt_address,txt_birth_date,txt_doj;
	
	public Shedule()
	{
		super("Shedule");
		
		setFont(new Font("Courier New",Font.BOLD,14));
		btn=new Button("MAIN MENU");
		add1=new Button("ADD");
		exit=new Button("EXIT");
		txt_emp_code=new TextField(20);
		txt_name=new TextField(20);
		
		lbl_emp_code=new Label("Stop Name:");
		lbl_name=new Label("Time");
		
		
		add(lbl_emp_code);
		add(txt_emp_code);
		add(lbl_name);
		add(txt_name);
		add(add1);
		add(btn);
		add(exit);
		
		btn.addActionListener(this);
		exit.addActionListener(this);
		add1.addActionListener(this);
		setLayout(new FlowLayout());
		setLayout(new GridLayout(9,2,4,4));
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
		if(e.getSource()==add1)
		{
			
		
			
			addinfo();	
			setVisible(true);	
			
		}
		if(e.getSource()==exit)
		{
			System.exit(0);
		}


	}
	public void addinfo()
	{
	String s1=txt_emp_code.getText();
	//String s3=txt_dept.getText();
	String s2=txt_name.getText();
    /*String s4=txt_address.getText();
	String s5=txt_birth_date.getText();
	String s6=txt_doj.getText();*/
	
	Label lab1;
        int i=Integer.parseInt(BusSheduling.txt_t1.getText());
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
			
         catch(Exception e) 
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
          catch (Exception e) 
          	{
             //JOptionPane.showMessageDialog(null,"Check that all TextFields have been completed.\n"+e.getMessage(),"Communication Error",JOptionPane.WARNING_MESSAGE);
            } 
            	 lab1=new Label("Added Successfully");
            	add(lab1);
            	lab1.setLocation(50,490);     
     


	}
	public static void main(String args[])
	{
		//LoginScreen ls;
		Shedule s=new Shedule();
		s.addWindowListener(new winExit7());
	}

};
class winExit7 extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	};
