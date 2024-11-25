package Presentation;

import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.LayoutManager;
import java.awt.Component;
import java.awt.Container;
import java.awt.Color;
public class PMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private PDBdirectory pdbDirectory;
	private PLRButtonPanel pmiridamgibutton;
	private PLRButtonPanel psugangsinchengbutton;
	private PTable pmiridamgi;
	private PTable psugangsincheng;
	private PUDButtonPanel changebutton;
	private PClock pclock;

	public PMainPanel() {
		setLayout(new AbsoluteLayout());
		setBackground(Color.GRAY);
		
		this.pclock = new PClock();
		addComponent(pclock, new Rectangle(20, 0, 150, 50));

		this.pdbDirectory = new PDBdirectory();
		addComponent(pdbDirectory, new Rectangle(20, 60, 550, 850));

		this.pmiridamgibutton = new PLRButtonPanel();
		addComponent(pmiridamgibutton, new Rectangle(580, 230, 50,75));

		this.psugangsinchengbutton = new PLRButtonPanel();
		addComponent(psugangsinchengbutton, new Rectangle(580, 660, 50, 75));

		this.pmiridamgi = new PTable();
		addComponent(pmiridamgi, new Rectangle(650, 60, 680, 350));

		this.changebutton = new PUDButtonPanel();
		addComponent(changebutton, new Rectangle(950, 430, 50, 70));

		this.psugangsincheng = new PTable();
		addComponent(psugangsincheng, new Rectangle(650, 520, 680, 350));

	}

	public void initialize() {
		this.pmiridamgibutton.associate(this.pdbDirectory, this.pmiridamgi);
		this.psugangsinchengbutton.associate(this.pdbDirectory, this.psugangsincheng);
		this.changebutton.associate(this.pmiridamgi, this.psugangsincheng, this.pdbDirectory);
		this.pdbDirectory.initialize();
		this.pmiridamgibutton.initialize();
		this.psugangsinchengbutton.initialize();
		this.pmiridamgi.initialize("미리담기");
		this.psugangsincheng.initialize("수강신청");
		this.changebutton.initialize();
	}

	private void addComponent(JComponent component, Rectangle bounds) {
		component.setBounds(bounds);
		add(component);
	}

	private static class AbsoluteLayout implements LayoutManager {

		@Override
		public void addLayoutComponent(String name, Component comp) {
	
		}

		@Override
		public void removeLayoutComponent(Component comp) {

		}

		@Override
		public Dimension preferredLayoutSize(Container parent) {
			return new Dimension(0, 0);
		}

		@Override
		public Dimension minimumLayoutSize(Container parent) {
			return new Dimension(0, 0);
		}

		@Override
		public void layoutContainer(Container parent) {
			for (Component component : parent.getComponents()) {
				if (component instanceof JComponent) {
					JComponent jComponent = (JComponent) component;
					Rectangle bounds = jComponent.getBounds();
					jComponent.setBounds(bounds);
				}
			}
		}
	}
}