package PartIV;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RollDice extends JFrame {

	private JPanel p;
	private JButton b;
	private JPanel d;
	private JLabel l;
	private int v1;
	private int v2;
	private ImagePanel i1;
	private ImagePanel i2;
	private JPanel p2;
	private JPanel p3;
	
	
	
	
	public RollDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p=new JPanel(new BorderLayout());
		l=new JLabel("Result: 2");
		b=new JButton("Roll Dice");
		d=new JPanel(new GridLayout(1,2));
		
		b.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{int i;
			int m=(int)(Math.random()*20)+1;
	
			
			for(i=0;i<m;i++)
				{
				
				
				roll();
				
				
				}
			}
			
				
		
		}
				
				
				);
		
		p2=new JPanel();
	    p3=new JPanel();
	    p2.add(l);
	    p3.add(b);
		
		p.add(p2,BorderLayout.CENTER);
		p.add(p3,BorderLayout.SOUTH);
		p.add(d,BorderLayout.NORTH);
		i2=new ImagePanel("die"+v2+".png");	
		
		
		roll();
		
		

	
	
		
		
		
		this.add(p);
		this.setSize(780,290);
		
		this.setVisible(true);
		
		
	}
	
	public void roll()
	{
		
		
		
		
		v1=(int)(Math.random()*6)+1;
		v2=(int)(Math.random()*6)+1;
		
		i1=new ImagePanel("die"+v1+".png");
		i2=new ImagePanel("die"+v2+".png");	

		i1.addMouseListener(new MouseAdapter()
		{
	@Override
	public void mouseClicked(MouseEvent e)
	{
		
		v1=(int)(Math.random()*6)+1;
		i1.setIm("die"+v1+".png");
		l.setText("Result: "+(v1+v2));
		d.removeAll();
		d.add(i1);
		d.add(i2);
		revalidate();
		repaint();
		
		
	}

	
	
		}
);
		
		
	i2.addMouseListener(new MouseAdapter()
		{
	@Override
	public void mouseClicked(MouseEvent e)
	{
		
		v2=(int)(Math.random()*6)+1;
		i2.setIm("die"+v2+".png");
		l.setText("Result: "+(v1+v2));
		d.removeAll();
		d.add(i1);
		d.add(i2);
		revalidate();
		repaint();
	}
		
	});

		
	    l.setText("Result: "+(v1+v2));
		d.removeAll();
		d.add(i1);
		d.add(i2);
		revalidate();
		repaint();
		
		
		
		
	}

	public static void main(String[] args) {
		RollDice rollDice = new RollDice();
	
	}
}
