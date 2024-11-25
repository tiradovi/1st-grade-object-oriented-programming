package ServerMain;

import Server.RMIServer;

public class Main {
	private RMIServer rmiserver;
	
	public void run() {
	    rmiserver= new RMIServer();
		rmiserver.Server();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();

	}

}
 