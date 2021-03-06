import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class DataRetrival extends Frame implements ActionListener {
	Button b1, b2, b3, b4, b5, b6, b7, b8;
	TextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
	Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	Frame f1, f2, f3;

	/*
	 * Toolkit tk = Toolkit.getDefaultToolkit(); Dimension d = tk.getScreenSize();
	 * int height = d.height; int width = d.width;
	 */
	DataRetrival() {
		// setLocation(width/3,height/3);
		l1 = new Label("Enter the Receipt number: ");
		t1 = new TextField(5);
		b1 = new Button("SEARCH");
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

	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		// int k=0;
		try {

			if (str.equals("SEARCH")) {
				setVisible(false);
				setVisible(false);
				setVisible(false);

				int i = Integer.parseInt(t1.getText());
				l2 = new Label("ReceiptNo");
				t2 = new TextField();
				l6 = new Label("Time");
				t6 = new TextField();
				l3 = new Label("StopName");
				t3 = new TextField();

				l4 = new Label("Name");
				t4 = new TextField();

				l7 = new Label("Year");
				t7 = new TextField();

				l8 = new Label("Department");
				t8 = new TextField();

				l9 = new Label("Semester");
				t9 = new TextField();

				l10 = new Label("FeesPaid");
				t10 = new TextField();

				l11 = new Label("Dues");
				t11 = new TextField();

				l12 = new Label("RouteNo");
				t12 = new TextField();

				b2 = new Button("OK");

				f2 = new Frame();
				f2.add(l2);
				f2.add(t2);
				f2.add(l4);
				f2.add(t4);

				f2.add(l7);
				f2.add(t7);
				f2.add(l8);
				f2.add(t8);
				f2.add(l9);
				f2.add(t9);
				f2.add(l10);
				f2.add(t10);
				f2.add(l11);
				f2.add(t11);
				f2.add(l12);
				f2.add(t12);

				f2.add(l3);
				f2.add(t3);
				f2.add(l6);
				f2.add(t6);
				f2.add(b2);
				// f2.add(c6);
				b2.addActionListener(this);
				f2.setLayout(new GridLayout(6, 2));
				f2.setVisible(true);
				f2.pack();
				int j = 0, amt = 0;
//			Class.forName("com.mysql.jdbc.Driver");
//		      Connection con=DriverManager.getConnection("");
//		      Statement st=con.createStatement();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINS", "root",
						"vnhmhJi#7ms");
				PreparedStatement stm = con.prepareStatement("select * from bussystem where rno = ?;");
//				String a = "select * from DataEntry1 where (ReceiptNo=" + i + ") ";
				stm.setInt(1, i);
				ResultSet rs = stm.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				while (rs.next()) {

					String s1 = rs.getString(1);
					t4.setText("" + s1);
					int s2 = rs.getInt(6);
					t7.setText("" + s2);
					String s3 = rs.getString(2);
					t8.setText("" + s3);
					int s4 = rs.getInt(7);
					t9.setText("" + s4);
					// String s=rs.getString(6);
					// t3.setText(""+s);
					int s5 = rs.getInt(4);
					t10.setText("" + s5);
					int s6 = rs.getInt(9);
					t11.setText("" + s6);
					int s7 = rs.getInt(5);
					t12.setText("" + s7);

					String s = rs.getString(3);
					t3.setText("" + s);
					t2.setText("" + i);
					j = rs.getInt(8);
					// k=rs.getInt("Time");
					// t6.setText(""+k);
					t2.setText("" + j);
					for (i = 1; i <= rsmd.getColumnCount(); i++) {
						String k = rs.getString(10);
						t6.setText("" + k);
					}
				}

			}

			if (str.equals("OK")) {
				b6 = new Button("YES");
				b7 = new Button("MAIN");
				b8 = new Button("EXIT");
				l7 = new Label("CONTINUE WITH DATARETRIVAL");
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

				DataRetrival dr = new DataRetrival();
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
		DataRetrival dr = new DataRetrival();
	}

}
