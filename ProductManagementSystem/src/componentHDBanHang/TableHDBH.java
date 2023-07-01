package componentHDBanHang;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import color.ColorBackground;
import componentScrollPane.ScrollBarMenu;
import componentTable.TableHeaderCustom;
import view.PanelMode;
public class TableHDBH extends JTable {
		public DefaultTableModel tableModel;

		public TableHDBH() {
			setOpaque(false);
			setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Mã Hóa Đơn","Tên Khách Hàng","Số Điện Thoại","Nhân Viên","Tổng Tiền","Ngày Bán"})); 	
			tableModel = (DefaultTableModel) getModel();
			setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			getColumnModel().getColumn(0).setPreferredWidth(200); 
			getColumnModel().getColumn(1).setPreferredWidth(300);
			getColumnModel().getColumn(2).setPreferredWidth(200);
			getColumnModel().getColumn(3).setPreferredWidth(200);
			getColumnModel().getColumn(4).setPreferredWidth(200);
			getColumnModel().getColumn(5).setPreferredWidth(200);
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
