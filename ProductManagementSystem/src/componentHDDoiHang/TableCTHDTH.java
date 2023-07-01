package componentHDDoiHang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import color.ColorBackground;
import componentScrollPane.ScrollBarMenu;
import componentTable.TableHeaderCustom;
import view.PanelMode;

public class TableCTHDTH extends JTable{

	public DefaultTableModel tableModel;
	public TableCTHDTH() {
		setOpaque(false);
		setModel(new DefaultTableModel(new Object[][] {}, new String[] {"ID","Mã Sản Phẩm,","Size","Màu Sắc","Chất Liệu","Số Lượng","Tổng Tiền"})); 
		tableModel = (DefaultTableModel) getModel();
		getColumnModel().getColumn(0).setPreferredWidth(50); 
		getColumnModel().getColumn(1).setPreferredWidth(250);
		getColumnModel().getColumn(2).setPreferredWidth(200);
		getColumnModel().getColumn(3).setPreferredWidth(100);
		getColumnModel().getColumn(4).setPreferredWidth(100);
		getColumnModel().getColumn(5).setPreferredWidth(120);
		getColumnModel().getColumn(6).setPreferredWidth(100);
		action();
	}
	
	public void addTableStyle(JScrollPane scroll) {
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        setBorder(null);
        scroll.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      	scroll.setVerticalScrollBar(new ScrollBarMenu());
        JPanel panel = new JPanel();
        panel.setBackground(ColorBackground.colorDark);
      
        setSelectionForeground(new Color(214, 214, 214));
        
        getTableHeader().setDefaultRenderer(new TableHeaderCustom());
        setRowHeight(45);
		setIntercellSpacing(new Dimension(0, 0));
		setForeground(new Color(214, 214, 214));
		setBackground(ColorBackground.colorDark);
		setFocusable(false);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        setSelectionBackground(ColorBackground.colorGRB000);
	}
	
	
	public void action() {
		PanelMode.actionButonModeDark(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setForeground(ColorBackground.colorLight);
				setBackground(ColorBackground.colorDark);
				setSelectionBackground(ColorBackground.colorGRB000);        
			}
		});
		PanelMode.actionButonModeLight(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setForeground(ColorBackground.colorDark);
				setBackground(ColorBackground.colorLight);
				setSelectionBackground(ColorBackground.colorGRB240242245);        
			}
		});
}

	}