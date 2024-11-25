package Client;

import inter.Iaccount;
import java.rmi.Naming;

public class CCreateaccount implements Iaccount {
	Iaccount Iaccount;

	public CCreateaccount() {
		try {
			String url = "rmi://localhost/CCreateaccount";
			this.Iaccount = (Iaccount) Naming.lookup(url);
		} catch (Exception e) {
			System.err.println("Client exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void createAccount(String ID, String Password, String Name) {
		try {Iaccount.createAccount(ID, Password, Name);
		} catch (Exception e) {
			System.err.println("Client exception: " + e.getMessage());
			e.printStackTrace();

		}

	}

}
