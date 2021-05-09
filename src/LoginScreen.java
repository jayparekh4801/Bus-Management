import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LoginScreen extends Frame implements ActionListener
{
	Button ok,can, signUp, forgot;
	TextField txt_user,txt_pwd;
	Label lbl_user,lbl_pwd,l2;
	
	public LoginScreen()
	{
		super("Login Screen");
		setFont(new Font("Courier New",Font.BOLD,14));
 	
		Label l1; 
 	
 		l1=new Label("   LOGIN FORM     ");
 		l1.setFont(new Font("Courier New",Font.BOLD,30));
 	    
		setLayout(new FlowLayout());
		lbl_user=new Label("USER NAME");
		
		lbl_pwd=new Label("PASSWORD");
		txt_user=new TextField(20);
		txt_pwd=new TextField(20);
		txt_pwd.setEchoChar('*');
		ok=new Button("OK");
		can=new Button("CANCEL");
		signUp = new Button("Sign Up");
		forgot = new Button("Forgot Password");
		
		add(l1);
		add(lbl_user);
		add(txt_user);
		add(lbl_pwd);
		add(txt_pwd);
		add(ok);
		add(can);
		add(signUp);
		add(forgot);

		ok.addActionListener(this);
		can.addActionListener(this);
		signUp.addActionListener(this);
		forgot.addActionListener(this);
		setBackground(Color.orange);
		//setLayout(new GridLayout(4,2,5,5));
		setLocation(50,50);
		//ok.setLocation(300,350);
		setSize(300,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		{
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINS", "root", "vnhmhJi#7ms");
	            PreparedStatement stm = con.prepareStatement("select * from userd where userName = ? and password = ?;");
	             stm.setString(1, txt_user.getText());
	             stm.setString(2, txt_pwd.getText());
	             ResultSet rs = stm.executeQuery();
	             if(rs.next()) {
						setVisible(false);
						Options o=new Options();
					}
	             else {
						if(l2 != null) {
							remove(l2);
						}
						l2=new Label("Username Or Password Is Wrong");
						setLocation(100,100);
						add(l2);
						setVisible(true);
					}
			}
			catch(Exception e) {
				System.out.print("problem in JDBC segment");
			}
			
		}
		if(ae.getSource()==can)
		{
			System.exit(0);
		}
		if(ae.getSource() == signUp) {
			System.out.println("clicked");
			setVisible(false);
			SignUpScreen s = new SignUpScreen();
		}
		
		if(ae.getSource() == forgot) {
			ForgotPassword fp = new ForgotPassword();
		}
	}

	public static void main(String args[])
	{
		
		LoginScreen ls=new LoginScreen();
		ls.addWindowListener(new winExit());
	}
};
	class winExit extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	};
