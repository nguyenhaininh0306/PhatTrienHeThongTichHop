package Lab4;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DocSo_client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket mySocket = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		try {
			mySocket = new Socket("localhost",8000);
			dos = new DataOutputStream(mySocket.getOutputStream());
			dis = new DataInputStream(mySocket.getInputStream());
			Scanner input = new Scanner(System.in);
			String s = null;
			while (true) {
				System.out.println("\nNhap du lieu: ");
				s = input.nextLine();
				dos.writeUTF(s);
				
				String str = dis.readUTF();
				System.out.println("Ket qua tu server: " + str);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ngat ket noi");
			dis.close();
			dos.close();
			mySocket.close();
			e.printStackTrace();
		}

	}

}
