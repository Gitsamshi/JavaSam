package webjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	public static void main(String[] args) throws IOException {
		chatMore();
	}

	public static void chatOne() throws IOException, UnknownHostException {
		Socket sock = new Socket(InetAddress.getLocalHost(),9090);
		OutputStream optStream = sock.getOutputStream();
		optStream.write("Hi, Server, do you copy?".getBytes());
		
		byte[] buf = new byte[1024];
		InputStream iptStream = sock.getInputStream();
		int length = iptStream.read(buf);
		System.out.println("Client Receives: "+new String(buf,0,length));
		sock.close();
	}
	
	public static void chatMore() throws IOException
	{
		Socket sock = new Socket(InetAddress.getLocalHost(),9090);
		OutputStreamWriter optWriter = new OutputStreamWriter(sock.getOutputStream());
		InputStreamReader iptReader = new InputStreamReader(System.in);
		BufferedReader bufReader = new BufferedReader(iptReader);
		
		String line = null;
		System.out.println("Client sends ");
		while((line = bufReader.readLine())!=null)
		{
			optWriter.write(line+"\r\n");
			optWriter.flush();
			BufferedReader bufReader2 = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String line2 = bufReader2.readLine();
			System.out.println("Client receives: " + line2);
			System.out.println("Client sends ");
		}
		
		
		sock.close();
	}

}
