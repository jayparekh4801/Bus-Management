import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Shedule1 extends Frame implements ActionListener {
	Button b1, b2, b3, b4, b5, b6, b7, b8;
	TextField t1, t2, t3, t4, t5, t6;
	Label l1, l2, l3, l4, l5, l6, l7, l8, l9;
	Frame f1, f2, f3;
	Scrollbar c6;
	List lt, lt1, ltt;
	// Toolkit tk = Toolkit.getDefaultToolkit();
	// Dimension d = tk.getScreenSize();
	// int height = d.height;
	// int width = d.width;

	Shedule1() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		// setLocation(300,300);
		// setLocation(width/3,height/3);
		l1 = new Label("Enter the bus route number: ");
		t1 = new TextField(5);
		b1 = new Button("CLICK");

		f1 = new Frame();
		f1.add(l1);
		f1.add(t1);
		f1.add(b1);
		t1.setText("");

		f1.setLayout(new FlowLayout());
		f1.setVisible(true);
		f1.pack();
		b1.addActionListener(this);

	}

	/*
	 * public void itemStateChanged(ItemEvent it){ if(e.getItemSelectable()==ch){
	 * t5.setText(""+((Choice)it.getItemSelectable()).getSelectedItem()); }
	 * 
	 * }
	 */

	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		// int k=0;
		try {

			if (str.equals("CLICK")) {
				try {

					int i = Integer.parseInt(t1.getText());
					l2 = new Label("RouteNo");
					ltt = new List();
//					t2 = new TextField("jay");
					l3 = new Label("StopName");
//			t3=new TextField();
					lt = new List();
					l6 = new Label("Time");
					lt1 = new List();
//			t6=new TextField();

					f2 = new Frame();

					// lt.add(str1);

					b2 = new Button("OK");
					b2.addActionListener(this);

					f2.add(l2);
					f2.add(ltt);

					f2.add(l3);
					f2.add(lt);
					f2.add(l6);
					f2.add(lt1);
					// f2.add(t6);
					// f2.add(t3);
					// f2.add(l4);
					// f2.add(c4);
					f2.add(b2);
					// f2.add(c6);

					f2.setLayout(new GridLayout(4, 2));
					f2.setVisible(true);
					f2.pack();
					int j = 0, amt = 0;
//			Class.forName("com.mysql.jdbc.Driver");
//		      Connection con=DriverManager.getConnection("");
//		      Statement st=con.createStatement();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINS", "root",
							"vnhmhJi#7ms");
					PreparedStatement stm = con.prepareStatement("select stopName, time from shedule where routeNo = ?;");
//					String a = "select * from shedule where (RouteNo=" + i + ") ";
					stm.setInt(1, i);
					ResultSet rs = stm.executeQuery();
//					ResultSetMetaData rsmd = rs.getMetaData();

					while (rs.next()) {

						String str1 = rs.getString(1);
						lt.add(str1);

						// t2.setText(""+i);
						String str11 = rs.getString(2);
						lt1.add(str11);
//						j = rs.getInt("RouteNo");
						// k=rs.getInt("Time");
						// t6.setText(""+k);
						

						// String k=rs.getString(3);
						// t6.setText(""+k);
					}
					ltt.add("" + i);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

			if (str.equals("OK")) {
				b6 = new Button("YES");
				b7 = new Button("MAIN");
				b8 = new Button("EXIT");
				l7 = new Label("CONTINUE WITH SCHEDULE");
				l8 = new Label("RETURN TO MAIN");
				l9 = new Label("EXIT FROM SYSTEM");
				f3 = new Frame();
				f3.add(l7);
				f3.add(b6);
				f3.add(l8);
				f3.add(b7);
				f3.add(l9);
				f3.add(b8);
				f3.setLayout(new GridLayout(3, 2));
				f3.setVisible(true);
				f3.pack();
				b6.addActionListener(this);
				b7.addActionListener(this);
				b8.addActionListener(this);
			}
			if (str.equals("YES")) {
				f2.setVisible(false);
				f3.setVisible(false);

				Shedule1 b = new Shedule1();
			}
			if (str.equals("MAIN")) {
				f3.setVisible(false);
				f2.setVisible(false);
				f1.setVisible(false);
				Options o = new Options();
			}
			if (str.equals("EXIT")) {
				System.exit(0);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String args[]) {
		Shedule1 b = new Shedule1();
	}

}
