package inter;

import javax.swing.tree.DefaultMutableTreeNode;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDBdirectory extends Remote {
    DefaultMutableTreeNode getDirectoryTree() throws RemoteException;
}