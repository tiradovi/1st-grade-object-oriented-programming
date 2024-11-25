package Client;

import java.rmi.Naming;
import java.rmi.RemoteException;

import inter.ILogin;
import valueObjectServer.VUserInfo;



public class CLogin implements ILogin {
	private ILogin ilogin;

	public CLogin() {
		try {
			String url = "rmi://localhost/CLogin";
			this.ilogin = (ILogin) Naming.lookup(url);
		} catch (Exception e) {
			System.err.println("Client exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public VUserInfo getUserInfo(String ID, String Password) throws RemoteException {
		
		try {
			VUserInfo VUserInfo = ilogin.getUserInfo(ID, Password);
			return VUserInfo;


		} catch (Exception e) {
			System.err.println("Client exception: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
