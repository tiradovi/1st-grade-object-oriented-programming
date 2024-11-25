package Presentation;

import java.awt.Dimension;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import Client.CGetInfo;

public class PTable extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private String titleText;
	private int totalCredits; 
	String[] columnNames = { "캠퍼스명", "대학명", "학과명", "강좌명", "강의시간", "교수명", "학점" };

	public PTable() {
		this.table = new JTable(new DefaultTableModel(columnNames, 0)); 
		this.titleText = "";
		this.totalCredits = 0; 

		TitledBorder titledBorder = BorderFactory.createTitledBorder(titleText);
		this.setBorder(titledBorder);

		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane);
		table.setPreferredScrollableViewportSize(new Dimension(650, 290));
	}

	public void initialize(String titleText) {
		this.titleText = titleText;
		this.totalCredits = 0; 
		TitledBorder titledBorder = BorderFactory.createTitledBorder(titleText);
		this.setBorder(titledBorder);
	}

	public void removeSelectedRow() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int selectedRowIndex = table.getSelectedRow();
		if (selectedRowIndex != -1) {
			int credits = Integer.parseInt(table.getValueAt(selectedRowIndex, 6).toString()); // 선택된 행의 학점
			model.removeRow(selectedRowIndex);
			totalCredits -= credits; // 학점의 합 업데이트
		}
	}
	public void addLectures(DefaultMutableTreeNode selectedNode) {
		try {
			String courseName = selectedNode.getUserObject().toString().split(" ")[0];
			CGetInfo cgetInfo = new CGetInfo();
			List<Object[]> resultList = cgetInfo.getinfo(courseName);

			if (!resultList.isEmpty()) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				for (Object[] rowData : resultList) {
					int credits = Integer.parseInt(rowData[6].toString());
					String lectureName = rowData[3].toString(); // 강좌명 가져오기

					// 중복 체크
					if (!isDuplicateLecture(lectureName)) {
						if (totalCredits + credits <= 18) {
							model.addRow(rowData);
							totalCredits += credits;
						} else {
							JOptionPane.showMessageDialog(this, "학점의 합이 18을 초과하므로 더 이상 강의를 추가할 수 없습니다.", "경고",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}
			}
		} catch (RemoteException e) {
			System.err.println("RemoteException: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String getLectures() {
		int selectedRowIndex = table.getSelectedRow();
		if (selectedRowIndex != -1) {
			return table.getValueAt(selectedRowIndex, 0).toString();
		}
		return null;
	}

	public void ChangeLectures(String lectures) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String[] lectureInfo = lectures.split(",");
		model.addRow(lectureInfo);
	}

	private boolean isDuplicateLecture(String lectureName) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			String existingLectureName = model.getValueAt(i, 3).toString(); // 현재 모델에 있는 강좌명
			if (existingLectureName.equals(lectureName)) {// 중복된 강좌명이 이미 테이블에 존재함
				JOptionPane.showMessageDialog(this, "같은 이름을 가진 강좌는 중복으로 추가할 수 없습니다.", "경고",
						JOptionPane.WARNING_MESSAGE);
				return true;
			}
		}
		return false;
	}
}
