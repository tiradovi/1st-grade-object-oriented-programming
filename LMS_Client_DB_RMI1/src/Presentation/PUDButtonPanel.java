package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

public class PUDButtonPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JButton downButton;
    private JButton upButton;
    private PTable pmiridamgi;
    private PTable psugangsincheng;
    private PDBdirectory pdbDirectory;

    public PUDButtonPanel() {
        ActionHandler actionHandler = new ActionHandler();

        this.downButton = new JButton("⌄");
        this.downButton.addActionListener(actionHandler);
        this.add(downButton);

        this.upButton = new JButton("⌃");
        this.upButton.addActionListener(actionHandler);
        this.add(upButton);
    }

    public void associate(PTable pmiridamgi, PTable psugangsincheng, PDBdirectory pdbDirectory) {
        this.pmiridamgi = pmiridamgi;
        this.psugangsincheng = psugangsincheng;
        this.pdbDirectory = pdbDirectory;
    }

    public void initialize() {

    }

    private void moveuTableTodTable() {
        String lectures = this.pmiridamgi.getLectures();
        if (lectures != null) {
            this.pmiridamgi.removeSelectedRow();

            // Get lectures information from directory
            DefaultMutableTreeNode selectedNode = this.pdbDirectory.getLectures();
            this.psugangsincheng.addLectures(selectedNode);
        }
    }

    private void movedTableTouTable() {
        String lectures = this.psugangsincheng.getLectures();
        if (lectures != null) {
            this.psugangsincheng.removeSelectedRow();

            // Get lectures information from directory
            DefaultMutableTreeNode selectedNode = this.pdbDirectory.getLectures();
            this.pmiridamgi.addLectures(selectedNode);
        }
    }

    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == downButton) {
                moveuTableTodTable();
            } else if (e.getSource() == upButton) {
                movedTableTouTable();
            }
        }
    }
}
