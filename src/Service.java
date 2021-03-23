import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Timestamp;

public class Service implements Runnable {
	private Socket s;

	public Service(Socket s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// Ide jön, az amit a szerver csinál

		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
			String dataToSave = bf.readLine();
			int hash = dataToSave.hashCode();

			File newFile = new File("./target/" + hash+".txt");
			if (newFile.createNewFile()) {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				PrintWriter outFile;
				outFile = new PrintWriter(new FileWriter(newFile));
				outFile.write(timestamp.toString());
				outFile.write(" " + dataToSave);
				outFile.close();

			} else {
				System.out.println("File already exists.");
			}

			PrintWriter pw = new PrintWriter(s.getOutputStream());
			pw.print("Sikeres mentés");
			pw.flush();

			pw.close();
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
