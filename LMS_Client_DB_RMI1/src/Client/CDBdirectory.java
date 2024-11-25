package Client;

import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.tree.DefaultMutableTreeNode;

import inter.IDBdirectory;

public class CDBdirectory implements IDBdirectory {
    private IDBdirectory iDBdirectory;

    public CDBdirectory() {
        try {
            String url = "rmi://localhost/CDBdirectory";
            this.iDBdirectory = (IDBdirectory) Naming.lookup(url);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public DefaultMutableTreeNode getDirectoryTree() throws RemoteException {
        try {
            DefaultMutableTreeNode TreeNode = iDBdirectory.getDirectoryTree();
            return TreeNode;
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}