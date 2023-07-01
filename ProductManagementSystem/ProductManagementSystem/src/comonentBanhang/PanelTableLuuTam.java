package comonentBanhang;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import componentHeader.ButtonShowAllNotification;
import color.ColorBackground;
import componentStore.DialogFilterStoreProduct;
import model.ModelProduct;
import view.MainForm;
import view.PanelMode;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JSeparator;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentDialog.DialogQuestion;

public class PanelTableLuuTam extends JPanel {
	private JScrollPane scrollPane;
	private static TableLuuTam table;
	private JLabel lblNewLabel;
	Color color1 = ColorBackground.colorDark;
	Color color2 = new Color(207, 106, 119);
	public ButtonCheckedSizeAndColor btnCancel;
	public ButtonCheckedSizeAndColor btnRemove;
	public static List<ModelProduct> list = new ArrayList<ModelProduct>();
	private int indexSelected = -1;
	private DialogQuestion question = new DialogQuestion(null);

	public PanelTableLuuTam() {
		setOpaque(false);
		table = new TableLuuTam();
		scrollPane = new JScrollPane(table);
		table.addTableStyle(scrollPane);
		lblNewLabel = new JLabel("Sản Phẩm Lưu Tạm");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setForeground(ColorBackground.colorLight);
		JSeparator separator = new JSeparator();

		btnCancel = new ButtonCheckedSizeAndColor(0);
		btnCancel.setText("Hủy");
		btnCancel.setForeground(new Color(252, 252, 252));
		btnCancel.setFont(new Font("Roboto", Font.PLAIN, 14));

		btnRemove = new ButtonCheckedSizeAndColor(0);
		btnRemove.setText("Xóa");
		btnRemove.setForeground(new Color(252, 252, 252));
		btnRemove.setFont(new Font("Roboto", Font.PLAIN, 14));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(151))
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(697, Short.MAX_VALUE)
					.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(75)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(595))
		);
		setLayout(groupLayout);
		if (MainForm.mode == "Light") {
			setColorModeLight();
		} else {
			setColorModeDark();
		}
		btnRemove.setEnabled(false);
		action();
	}

	public void init(ModelProduct data) {
		list.add(data);
		list = list.stream().filter(distinctByKey(ModelProduct::getId)).collect(Collectors.toList());
		fillTable();
	}
	
	public List getList() {
		return list;
	}

	public static void fillTable() {
		table.tableModel.setRowCount(0);
		for (ModelProduct datas : list) {
			long roundValue = Math.round(datas.getProductPrice().getPrice());
			table.tableModel.addRow(new Object[] { datas.getId().getId(), datas.getProductName().getProductName(),
					datas.getProductType().getNameType(), datas.getProductSize().getNameSize(),
					datas.getProductColor().getNameColor(), datas.getProductMaterial().getNameMeterial(),
					roundValue, datas.getProductQuantity().getQuantity() });
		}

	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	private void setColorModeDark() {
		// TODO Auto-generated method stub
		lblNewLabel.setForeground(ColorBackground.colorLight);

	}

	private void setColorModeLight() {
		// TODO Auto-generated method stub
		lblNewLabel.setForeground(ColorBackground.colorDark);

	}

	public void action() {	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
					indexSelected = table.getSelectedRow();
					btnRemove.setEnabled(true);
				}
			}
		});

		btnRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (indexSelected < 0) {
					return;
				}
				btnRemove.setEnabled(true);
				list.remove(indexSelected);
				fillTable();
				question.lblTextMessage.setText("Đã Xóa");
				int x = 650;
				int y = 290;
				MainForm.setLocationDialog(x, y);
				MainForm.setLocationMouseDragged(x, y);
				question.setLocation(MainForm.xScreen, MainForm.yScreen);
				question.setAlwaysOnTop(true);
				question.setVisible(true);
				btnRemove.setEnabled(false);
				indexSelected = -1;
			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeLight();

			}
		});

		PanelMode.actionButonModeDark(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeDark();
			}
		});
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
