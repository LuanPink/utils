package componentEmployee;

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
import view.MainForm;
import view.PanelMode;

public class TableEmployee extends JTable {

	DefaultTableModel tableModel;
	
	public TableEmployee() {
		setOpaque(false);
		setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Mã Nhân Viên","Tên Nhân Viên","Chức Vụ","Giới Tính","Ngày Sinh","Địa Chỉ","Số Điện Thoại","Email","Lương"
		}));
		tableModel = (DefaultTableModel) getModel();
		setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		
		if(MainForm.mode == "Dark") {
			setColorModeDark();
		}else {
			setColorModeLight();
		}
		
		
		
		action();
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
		setBackground(ColorBackground.colorLight);
		setForeground(new Color(147,147,147));
		setSelectionBackground(ColorBackground.colorGRB239239239);
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
	
}
