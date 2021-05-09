import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Receipt extends Frame implements ActionListener
{
	
	Button btn,add1,exit;
	Label lbl_emp_code,lbl_name,lbl_dept,lbl_address,lbl_birth_date,lbl_doj,lbl_gender;
	TextField txt_emp_code,txt_name,txt_dept,txt_address,txt_birth_date,txt_doj;
	
	Label l1,l2,l3,l4,l5,l6,l7;
	TextField t1,t2,t3,t4,t5,t6,t7;
	Button b1,b2;
	
	public Receipt()
	{
		super("Receipt");
		
		
		
		setFont(new Font("Courier New",Font.BOLD,14));
		btn=new Button("MAIN MENU");
		add1=new Button("ADD");
		exit=new Button("EXIT");
		
		
		setBackground(Color.cyan);
		
		//b1=new Button("OK");
		//b1.setBounds(180,450,80,30);
	//	b1.SetLocation(180,350);
		//add(b1);
		
		//b2=new Button("CANCEL");
		//b2.setBounds(250,450,80,30);
		//add(b2);
		//b1.addActionListener(this);
		//b2.addActionListener(this);


		l1=new Label("Name:");
		l1.setBounds(10,50,100,30);
		add(l1);
		t1=new TextField();
		t1.setBounds(120,50,120,30);
		add(t1);

		l2=new Label("Year:");
		l2.setBounds(10,100,100,30);
		add(l2);
		t2=new TextField();
		t2.setBounds(120,100,100,30);
		add(t2);
		
		l3=new Label("semester:");
		l3.setBounds(10,150,100,30);
		add(l3);
		t3=new TextField();
		t3.setBounds(120,150,100,30);
		add(t3);
		
		l4=new Label("FeesPaid:");
		l4.setBounds(10,200,100,30);
		add(l4);
		t4=new TextField();
		t4.setBounds(120,200,100,30);
		add(t4);

		l5=new Label("Dues:");
		l5.setBounds(300,100,100,30);
		add(l5);
		t5=new TextField();
		t5.setBounds(420,100,100,30);
		add(t5);
		
		l6=new Label("RouteNo:");
		l6.setBounds(300,150,100,30);
		add(l6);
		t6=new TextField();
		t6.setBounds(420,150,100,30);
		add(t6);

		/*l7=new Label("Bus No:");
		l7.setBounds(300,200,100,30);
		add(l7);
		t7=new TextField();
		t7.setBounds(420,200,100,30);
		add(t7);*/
		add(add1);
		add(btn);
		add(exit);
		
		add1.addActionListener(this);
		btn.addActionListener(this);
		exit.addActionListener(this);
		//setLayout(new GridLayout(9,2,4,4));

           setLayout(null);
           setLayout(new GridLayout(7,2,6,6));
		
		     setBackground(Color.pink);
		   setLocation(50,50);
		    setSize(450,400);
		setVisible(true);
		
		/*add(btn);
		add(add1);
		add(exit);
		add1.addActionListener(this);
		btn.addActionListener(this);
		exit.addActionListener(this);
		setLayout(new FlowLayout());
		setLayout(new GridLayout(7,2,6,6));
		setBackground(Color.pink);
		setLocation(50,50);
		setSize(450,400);
		setVisible(true);*/

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
			
		
			
			//addinfo();	
			setVisible(true);	
			
		}
		if(e.getSource()==exit)
		{
			System.exit(0);
		}


	}
	
	public static void main(String args[])
	{
		//LoginScreen ls;
		Receipt r=new Receipt();
		r.addWindowListener(new winExit2());
	}

};
class winExit2 extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	};
