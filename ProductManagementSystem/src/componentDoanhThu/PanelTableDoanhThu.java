package componentDoanhThu;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import color.ColorBackground;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCreateProduct.PanelTitle;
import componentDialog.DialogQuestion;
import componentScrollPane.ScrollBarMenu;
import componentStore.DialogFilterStoreProduct;
import componentStore.PanelStoreHeader;
import componentsCurve.CurveLineChart;
import componentsCurve.ModelChart;
import dao.DAODoanhThu;
import dao.DAOHDBH;
import dao.DAOHDBHCT;
import dao.DAOHDDH;
import dao.DAOHDDHCT;
import dao.DAOHDTH;
import dia.DiaLogShowPanel;
import dia.DialogShowOption;
import dia.PanelOptionConfirm;
import model.ModelHDBHCT;
import model.ModelHDDH;
import model.ModelHDDHCT;
import model.ModelDoanhThu;
import model.ModelHDBH;
import model.ModelHDTH;
import model.ModelHDTHCT;
import model.ModelProduct;
import net.miginfocom.swing.MigLayout;
import view.MainForm;
import view.PanelMode;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import animation.TextField;
import javax.swing.JButton;

public class PanelTableDoanhThu extends JPanel {
	private Color color = ColorBackground.colorDark;
	private Color color2 = new Color(207, 106, 119);
	private JScrollPane scrollPane;
	private TableDoanhThu table;
	private Icon iconFilterWhite = new ImageIcon(PanelTableDoanhThu.class.getResource("/icon/filter-white.png"));
	private Icon iconFilterGray = new ImageIcon(PanelTableDoanhThu.class.getResource("/icon/filter-gray.png"));
	private JLabel lblNewLabel;
	private static int indexSeleted = -1;
	private DAODoanhThu daoDoanhThu = new DAODoanhThu();
	private ArrayList<ModelDoanhThu> datas = new ArrayList<ModelDoanhThu>();
	DiaLogShowChart showChart = new DiaLogShowChart(null);
	DiaLogShowPanel showPanel = new DiaLogShowPanel(null);
	PanelChartDoanhThu chartDoanhThu = new PanelChartDoanhThu();
	private CurveLineChart chart;
	private int x = 650;
	private int y = 290;
	private ButtonCheckedSizeAndColor btnFilter;
	private int year;

	public PanelTableDoanhThu() {
		setOpaque(false);
		table = new TableDoanhThu();
		scrollPane = new JScrollPane(table);
		table.addTableStyle(scrollPane);
		lblNewLabel = new JLabel("Doanh Thu");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel.setForeground(ColorBackground.colorLight);

		JScrollPane scrollPane = new JScrollPane(table);
		table.addTableStyle(scrollPane);

		btnFilter = new ButtonCheckedSizeAndColor(0);
		btnFilter.setIcon(new ImageIcon(PanelTableDoanhThu.class.getResource("/icon/filter-gray.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 873, Short.MAX_VALUE)
							.addComponent(btnFilter, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFilter, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		if (MainForm.mode == "Light") {
			setColorModeLight();
		} else {
			setColorModeDark();
		}
		
		init();
		action();

	}

	public void init() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		 year = Integer.parseInt(sdf.format(new Date()));
		datas = daoDoanhThu.Find(year);
		fillTable();
	}

	public void fillTable() {
		table.tableModel.setRowCount(0);
		for (ModelDoanhThu data : datas) {			
			table.tableModel.addRow(new Object[] {
					data.getMonth(),data.getSpBan(),data.getTotalPrice(),data.getTotalNhapHang(),data.getLoiNhuan()
			});
		}
	}

	private void setColorModeDark() {

	}

	private void setColorModeLight() {

	}

	public void action() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
						
				}
			}
		});
		
		btnFilter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// show 
				showChart.setYear(year);
				MainForm.setLocationDialog(x, y);
				MainForm.setLocationMouseDragged(x, y);
				showChart.setLocation(MainForm.xScreen, MainForm.yScreen);
				showChart.setModalityType(ModalityType.APPLICATION_MODAL);
				showChart.setVisible(true);

			}
		});
		
		PanelFilterDoanhThu.btnApply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showChart.setVisible(false);
				chart = new CurveLineChart();
				showPanel.showForm(chartDoanhThu);
				chartDoanhThu.showPanel(chart);
				
				
				
				chart.setForeground(new Color(191, 191, 191));
				chart.setFillColor(true);
				chart.setBorder(null);
				chart.setBackground(new Color(26, 29, 31));
				
				initChart();
				
				MainForm.setLocationDialog(400, 80);
				MainForm.setLocationMouseDragged(400, 80);
				showPanel.setLocation(MainForm.xScreen, MainForm.yScreen);
				showPanel.setModalityType(ModalityType.APPLICATION_MODAL);
				showPanel.setVisible(true);
			}
		});
		
		PanelChartDoanhThu.btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showPanel.setVisible(false);
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
	
	public void initChart() {
		chart.setTitle("Doanh Thu");
		chart.addLegend("Tổng Giá Bán", Color.decode("#93291E"), Color.decode("#780206"));
		chart.addLegend("Tổng Nhập Hàng", Color.decode("#e65c00"), Color.decode("#F9D423"));
		chart.addLegend("Lợi Nhuận", Color.decode("#0099F7"), Color.decode("#4286f4"));
		setData();
	}
	
	public void setData() {
		for (ModelDoanhThu data : datas) {
			chart.addData(new ModelChart("Tháng "+data.getMonth(), new double[] {Double.parseDouble(data.getTotalPrice()+""),Double.parseDouble(data.getTotalNhapHang()+""),Double.parseDouble(data.getLoiNhuan()+"")}));
		}
		chart.start();
	}

	public void setColorButtonModeDark(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorDark);
		button.setColorhover1(ColorBackground.colorGRB394348);
	}

	public void setColorButtonModeLight(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorLight);
		button.setColorhover1(ColorBackground.colorGRB181228202);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintComponent(g);
	}
}
