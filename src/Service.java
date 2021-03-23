import java.net.Socket;

public class Service implements Runnable {
	private Socket s;
	
	public Service(Socket s) {
		super();
		this.s = s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Ide jön, az amit a szerver csinál
	}

}
