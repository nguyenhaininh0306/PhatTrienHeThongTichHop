package Lab4;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DocSo_server {
	private static ServerSocket svSocket = null;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			svSocket = new ServerSocket(8000);
			System.out.println("Da ket noi toi Server\n");
			Socket clSocket = null;
			clSocket = svSocket.accept();
			dos = new DataOutputStream(clSocket.getOutputStream());
			dis = new DataInputStream(clSocket.getInputStream());
			String inline = "";
			while (true) {
				inline = dis.readUTF();
				char ch[] = inline.toCharArray();
				if (Character.isDigit(ch[0])) {
					int i = Integer.parseInt(inline);
					switch (i) {
						case 0:
						{
							inline = "khong";
							break;
						}
						case 1:
						{
							inline = "Mot";
							break;
						}
						case 2:
						{
							inline = "Hai";
							break;
						}
						case 3:
						{
							inline = "Ba";
							break;
						}
						case 4:
						{
							inline = "Bon";
							break;
						}
						case 5:
						{
							inline = "Nam";
							break;
						}
						case 6:
						{
							inline = "Sau";
							break;
						}
						case 7:
						{
							inline = "Bay";
							break;
						}
						case 8:
						{
							inline = "Tam";
							break;
						}
						case 9:
						{
							inline = "Chin";
							break;
						}
					}
					dos.writeUTF(inline);
				} else {
					dos.writeUTF("Khong phai so nguyen");
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			dos.close();
			svSocket.close();
			dis.close();
			System.out.println(e.getMessage());
		}

	}

}
