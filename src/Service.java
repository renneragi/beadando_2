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

	private void saveDataToFile(String dataToSave, Timestamp timestamp) throws IOException {
		int hash = dataToSave.hashCode();
		File newFile = new File("./target/" + hash + ".txt");

		if (newFile.createNewFile()) {

			PrintWriter outFile = new PrintWriter(new FileWriter(newFile));
			outFile.write(timestamp.toString());
			outFile.write(" " + dataToSave);
			outFile.flush();
			outFile.close();

		} else {
			System.out.println("File already exists.");
		}

	}

	private void saveDataToLog(String dataToSave, Timestamp timestamp) throws IOException {
		PrintWriter outFile = new PrintWriter(new FileWriter("./target/log.txt", true));
		outFile.write(timestamp.toString() + " " + dataToSave + '\n');
		outFile.close();
		System.out.println(dataToSave);
	}

	@Override
	public void run() {
		BufferedReader bf;
		try {
			bf = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String datatToSave = bf.readLine();

			this.saveDataToFile(datatToSave, timestamp);
			this.saveDataToLog(datatToSave, timestamp);
			
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
