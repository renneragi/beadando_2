import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws IOException, UnknownHostException {
		Socket s = new Socket("127.0.0.1", 1234);

		// ide jön, az amit a kliens csinál
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("A tárolandó szöveg:");
		String dataToSave = reader.readLine();

		PrintWriter pw = new PrintWriter(s.getOutputStream());
		pw.print(dataToSave);
		pw.flush();
	
		pw.close();
		s.close();
	}
}
