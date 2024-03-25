package chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.*;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;

import chat.ChatServer.exite;
import encryption.Encryption;


public class ChatClient extends JFrame implements Runnable{

	private static final String RSA = "RSA";
	private static final String SERVER_PUBLIC_KEY = "MIGeMA0GCSqGSIb3DQEBAQUAA4GMADCBiAKBgGk9wUQ4G9PChyL5SUkCyuHjTNOglEy5h4KEi0xpgjxi/UbIH27NXLXOr94JP1N5pa1BbaVSxlvpuCDF0jF9jlZw5IbBg1OW2R1zUACK+NrUIAYHWtagG7KB/YcyNXHOZ6Icv2lXXd7MbIao3ShrUVXo3u+5BJFCEibd8a/JD/KpAgMBAAE=";
	private PublicKey serverPublicKey;
	private Key communicationKey;
	private JTextArea t1;
	private JScrollPane p1;
	private JMenuBar m1;
	private JMenu file;
	private JMenuItem exit;
	private JMenuItem conn;
	private JTextField tf;
	private ActionListener e;
	private ActionListener e2;
	private ActionListener e3;
	private Socket so=null;
	
	private DataInputStream in;
	private DataOutputStream out;
	private Thread g=new Thread(this);
	public ChatClient() {
		super("Chat Client");
		try {
			serverPublicKey = Encryption.readPublicKey(SERVER_PUBLIC_KEY);			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("error getting server public key: " + e.getMessage());
		}
		
		t1=new JTextArea();
		m1=new JMenuBar();
		file=new JMenu("File");
		t1.setEditable(false);
		exit=new JMenuItem("Exit");
		conn=new JMenuItem("Connect");
		tf=new JTextField();
		file.add(conn);
		file.add(exit);
		e=new exite();
		exit.addActionListener(e);
		e2=new connect();
		conn.addActionListener(e2);
		e3=new chat();
		tf.addActionListener(e3);
		
		m1.add(file);
		p1=new JScrollPane(t1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setSize(400,400);
		setLayout(new BorderLayout());
		setJMenuBar(m1);
		add(p1,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
		
	}
	
class exite implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
    	{
    		System.exit(0);
    	}
		
	};
	
	
	
class connect implements ActionListener{
	
		public void actionPerformed(ActionEvent e)
    	{
    		try {
    			so=new Socket("localhost",9898);
    			t1.append("connected"+"\n");
    			g.start();
    			
    		}
    		catch(Exception ex)
    		{
    			ex.printStackTrace();
    		}
    	}
		
	};
	
class chat implements ActionListener{
	
		public void actionPerformed(ActionEvent e)
    	{
    		try {
    			
				out=new DataOutputStream(so.getOutputStream());
				
				
				String se=tf.getText().trim();
				String encw=Encryption.encrypt(communicationKey, se);
				out.writeUTF(encw);
				out.flush();
				tf.setText("");
				
				
    			
    		}
    		catch(Exception ex)
    		{
    			ex.printStackTrace();
    		}
    	}
		
	};
	
	
	
	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient();
	}

	




	@Override
	public void run() {
		
			try {
			in=new DataInputStream(so.getInputStream());
			out=new DataOutputStream(so.getOutputStream());
			out.writeUTF("HELLO");
			String ggh=in.readUTF();
			String fff="connected \n";
		    
			if(ggh.equals(fff))
			{
				byte seed1[] =Encryption.generateSeed();
				byte seedr[]=Encryption.pkEncrypt(serverPublicKey, seed1);
				
				
				out.write(seedr);
				 communicationKey=Encryption.generateAESKey(seed1);
				 
				 
				
			}
			while(true)
			{
				String m=in.readUTF();
				t1.setText(m+"\n");
				
			}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	
}