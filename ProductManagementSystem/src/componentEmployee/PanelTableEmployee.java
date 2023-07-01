package componentEmployee;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import color.ColorBackground;
import componentButton.Button;
import dao.DAOEmployee;
import model.ModelEmployee;
import view.MainForm;
import view.PanelMode;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCreateProduct.PanelTitle;
import componentDialog.DialogQuestion;
import componentMainCustomer.ButtonAddToCard;
import animation.TextField;
import javax.swing.JButton;

public class PanelTableEmployee extends JPanel {

	public Color color = ColorBackground.colorDark;
	private static TableEmployee table;
	private static DAOEmployee dao = new DAOEmployee();
	private static ArrayList<ModelEmployee> datas = new ArrayList<ModelEmployee>();
	private ButtonCheckedSizeAndColor btnDelete;
	private ButtonCheckedSizeAndColor btnAdd;
	DialogFormAddEmployee dialogAddEmployee;
	private int indexSelected = -1;
	private DialogQuestion question = new DialogQuestion(null);
	private TextField txtSearch;
	
	public PanelTableEmployee() {
		setOpaque(false);

		JPanel panel = new JPanel();
		panel.setOpaque(false);

		JPanel panelTable = new JPanel();
		panelTable.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelTable, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 743,
										Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelTable, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE).addContainerGap()));
		
		JLabel lblNewLabel = new JLabel("Nhân Viên");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(252, 252, 252));
		
		PanelTitle panelFind = new PanelTitle();
		
		txtSearch = new TextField();
		txtSearch.setHint("Tìm kiếm nhân viên...");
		txtSearch.setForeground(new Color(252, 252, 252));
		txtSearch.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtSearch.setCaretColor(new Color(252, 252, 252));
		txtSearch.setBorder(null);
		GroupLayout gl_panelFind = new GroupLayout(panelFind);
		gl_panelFind.setHorizontalGroup(
			gl_panelFind.createParallelGroup(Alignment.LEADING)
				.addGap(0, 430, Short.MAX_VALUE)
				.addGroup(gl_panelFind.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
		);
		gl_panelFind.setVerticalGroup(
			gl_panelFind.createParallelGroup(Alignment.LEADING)
				.addGap(0, 28, Short.MAX_VALUE)
				.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
		);
		panelFind.setLayout(gl_panelFind);
		
		btnDelete = new ButtonCheckedSizeAndColor(0);
		btnDelete.setEnabled(false);		
		btnDelete.setFont(new Font("Roboto", Font.PLAIN, 13));
		btnDelete.setText("Xóa Nhân Viên");
		btnDelete.setForeground(ColorBackground.colorLight);
		
		btnAdd = new ButtonCheckedSizeAndColor(0);
		btnAdd.setText("Thêm Nhân Viên");
		btnAdd.setForeground(new Color(252, 252, 252));
		btnAdd.setFont(new Font("Roboto", Font.PLAIN, 13));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDelete, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelFind, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
							.addGap(44))))
		);
		panel.setLayout(gl_panel);

		table = new TableEmployee();

		JScrollPane scrollPane = new JScrollPane(table);

		table.addTableStyle(scrollPane);

		GroupLayout gl_panelTable = new GroupLayout(panelTable);
		gl_panelTable.setHorizontalGroup(gl_panelTable.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE));
		gl_panelTable.setVerticalGroup(
				gl_panelTable.createParallelGroup(Alignment.LEADING).addGroup(gl_panelTable.createSequentialGroup()
						.addGap(2).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)));
		panelTable.setLayout(gl_panelTable);
		setLayout(groupLayout);
		if (MainForm.mode == "Dark") {
			setColor(ColorBackground.colorDark);
		} else {
			setColor(ColorBackground.colorLight);
		}
		init();
		action();
	}

	public static void init() {
		datas = dao.selectAll();
		fillTable();
	}

	public static void fillTable() {
		table.tableModel.setRowCount(0);
		for (ModelEmployee data : datas) {
			String gnd = "";
			boolean gender = data.isGender();
			if(gender) {
				gnd = "Nam";
			}else {
				gnd = "Nữ";
			}
			
			long roundValue = Math.round(data.getSalary());
			
			table.tableModel.addRow(new Object[] { data.getIdEmployee(), data.getName(), data.getChucVu(),
					gnd, data.getAddRess(), data.getNgaySinh(), data.getPhone(), data.getEmail(),
					roundValue });
		}
	}

	public void action() {	
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = datas.get(indexSelected).getIdEmployee();
				if(dao.delete(id)>0) {
					init();
					question.lblTextMessage.setText("Xóa Nhân Viên Thành Công");
					int x = 650;
					int y = 290;
					MainForm.setLocationDialog(x, y);
					MainForm.setLocationMouseDragged(x, y);
					question.setLocation(MainForm.xScreen, MainForm.yScreen);
					question.setAlwaysOnTop(true);
					question.setVisible(true);
				}else {
					System.out.println("Delete fail");
				}
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount() == 1) {
					indexSelected = table.getSelectedRow();	
					btnDelete.setEnabled(true);
				}
			}
		});
		
		
		PanelMode.actionButonModeDark(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColor(ColorBackground.colorDark);
			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setColor(ColorBackground.colorLight);
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// show form add Employee
				if(indexSelected>-1) {
					dialogAddEmployee = new DialogFormAddEmployee(null,new ModelEmployee(
							datas.get(indexSelected).getIdEmployee(), 
							datas.get(indexSelected).getName(), 
							datas.get(indexSelected).getChucVu(), 
							datas.get(indexSelected).isGender(), 
							datas.get(indexSelected).getNgaySinh(), 
							datas.get(indexSelected).getAddRess(), 
							datas.get(indexSelected).getPhone(), 
							datas.get(indexSelected).getEmail(), 
							datas.get(indexSelected).getSalary()));
				}else {
					dialogAddEmployee = new DialogFormAddEmployee(null,null);
				}
				
				dialogAddEmployee.setModalityType(ModalityType.TOOLKIT_MODAL);
				MainForm.setLocationDialog(400,80);
				MainForm.setLocationMouseDragged(400,80);
				dialogAddEmployee.setLocation(MainForm.xScreen,MainForm.yScreen);
				dialogAddEmployee.setVisible(true);	
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// show form delete Employee
				
			}
		});
		
		PanelAddEmployee.btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Close DialogAddEmployee
				dialogAddEmployee.setVisible(false);
			}
		});
		
		txtSearch.addCaretListener(new CaretListener() {	
			@Override
			public void caretUpdate(CaretEvent e) {
				String name = txtSearch.getText();
				if(name.equals("")) {
					init();
				}else {
					datas = dao.Find(new ModelEmployee(name));
					fillTable();
				}
				
				
				
			}
		});
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		
		super.paintComponent(g);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		repaint();
	}
}
