import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUpScreen extends Frame implements ActionListener {
    Button ok, can, signIn;
    TextField name, role, txt_user, txt_pwd;
    Label lbl_name, lbl_role, lbl_user, lbl_pwd, l2;

    public SignUpScreen() {
        super("Login Screen");
        setFont(new Font("Courier New", Font.BOLD, 14));

        Label l1;

        l1 = new Label("   SignUp Form    ");
        l1.setFont(new Font("Courier New", Font.BOLD, 30));

        setLayout(new FlowLayout());
        lbl_name = new Label("Name ");
        lbl_role = new Label("Role");
        lbl_user = new Label("USER NAME");
        lbl_pwd = new Label("PASSWORD");
        name = new TextField(20);
        role = new TextField(20);
        txt_user = new TextField(20);
        txt_pwd = new TextField(20);
        txt_pwd.setEchoChar('*');
        ok = new Button("OK");
        can = new Button("CANCEL");
        signIn = new Button("Sign In");

        add(l1);
        add(lbl_name);
        add(name);

        // add(lbl_role);
        // add(role);
        add(lbl_user);
        add(txt_user);
        add(lbl_pwd);
        add(txt_pwd);
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
            
            if(name.getText().matches("[a-zA-Z]+")) {
            	if((!txt_user.getText().equalsIgnoreCase(""))) {
            		if((!txt_pwd.getText().equalsIgnoreCase(""))) {
            			setVisible(false);
            			try {
            				Class.forName("com.mysql.jdbc.Driver");
            				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINS", "root", "vnhmhJi#7ms");
            				PreparedStatement stm = con.prepareStatement("insert into userd values(?, ?, ?)");
            				stm.setString(1, name.getText());
            				stm.setString(2, txt_user.getText());
            				stm.setString(3, txt_pwd.getText());
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
            			System.out.println("ok from nice clicked");
            		}
            		else {
            			if(l2 != null) {
                            remove(l2);
                        }
                        l2 = new Label("Password Should Not Be Empty");
                        setLocation(100, 100);
                        add(l2);
                        setVisible(true);
                        System.out.println("ok clicked");
            		}
            	}else {
            		if(l2 != null) {
                        remove(l2);
                    }
                    l2 = new Label("Username Should Not Be Empty");
                    setLocation(100, 100);
                    add(l2);
                    setVisible(true);
                    System.out.println("ok clicked");
            	}
            
            }
            else {
                // l2.hide();
                if(l2 != null) {
                    remove(l2);
                }
                l2 = new Label("Name Can Contain Only Letters.");
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
        ls.addWindowListener(new winExits());
    }
};

class winExits extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
};
