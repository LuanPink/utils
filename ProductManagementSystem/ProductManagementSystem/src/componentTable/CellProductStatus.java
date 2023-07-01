package componentTable;

import javax.swing.JPanel;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

import animation.ComboboxCustom;
import animation.TextField;
import color.ColorBackground;
import componentCreateProduct.PanelTitle;
import model.ModelProduct;
import model.ModelProductSize;
import model.ModelProductStatus;
import view.MainForm;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class CellProductStatus extends TableCustomCell {
	private ComboboxCustom combobox;
	private Color colorBackground1 = ColorBackground.colorLight;
	private Color color = ColorBackground.colorGRB000;
	private DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel<>();
	boolean status;
	public CellProductStatus() {
		 combobox = new ComboboxCustom();
			combobox.setRenderer(new BasicComboBoxRenderer() {
				@Override
				public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
						boolean cellHasFocus) {
					super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					setFont(new Font("Roboto", Font.PLAIN, 12));
					if (isSelected) {
						setBackground(colorBackground1);
						setForeground(color);
					} else {
						setBackground(color);
						setForeground(colorBackground1);
					}
					return this;
				}
			});

			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
					groupLayout.createSequentialGroup().addContainerGap()
							.addComponent(combobox, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE).addContainerGap()));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
							.addComponent(combobox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(20, Short.MAX_VALUE)));
			GroupLayout gl_panel = new GroupLayout(combobox);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGap(0, 430, Short.MAX_VALUE)
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGap(0, 30, Short.MAX_VALUE)
			);
			combobox.setLayout(gl_panel);
			setLayout(groupLayout);
			init();
	}
	
	public void init() {
		comboBoxModel.addElement("");
		comboBoxModel.addElement("Đang kinh doanh");
		comboBoxModel.addElement("Ngừng kinh doanh");
		
		combobox.setModel(comboBoxModel);
	}

	@Override
	public TableCustomCell createComponentCellEditor(TableCustom arg0, TableRowData arg1, Object o, int arg3,
			int arg4) {
		CellProductStatus cell = new CellProductStatus();
		cell.setData(o);
		return cell;
	}

	@Override
	public Object getData() {
		int index = combobox.getSelectedIndex();
		if(index==1) {
			status = true;
		}else if(index == 2) {
			status = false;
		}
		
		return new ModelProductStatus(status);
	}

	@Override
	public void setData(Object o) {
		ModelProductStatus data = (ModelProductStatus)o;
		String status = "";
		if(data.isStatus()) {
			comboBoxModel.setSelectedItem("Đang kinh doanh");
		}else {
			comboBoxModel.setSelectedItem("Ngừng kinh doanh");
		}
		
		
	}
}
