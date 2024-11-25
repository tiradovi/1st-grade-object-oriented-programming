package Presentation;

import java.awt.Dimension;
import java.rmi.RemoteException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import Client.CDBdirectory;

public class PDBdirectory extends JPanel {
    private static final long serialVersionUID = 1L;

    public PDBdirectory() {
        try {
            CDBdirectory cDBdirectory = new CDBdirectory();
            DefaultMutableTreeNode rootNode;
            rootNode = cDBdirectory.getDirectoryTree();
            JTree tree = new JTree(rootNode);
            tree.setPreferredSize(new Dimension(500, 800));
            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

            String titleText ="강좌목록";
            TitledBorder titledBorder = BorderFactory.createTitledBorder(titleText);
            this.setBorder(titledBorder);

            this.add(tree);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {

    }

    public DefaultMutableTreeNode getLectures() {
        JTree tree = (JTree) this.getComponent(0);
        return (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    }

    public void addLectures(DefaultMutableTreeNode lectures) {

    }
}
