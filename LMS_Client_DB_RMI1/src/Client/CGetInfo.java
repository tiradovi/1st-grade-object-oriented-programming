package Client;

import inter.Igetinfo;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

public class CGetInfo implements Igetinfo {
    Igetinfo igetinfo;

    public CGetInfo() {
        try {
            String url = "rmi://localhost/CGetInfo";
            this.igetinfo = (Igetinfo) Naming.lookup(url);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Object[]> getinfo(String courseName) throws RemoteException {
        try {
            return igetinfo.getinfo(courseName);
        } catch (RemoteException e) {
            System.err.println("RemoteException: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
