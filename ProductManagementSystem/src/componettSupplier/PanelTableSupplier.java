package componettSupplier;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.DAOSupplier;
import model.ModelSupplier;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelTableSupplier extends JPanel {

	private static TableSupplier table;
	private JTextField txtSearchNCC;
	private static DAOSupplier dao = new DAOSupplier();
	private int indexSelected = -1;
	private static ArrayList<ModelSupplier> datas = new ArrayList<ModelSupplier>();
	
	

	/**
	 * Create the panel.
	 */
	public PanelTableSupplier() {
		setOpaque(false);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		JPanel panelTable = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelTable, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelTable, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panelFindNCC = new JPanel();
		
		JLabel lblNCC = new JLabel("Nhà Cung Cấp");
		
		JButton btnThemNCC = new JButton("Thêm nhà cung cấp");
		btnThemNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnXoaNCC = new JButton("Xóa nhà cung cấp");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNCC, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelFindNCC, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
					.addComponent(btnThemNCC)
					.addGap(50)
					.addComponent(btnXoaNCC)
					.addGap(30))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNCC, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnThemNCC)
								.addComponent(btnXoaNCC))
							.addComponent(panelFindNCC, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		
		txtSearchNCC = new JTextField();
		txtSearchNCC.setText("Tìm nhà cung cấp");
		panelFindNCC.add(txtSearchNCC);
		txtSearchNCC.setColumns(10);
		panel.setLayout(gl_panel);
		table = new TableSupplier();
		JScrollPane scrollPane = new JScrollPane(table);
		GroupLayout gl_panelTable = new GroupLayout(panelTable);
		gl_panelTable.setHorizontalGroup(
			gl_panelTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTable.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelTable.setVerticalGroup(
			gl_panelTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTable.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelTable.setLayout(gl_panelTable);
		setLayout(groupLayout);
		init();
		action();
	}
	public static void init() {
		datas = dao.SelectAll();
		fillTable();
	}
	private static void fillTable() {
		table.tableModel.setRowCount(0);
		for (ModelSupplier data : datas) {
		table.tableModel.addRow(new Object[] {data.getId(),
				data.getName(),data.getAddress(),data.getPhone(),
				data.getEmail(),data.getNote()});
			
		}
	}
	public void action() {
		
	}
	
}
