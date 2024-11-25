package Control;

import Model.MLoginDB;
import inter.ILogin;
import valueObjectServer.VUserInfo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class CLogin extends UnicastRemoteObject implements ILogin {

    private static final long serialVersionUID = 1L;
    private Map<String, String> loggedInUsers = new HashMap<>(); 

    public CLogin() throws RemoteException {
        super();
    }

    @Override
    public VUserInfo getUserInfo(String ID, String password) throws RemoteException {

        if (loggedInUsers.containsKey(ID)) {
            return null; 
        }

        MLoginDB mLoginDB = new MLoginDB();
        VUserInfo VUserInfo = mLoginDB.logincheck(ID, password);


        if (VUserInfo != null) {
            String sessionToken = generateSessionToken();
            loggedInUsers.put(ID, sessionToken);
        }

        return VUserInfo;
    }

    private String generateSessionToken() {

        return "SESSION_" + System.currentTimeMillis();
    }
}
