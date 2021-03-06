import java.awt.*;
import java.awt.event.*;

class Options extends Frame implements ItemListener
{
	CheckboxGroup group;
	Checkbox cb,cb1,dataretrival;

	public Options()
	{
		super("Option Form");
		setFont(new Font("Courier New",Font.BOLD,14));
		group=new CheckboxGroup();
		cb=new Checkbox("Data Entry",group,false);
		cb1=new Checkbox("Bus Sheduling",group,false);
		dataretrival=new Checkbox("Data Retrival",group,false);

		add(cb);
		add(cb1);
		add(dataretrival);
		
		cb.addItemListener(this);
		cb1.addItemListener(this);
		dataretrival.addItemListener(this);
		
		setLayout(new FlowLayout());
		setLayout(new GridLayout(4,1,2,2));
		setBackground(Color.pink);
		setLocation(200,200);
		setSize(300,300);
		setVisible(true);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==cb)
		{
			setVisible(false);
			System.out.print("clicked");
			DataEntry d=new DataEntry();
		}
		
		if(ie.getSource()==cb1)
		{
			setVisible(false);
			System.out.print("clicked in cb1");
			Shedule1 b=new Shedule1();
		}
		
		if(ie.getSource()==dataretrival)
		{
			setVisible(false);
			DataRetrival dr=new DataRetrival();
		}
		
	}	
	
	public static void main(String args[])
	{
		Options o=new Options();
		o.addWindowListener(new winExit1());
	}

};
class winExit1 extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	};
