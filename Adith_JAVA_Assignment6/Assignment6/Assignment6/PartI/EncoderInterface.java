import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.*;

public class EncoderInterface extends JFrame {

	private JFileChooser jc;
	private JMenuBar m;
	private JTextArea iff;
	private JTextArea off;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JScrollPane pp;
	private JScrollPane pp1;
	private JMenu fm;
	private JButton clr;
	private JMenuItem open;
	private JMenuItem exitt;
	private JComboBox<String> cc;
	private ActionListener exittt;
	private ActionListener opennn;
	private ActionListener comboone;
	private CaretListener crt;
	
	
	
	public EncoderInterface() {
		super("Encoder");
		setLayout(new GridLayout());
		m=new JMenuBar();
		fm=new JMenu("File");
		open=new JMenuItem("Open");
	    exitt=new JMenuItem("Exit") ;
	    
	    exittt=new exitk();
	    opennn=new openk();
	    fm.add(open);
	    fm.add(exitt);
	    m.add(fm);
	    setJMenuBar(m);
	    exitt.addActionListener(exittt);
	    open.addActionListener(opennn);
		cc=new JComboBox<String>();
		cc.addItem("Numeric");
		cc.addItem("ROT13");
		comboone=new comboc();
		cc.addActionListener(comboone);
		
	    
		iff=new JTextArea(10,45);
		off=new JTextArea(10,51);
		off.setEditable(false);
		pp=new JScrollPane(iff,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pp1=new JScrollPane(off,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		
		
	
		
	    clr=new JButton("Clear");
	    crt=new crtcls();
	    iff.addCaretListener(crt);
	    clr.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		iff.setText("");
	    		off.setText("");
	    	}
	    	          
	    	
	    });
		p1.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		
		p3.setLayout(new GridLayout(2,1));
		
	    
		p1.add(pp);
		
		p1.add(cc);
		p1.add(clr);
		p2.add(pp1);
		
		p3.add(p1);
		p3.add(p2);
		
		add(p3);
		
		
		
		
		
		
		
		
		setSize(500,500);
	}
	class exitk implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
    	{
    		System.exit(0);
    	}
		
	};
class crtcls implements CaretListener{
	
	
	@Override
	public void caretUpdate(CaretEvent e)
	{
String hg="";
		
		String h=(String)cc.getSelectedItem();
		if(h.equals("ROT13"))
		{String a=iff.getText();
			hg=Encoder.encodeROT13(a);
			off.setText(hg);
		}
		else
		if(h.equals("Numeric"))
		{String a=iff.getText();
			hg=Encoder.encodeNumeric(a);
			off.setText(hg);
		}
	}
	
}
	
class openk implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
    	{
    		String b=loadFile();
    		
    		FileReader ff=null;
    		
    		try
        	{
        			ff=new FileReader(b);
        			BufferedReader i= new BufferedReader(ff);
        			
        			String inString = i.readLine();
        			
        			while(inString!=null)
        			{
        				
        				iff.append(inString+"\n");
        				

        				inString=i.readLine();
        				
        			}
        			i.close();
        			ff.close();
        	}
    		 catch(FileNotFoundException f)
            {
            	
            	System.out.println("File not found");
            	System.out.println(f);
            	
            }
    		 catch(IOException r)
            {
            	System.out.println("IO Exception");
            	System.out.println(r);
            	
            }
    		
    	}
		
	};
	
	
class comboc implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
    	{
			String hg="";
			
			String h=(String)cc.getSelectedItem();
			if(h.equals("ROT13"))
			{String a=iff.getText();
				hg=Encoder.encodeROT13(a);
				off.setText(hg);
			}
			else
			if(h.equals("Numeric"))
			{String a=iff.getText();
				hg=Encoder.encodeNumeric(a);
				off.setText(hg);
			}
    	}
		
	}

	
	
	private String loadFile() {
		// alternately, you can have it return
		// a File object or file path String or whatever you
		// like.
		String g="";
		if (jc == null) jc = new JFileChooser("."); 
		
		int returnValue = jc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jc.getSelectedFile();
			g=selectedFile.getAbsolutePath();			
		}
		return g;
	}
	

	
	public static void main(String[] args) {
	      JFrame frame = new EncoderInterface();
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setVisible(true);    
	}

}
