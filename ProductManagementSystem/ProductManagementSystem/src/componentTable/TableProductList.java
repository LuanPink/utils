package componentTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import com.raven.table.TableCustom;
import color.ColorBackground;
import componentScrollPane.ScrollBarMenu;
import view.PanelMode;


public class TableProductList extends TableCustom {

	public static DefaultTableModel tableModel;

	public TableProductList() {
		setOpaque(false);
		setModel(new DefaultTableModel(new Object[][] {}, new String[] {"ID", "Tên Sản Phẩm","Giá Bán","Số Lượng","Bảo Hành","Thuế","Hình","Mô Tả","Trạng Thái","Nhà Cung Cấp","Loại Sản Phẩm","Size","Màu Sắc","Chất Liệu","Edit"}));
		tableModel = (DefaultTableModel) getModel();
		
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		getColumnModel().getColumn(0).setPreferredWidth(200);
		getColumnModel().getColumn(1).setPreferredWidth(300);
		getColumnModel().getColumn(2).setPreferredWidth(200);
		getColumnModel().getColumn(3).setPreferredWidth(200);
		getColumnModel().getColumn(4).setPreferredWidth(200);
		getColumnModel().getColumn(5).setPreferredWidth(200);
		getColumnModel().getColumn(6).setPreferredWidth(300);
		getColumnModel().getColumn(7).setPreferredWidth(300);
		getColumnModel().getColumn(8).setPreferredWidth(200);
		getColumnModel().getColumn(9).setPreferredWidth(300);
		getColumnModel().getColumn(10).setPreferredWidth(200);
		getColumnModel().getColumn(11).setPreferredWidth(200);
		getColumnModel().getColumn(12).setPreferredWidth(200);
		getColumnModel().getColumn(13).setPreferredWidth(200);
		getColumnModel().getColumn(14).setPreferredWidth(100);
		
		doLayout(); // optional
		
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
				setColorModeDark(); 
			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeLight();	
			}
		});
	}
	
	
	public void setColorModeDark() {
		setForeground(new Color(214, 214, 214));
		setBackground(ColorBackground.colorDark);
		setSelectionBackground(ColorBackground.colorGRB000);   
	}
	
	public void setColorModeLight() {
		setForeground(new Color(147,147,147));
		setBackground(ColorBackground.colorLight);
		setSelectionBackground(ColorBackground.colorGRB239239239);	
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component com = super.prepareRenderer(renderer, row, column);
		
		if(isCellSelected(row, column)) {
			PanelMode.actionButonModeDark(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					com.setBackground(ColorBackground.colorGRB000);
				}
			});

			PanelMode.actionButonModeLight(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					com.setBackground(ColorBackground.colorGRB239239239);
				}
			});	
		}
		return com;
	}
}
