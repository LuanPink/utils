package componentTable;

import javax.swing.JPanel;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

import animation.ComboboxCustom;
import animation.TextField;
import color.ColorBackground;
import componentCreateProduct.Combobox;
import componentCreateProduct.PanelTitle;
import dao.DAOProductSize;
import dao.DAOSupplier;
import model.ModelProduct;
import model.ModelProductSize;
import model.ModelSupplier;
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
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class CellProductSize extends TableCustomCell {
	private ComboboxCustom combobox;
	private Color colorBackground1 = ColorBackground.colorLight;
	private Color color = ColorBackground.colorGRB000;
	private DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel<>();
	private DAOProductSize dao = new DAOProductSize();
	private ArrayList<ModelProductSize> datas = new ArrayList<ModelProductSize>();
	
	public CellProductSize() {

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
		datas = dao.SelectAll();
		initCombobox();
	}
	
	public void initCombobox() {
		comboBoxModel.addElement("");
		for (ModelProductSize data : datas) {
			comboBoxModel.addElement(data.getNameSize());
		}
		combobox.setModel(comboBoxModel);
	}

	@Override
	public TableCustomCell createComponentCellEditor(TableCustom arg0, TableRowData arg1, Object o, int arg3,
			int arg4) {
		CellProductSize cell = new CellProductSize();
		cell.setData(o);
		return cell;
	}

	@Override
	public Object getData() {
		String name = comboBoxModel.getSelectedItem().toString();	
		return new ModelProductSize(name);
	}

	@Override
	public void setData(Object o) {
		if (o != null) {
			ModelProductSize data = (ModelProductSize) o;
			comboBoxModel.setSelectedItem(data.getNameSize());
		}
	}
}
