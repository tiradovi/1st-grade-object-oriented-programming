
package inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Iaccount extends Remote {
    void createAccount(String id, String password, String name) throws RemoteException;
}
