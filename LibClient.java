package webjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class LibClient {

	public static void main(String[] args) throws IOException {
		Socket sock = new Socket(InetAddress.getLocalHost(),9090); 
		OutputStreamWriter optwriter = new OutputStreamWriter(sock.getOutputStream());
		BufferedReader bufread = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("Please choose: A for Register, B for login, Press enter to fix");
			String input = scan.readLine();
			if(input.equalsIgnoreCase("a"))
			{
				getInfo(optwriter, scan, input);
				System.out.println(bufread.readLine());
			}
			else if(input.equalsIgnoreCase("b"))
			{
				getInfo(optwriter, scan, input);
				System.out.println(bufread.readLine());
			}
			else
			{
				System.out.println("Wrong Info,Please input again");
			}
		}
		
	}

	public static void getInfo(OutputStreamWriter optwriter,
		BufferedReader scan, String input) throws IOException {
		System.out.println("Please enter your name");
		String name = scan.readLine();
		System.out.println("Please enter your password");
		String password = scan.readLine();
		String info = input + " " + name + " " + password + "\r\n";
		optwriter.write(info);
		optwriter.flush();
	}

}

