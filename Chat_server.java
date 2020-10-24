package Lab4;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Chat_server {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket svsocket = new ServerSocket(8500);
			System.out.println("Server da duoc tao\n");
			Socket clsocket = svsocket.accept();
			DataOutputStream dos = new DataOutputStream(clsocket.getOutputStream());
			DataInputStream dis = new DataInputStream(clsocket.getInputStream());
			Scanner sc = new Scanner(System.in);
			while (true) {
				String str = dis.readUTF();
				if (str.equals("q")) {
					break;
				}
				System.out.println("Client: " + str);
				String str2 = sc.nextLine();
				dos.writeUTF(str2);
				dos.flush();
			}
			dos.close();
			dis.close();
			svsocket.close();
		} catch (Exception e) {
			// TODO: handle exception
			
			
			System.out.println(e.getMessage());
		}

	}

}
