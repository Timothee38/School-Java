import java.io.*; 
import java.util.*; 
import java.net.*;

public class Serveur {
    public static void main(String args[]) {
		if (args.length > 1) {
			System.out.println("usage: java Client"); 
		}
		else {
				try {
				
				ServerSocket connection = new ServerSocket(8080);
				Socket socket = connection.accept();
				InputStream is = socket.getInputStream();
				InputStreamReader reader = new InputStreamReader(is);
				
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				
				BufferedReader in = new BufferedReader(reader);
				String line;
				
				while((line = in.readLine()) != null) {
					System.out.println(line);
					// Sending the line back

					out.println(line);
				}
				
				System.out.println();
				in.close();
				reader.close(); 
				is.close(); 
		
				} catch (Exception e) {
					e.printStackTrace();
				}   
			
		}
    }
}
