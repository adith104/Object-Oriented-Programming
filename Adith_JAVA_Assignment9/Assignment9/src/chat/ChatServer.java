package chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;

import encryption.Encryption;

import java.security.*;


public class ChatServer extends JFrame implements Runnable{

	private static final String RSA = "RSA";
	private Key privateKey;
	private JTextArea t1;
	private JScrollPane p1;
	private JMenuBar m1;
	private JMenu file;
	private JMenuItem exit;
	private ActionListener e;
	private String g="connected \n";
	
	private int c=0;
	private List<DataOutputStream> os;
	
	
	
	
	public ChatServer() {
	
		super("Chat Server");
		os=new ArrayList<>();

		try {
			privateKey = Encryption.readPrivateKey("keypairs/pkcs8_key");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem loading private key: " + e.getMessage());
			System.exit(1);
		}
		Thread g=new Thread(this);
		t1=new JTextArea();
		m1=new JMenuBar();
		file=new JMenu("File");
		t1.setEditable(false);
		exit=new JMenuItem("Exit");
		
		file.add(exit);
		e=new exite();
		exit.addActionListener(e);
		
		m1.add(file);
		p1=new JScrollPane(t1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setSize(400,400);
		setJMenuBar(m1);
		add(p1);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		g.start();
		
	}
class exite implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
    	{
    		System.exit(0);
    	}
		
	};
	

	
	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
	}

	class Client implements Runnable{
		private int c;
		private Socket so;
		
		Client(int c,Socket so)
		{
			this.so=so;
			this.c=c;
		}
		
		public void run()
		{
			try {
				Key k2=null;
				DataInputStream in=new DataInputStream(so.getInputStream());
				DataOutputStream out=new DataOutputStream(so.getOutputStream());
				os.add(out);
				String h;
				int rr=0;
				while(true)
				{
					out.writeUTF(g);
					h=in.readUTF();
					String ggg="HELLO";
					if(rr==0)
					{ 
						if(h.equals(ggg))
						{
							byte [] l=new byte[128];
							
							
						  out.writeUTF(g);
						  in.readFully(l);
						  byte [] dec=Encryption.pkDecrypt(privateKey, l);
						  k2=Encryption.generateAESKey(dec);
						  System.out.println(k2);
						}
						rr++;
					}
					else {
						String dec=Encryption.decrypt(k2, h);
					g+=c+".:"+dec+"\n";
					broadcast(g);}
					
				}
				
				
				
				
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
		}
		
		
	}

	private void broadcast(String m)
	{
		for(DataOutputStream os:os)
		{
			try
			{
				os.writeUTF(m);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		try {
		ServerSocket s=new ServerSocket(9898);
		t1.append("Chat server started at "+new Date()+"\n");
		
		while(true)
		{
			Socket so=s.accept();
			InetAddress i=so.getInetAddress();
			c++;
			t1.append("Starting thread for client "+c+" at "+new Date()+"\n");
			t1.append("Client "+c+"s host name is:"+i.getHostName()+"\n");
			t1.append("Client "+c+"s IP Address is:"+i.getHostAddress()+"\n");
			
			Thread f=new Thread(new Client(c,so));
			f.start();
			
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	

	
	
}


