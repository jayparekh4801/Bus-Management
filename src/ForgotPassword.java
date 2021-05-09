

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgotPassword extends Frame implements ActionListener {
    Button ok, can, signIn;
    TextField txt_user, txt_pwd, cnf_pwd;
    Label lbl_user, lbl_pwd, lbl_cpwd, l2;

    public ForgotPassword() {
        super("Login Screen");
        setFont(new Font("Courier New", Font.BOLD, 14));

        Label l1;

        l1 = new Label("   Forgot Password    ");
        l1.setFont(new Font("Courier New", Font.BOLD, 30));

        setLayout(new FlowLayout());
        
        lbl_user = new Label("USER NAME");
        lbl_pwd = new Label("PASSWORD");
        lbl_cpwd = new Label("CONFIRM PASSWORD");
        txt_user = new TextField(20);
        txt_pwd = new TextField(20);
        cnf_pwd = new TextField(20);
        txt_pwd.setEchoChar('*');
        cnf_pwd.setEchoChar('*');
        ok = new Button("OK");
        can = new Button("CANCEL");
        signIn = new Button("Sign In");

        add(l1);
        

        // add(lbl_role);
        // add(role);
        add(lbl_user);
        add(txt_user);
        add(lbl_pwd);
        add(txt_pwd);
        add(lbl_cpwd);
        add(cnf_pwd);
        add(ok);
        add(can);
        add(signIn);

        ok.addActionListener(this);
        can.addActionListener(this);
        signIn.addActionListener(this);
        setBackground(Color.orange);
        // setLayout(new GridLayout(4,2,5,5));
        setLocation(50, 50);
        // ok.setLocation(300,350);
        setSize(300, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    	int i = 0;
        if (ae.getSource() == ok) {
            
            if(txt_pwd.getText().equals(cnf_pwd.getText())) {
                
                setVisible(false);
                 try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINS", "root", "vnhmhJi#7ms");
	                 PreparedStatement stm = con.prepareStatement("update userd set password = ? where userName = ?;");
	                 stm.setString(1, txt_pwd.getText());
	                 stm.setString(2, txt_user.getText());
	                 i=stm.executeUpdate();  
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 
                if(i != 0) {
                    LoginScreen l = new LoginScreen();
                }
                else {
                	if(l2 != null) {
                        remove(l2);
                    }
                    l2 = new Label("username is not matched");
                    setLocation(100, 100);
                    add(l2);
                    setVisible(true);
                    System.out.println("ok clicked");
                }
                System.out.println("ok from nice clicked");
            }
            else {
                // l2.hide();
                if(l2 != null) {
                    remove(l2);
                }
                l2 = new Label("password is not matched");
                setLocation(100, 100);
                add(l2);
                setVisible(true);
                System.out.println("ok clicked");
            }
            // SignUpScreen.userName = txt_user.getText();
            // SignUpScreen.password = txt_pwd.getText();
            // setVisible(false);
            // LoginScreen l = new LoginScreen();
        }
        if (ae.getSource() == can) {
            System.exit(0);
        }

        if(ae.getSource() == signIn) {
            setVisible(false);
            LoginScreen l = new LoginScreen();
        }
    }

    public static void main(String args[]) {

        LoginScreen ls = new LoginScreen();
        ls.addWindowListener(new winExitd());
    }
};

class winExitd extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
};
