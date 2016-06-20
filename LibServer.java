package webjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class LibServer extends Thread {
	Socket socket;

	public static void main(String[] args) throws IOException {
		ServerSocket sersock = new ServerSocket(9090);
		while(true)
		{
			LibServer lib = new LibServer(sersock.accept());
			lib.start();
		}
	}

	@Override
	public void run() {
		try {
			BufferedReader bufread = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			OutputStreamWriter optwriter = new OutputStreamWriter(socket.getOutputStream());
			while(true)
			{
				String info = bufread.readLine();
				String[] word = info.split(" ");
				String choice = word[0];
				String name = word[1];
				String passwd = word[2];
				File file = new File("F:\\lib.properties");
				Properties prop = new Properties();
				if(!file.exists())
				{
					file.createNewFile();
				}
				prop.load(new FileInputStream(file));
				if(choice.equalsIgnoreCase("a"))
				{
					if(prop.containsKey(name))
					{
						optwriter.write("The user already exists, Please change another name!\r\n");
						optwriter.flush();
					}
					else 
					{
						prop.setProperty(name, passwd);
						prop.store(new FileWriter(file), "Info");
						optwriter.write("Successfully registered!\r\n");
						optwriter.flush();
					}
				}
				else if(choice.equalsIgnoreCase("b"))
				{
					if(prop.containsKey(name))
					{
						if(prop.getProperty(name).equals(passwd))
						{
							optwriter.write("Successfully logged in!Welcome "+ name +"\r\n");
							optwriter.flush();
						}
						else
						{
							optwriter.write("Wrong password!\r\n");
							optwriter.flush();
						}
					}
					else 
					{
						optwriter.write("The usr doesn't exist\r\n");
						optwriter.flush();
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LibServer(Socket socket)
	{
		this.socket = socket;
	}
}
