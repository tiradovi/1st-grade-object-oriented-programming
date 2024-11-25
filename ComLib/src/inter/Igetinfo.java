package inter;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Igetinfo extends Remote {
    List<Object[]> getinfo(String courseName) throws RemoteException;
}
