package Lab4;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Chat_client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			Socket mysocket = new Socket("localhost", 8500);
			System.out.println("Da ket noi toi Server\n");
			DataOutputStream dos = new DataOutputStream(mysocket.getOutputStream());
			DataInputStream dis = new DataInputStream(mysocket.getInputStream());
			Scanner sc = new Scanner(System.in);
			while (true) {
				String str = sc.nextLine();
				dos.writeUTF(str);
				if (str.equals("q")) {
					break;
				}
				String str2 = dis.readUTF();
				System.out.println("Server: " + str2);
			}
			dos.close();
			dis.close();
			mysocket.close();
		} catch (Exception e) {
			// TODO: handle exception
			
			
			e.printStackTrace();
		}

	}

}
