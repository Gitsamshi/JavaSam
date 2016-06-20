package webjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Browser extends Thread{

	Socket socket;
	
	public Browser(Socket socket)
	{
		this.socket = socket;
	}
	
	public static void main(String[] args) {
		try {
			ServerSocket sersock = new ServerSocket(9090);
			while(true)
			{
				Browser bro = new Browser(sersock.accept());
				bro.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		try {
			OutputStream outputstream = socket.getOutputStream();
			File file = new File("F:\\ff\\5.jpg");
			FileInputStream finput = new FileInputStream(file);
			byte[] buf = new byte[1024];
			int length = 0;
			while((length = finput.read(buf))!=-1)
			{
				outputstream.write(buf,0,length);
			}
			String ip = socket.getInetAddress().getHostAddress();
			System.out.println("ip: "+ip);
			finput.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
