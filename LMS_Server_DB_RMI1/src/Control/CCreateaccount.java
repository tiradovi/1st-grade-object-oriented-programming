
package Control;

import inter.Iaccount;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Model.MCreateaccountDB;

public class CCreateaccount extends UnicastRemoteObject implements Iaccount {
    private static final long serialVersionUID = 1L;
	public CCreateaccount() throws RemoteException {
		super();
	}

	@Override
	public void createAccount(String id, String password, String name) throws RemoteException {
		MCreateaccountDB MCreateaccountDB = new MCreateaccountDB();
		MCreateaccountDB.createAccount(id, password, name);

	}
}
