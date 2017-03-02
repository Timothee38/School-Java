import java.io.*; 
import java.util.*;
import java.net.*; 


public class Client {
	
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost", 8080); 
			
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			String line = "";
				
			while(!(line.equalsIgnoreCase("bye"))) {
				//System.out.println(line);

				line = br.readLine();
				out.println(line);
				
				line = socketIn.readLine();
				
				if(line!=null) {
					System.out.println(line);
				}
			}
				
		} catch(Exception e) { 
			e.printStackTrace();
		}
			
	}
	
}
