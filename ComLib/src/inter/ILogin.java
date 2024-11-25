package inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILogin extends Remote {
    public <VUserInfo> VUserInfo getUserInfo(String ID, String password) throws RemoteException;
}