package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

public class PLRButtonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton lButton;
	private JButton rButton;
	private PDBdirectory pdbDirectory;
	private PTable table;

	public PLRButtonPanel() {
		ActionHandler actionHandler = new ActionHandler();

		this.lButton = new JButton(">>");
		this.lButton.addActionListener(actionHandler);
		this.add(lButton);

		this.rButton = new JButton("<<");
		this.rButton.addActionListener(actionHandler);
		this.add(rButton);
	}

	public void associate(PDBdirectory pdbDirectory, PTable table) {
		this.pdbDirectory = pdbDirectory;
		this.table = table;
	}

	public void initialize() {

	}

	private void moveDirectoryToTable() {
		DefaultMutableTreeNode lectures = this.pdbDirectory.getLectures();
		if (lectures != null) {
			this.table.addLectures(lectures);
		}
	}

	private void moveTableToDirectory() {
		 table.removeSelectedRow();

	}

	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == lButton) {
				moveDirectoryToTable();
			} else if (e.getSource() == rButton) {
				moveTableToDirectory();
			}
		}
	}
}
