package webjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) throws IOException {
		chatMore();

	}

	public static void chatOne() throws IOException {
		ServerSocket sesock = new ServerSocket(9090);
		Socket sock = sesock.accept();
		
		InputStream iptStream = sock.getInputStream();
		byte[] buf = new byte[1024];
		int length = iptStream.read(buf);
		System.out.println("Server Receives:" + new String(buf,0,length));
		
		OutputStream optStream = sock.getOutputStream();
		optStream.write("Roger that, Client.".getBytes());
		sesock.close();
	}
	
	public static void chatMore() throws IOException
	{
		ServerSocket sesock = new ServerSocket(9090);
		Socket sock = sesock.accept();
		
		InputStreamReader iptReader = new InputStreamReader(sock.getInputStream());
		BufferedReader bufReader = new BufferedReader(iptReader);
		
		String line = null;
		while((line = bufReader.readLine())!=null)
		{
			System.out.println("The Server receives "+ line);
			System.out.println("The Server sends:");
			BufferedReader bufReader2 = new BufferedReader(new InputStreamReader(System.in));
			String line2 = bufReader2.readLine();
			OutputStreamWriter optWriter = new OutputStreamWriter(sock.getOutputStream());
			optWriter.write(line2+"\r\n");
			optWriter.flush();
		}
		sesock.close();
	}

}
