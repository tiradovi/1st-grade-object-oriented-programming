package Control;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.tree.DefaultMutableTreeNode;
import Model.MDBdirectory;
import inter.IDBdirectory;

public class CDBdirectory extends UnicastRemoteObject implements IDBdirectory {
    private static final long serialVersionUID = 1L;
    private MDBdirectory mDBdirectory;

    public CDBdirectory() throws RemoteException {
        super();
    }

    public DefaultMutableTreeNode getDirectoryTree() throws RemoteException {
        mDBdirectory = new MDBdirectory();
        DefaultMutableTreeNode node = mDBdirectory.getDirectoryTree(); // Fix variable name
        return node;
    }
}