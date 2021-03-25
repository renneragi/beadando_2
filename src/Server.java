import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(1234);

		while (true) {
			Socket s = ss.accept();
			new Thread(new Service(s)).start();
		}
	}

}
