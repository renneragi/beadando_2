import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws IOException, UnknownHostException {
		Socket s = new Socket("127.0.0.1", 1234);
		
		//ide j�n, az amit a kliens csin�l
		
		s.close();
	}

}
