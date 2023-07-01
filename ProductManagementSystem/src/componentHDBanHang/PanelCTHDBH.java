package componentHDBanHang;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

import color.ColorBackground;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import dao.DAOHDBHCT;
import model.ModelHDBHCT;

public class PanelCTHDBH extends JPanel {
	Color color1 = ColorBackground.colorDark;
	Color color2 = new Color(207, 106, 119);
	private JScrollPane scrollPane;
	TableCTHDBH table;
	public ButtonCheckedSizeAndColor btnCancel;
	private ButtonCheckedSizeAndColor btnchckdszndclrXutHan;

	DAOHDBHCT daocthdbh = new DAOHDBHCT();
	ArrayList<ModelHDBHCT> datas = new ArrayList<ModelHDBHCT>();
	public PanelCTHDBH() {
		setOpaque(false);

		JLabel lblHanChi = new JLabel("Hóa Đơn Chi Tiết");
		lblHanChi.setForeground(new Color(252, 252, 252));
		lblHanChi.setFont(new Font("Roboto", Font.BOLD, 16));
		table = new TableCTHDBH();
		scrollPane = new JScrollPane(table);
		table.addTableStyle(scrollPane);

		btnCancel = new ButtonCheckedSizeAndColor(0);
		btnCancel.setText("Hủy");
		btnCancel.setForeground(new Color(252, 252, 252));
		btnCancel.setFont(new Font("Roboto", Font.PLAIN, 14));

		btnchckdszndclrXutHan = new ButtonCheckedSizeAndColor(0);
		btnchckdszndclrXutHan.setText("Xuất Hóa Đơn");
		btnchckdszndclrXutHan.setForeground(new Color(252, 252, 252));
		btnchckdszndclrXutHan.setFont(new Font("Roboto", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
						.addComponent(lblHanChi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnchckdszndclrXutHan, GroupLayout.PREFERRED_SIZE, 95,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(lblHanChi, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnchckdszndclrXutHan, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		setLayout(groupLayout);
	}
	
	public void init(ModelHDBHCT model) {
		datas = daocthdbh.Find(new ModelHDBHCT(model.getMaHDBH()));
		fillTable();
	}
	
	public void fillTable() {
		table.tableModel.setRowCount(0);
		for (ModelHDBHCT data : datas) {
			long roundValue = Math.round(data.getTotalPrice());
			
			table.tableModel.addRow(new Object[] {
					data.getId(),data.getTenSP(),data.getTenKH(),data.getSize(),data.getColor(),data.getMaterial(),data.getQuantity(),roundValue
			});
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color2);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		g2.setColor(color1);
		g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 15, 15);
		super.paintComponent(g);
	}

	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
		repaint();
	}
}
