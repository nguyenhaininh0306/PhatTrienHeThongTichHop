package Lab3;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class cau5_server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(8050);
			System.out.println("Server duoc tao");
			Socket client = server.accept();
			System.out.println("Client ket noi den Server");
			Scanner inFromClient = new Scanner(client.getInputStream());
			PrintStream outToClient = new PrintStream(client.getOutputStream());
			outToClient.println("Nhap ten cua ban: ");
			String tens = inFromClient.nextLine();
			System.out.println("client: " + tens);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			tens = br.readLine();
			char []stt = tens.toCharArray();
			for (int i = stt.length - 1; i>=0; i--) {
				outToClient.println(stt[i]);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
