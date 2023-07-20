

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
class SumFrame extends JInternalFrame implements ActionListener,InternalFrameListener
{
   
   private JTextField txt_num1,txt_num2,txt_sum;

	public SumFrame()
	{
        super("SumFrame",true,true,true,true);
        this.addInternalFrameListener(this);

        this.setLayout(new GridLayout(3,2));
        this.add(new JLabel("Enter 1st Number"));
        txt_num1=new JTextField();
        this.add(txt_num1);

        this.add(new JLabel("Enter 2nd Number"));
        txt_num2=new JTextField();
        this.add(txt_num2);

        JButton b=new JButton("Sum");
        this.add(b);
        b.addActionListener(this);

        txt_sum=new JTextField();
        this.add(txt_sum);
        txt_sum.setEditable(false);

		    this.setVisible(true);
		    this.setSize(300,150);

	}
	@Override
	public void actionPerformed(ActionEvent e)
	{

		int x=Integer.parseInt(txt_num1.getText());
		int y=Integer.parseInt(txt_num2.getText());
		int z=x+y;
		txt_sum.setText(z+"");

	}
	@Override
	public void internalFrameActivated(InternalFrameEvent e){}
	@Override
	public void internalFrameClosed(InternalFrameEvent e){}
	@Override
	public void internalFrameDeactivated(InternalFrameEvent e){}
	@Override
	public void internalFrameDeiconified(InternalFrameEvent e){}
	@Override
	public void internalFrameIconified(InternalFrameEvent e){}
	@Override
	public void internalFrameOpened(InternalFrameEvent e){}
	@Override
	public void internalFrameClosing(InternalFrameEvent e)
	{
		MyFrame.sf=null;
		this.dispose();
	}
}



class FactFrame extends JInternalFrame implements ActionListener,InternalFrameListener
{
   private JTextField txt_num,txt_fact;
	 public FactFrame()
	{

	  super("FactFrame",true,true,true,true);
	  this.addInternalFrameListener(this);

	  this.setLayout(new GridLayout(2,2));

	  this.add(new JLabel("Enter a Number"));
	  txt_num=new JTextField();
	  this.add(txt_num);

	  JButton b=new JButton("Factorial");
	  this.add(b);
	  b.addActionListener(this);

	  txt_fact=new JTextField();
	  this.add(txt_fact);
	  txt_fact.setEditable(false);

    this.setVisible(true);
    this.setSize(300,100);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int n=Integer.parseInt(txt_num.getText());
		int f=1;
		for(int i=1;i<=n;i++)
			f=f*i;
		txt_fact.setText(f+"");

	}
	@Override
	public void internalFrameActivated(InternalFrameEvent e){}
	@Override
	public void internalFrameClosed(InternalFrameEvent e){}
	@Override
	public void internalFrameDeactivated(InternalFrameEvent e){}
	@Override
	public void internalFrameDeiconified(InternalFrameEvent e){}
	@Override
	public void internalFrameIconified(InternalFrameEvent e){}
	@Override
	public void internalFrameOpened(InternalFrameEvent e){}
	@Override
	public void internalFrameClosing(InternalFrameEvent e)
	{
		MyFrame.ff=null;
		this.dispose();
	}
}

class MyFrame extends JFrame implements ActionListener
{

    private JMenuBar mb;
    private JMenu m;
    private JMenuItem mi;
    private JDesktopPane jdp;

    public static SumFrame sf=null;
    public static FactFrame ff=null;

	public MyFrame()
	{
       mb=new JMenuBar();
       this.setJMenuBar(mb);

       m=new JMenu("Internal Frame");
       mb.add(m);

       String arr[]={"SumFrame","FactFrame"};
       for(int i=0;i<arr.length;i++)
       {
       mi=new JMenuItem(arr[i]);
       m.add(mi);
       mi.addActionListener(this);
       }

       jdp=new JDesktopPane();
       this.add(jdp,BorderLayout.CENTER);


		this.setVisible(true);
		this.setSize(500,500);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd=e.getActionCommand();
		switch(cmd)
		{
		case"SumFrame":
			if(sf==null)
			{
				sf=new SumFrame();
				jdp.add(sf);
			}
			break;
		case"FactFrame":
			if(ff==null)
			{
				ff=new FactFrame();
				jdp.add(ff);
			}
			break;
		}
	}

}



class Sample
{
	public static void main(String[] args) 
	{
		new MyFrame();
	}
}