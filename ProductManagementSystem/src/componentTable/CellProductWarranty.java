package componentTable;

import javax.swing.JPanel;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

import animation.TextField;
import color.ColorBackground;
import componentCreateProduct.PanelTitle;
import model.ModelProduct;
import model.ModelProductWarranty;
import view.MainForm;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class CellProductWarranty extends TableCustomCell {
	private TextField txtWarranty;
	private PanelTitle panel;

	public CellProductWarranty() {

		panel = new PanelTitle();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(20, Short.MAX_VALUE)));

		txtWarranty = new TextField();
		txtWarranty.setFont(new Font("Roboto", Font.PLAIN, 11));
		txtWarranty.setHint("Bảo Hành");
		txtWarranty.setForeground(ColorBackground.colorLight);
		txtWarranty.setCaretColor(ColorBackground.colorLight);

		txtWarranty.setBorder(null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addContainerGap().addComponent(txtWarranty, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(txtWarranty,
				GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		txtWarranty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					panel.setColorBackground(ColorBackground.colorGRB000);
					panel.setColorClick(new Color(82, 147, 242));
				} else {
					panel.setColorBackground(ColorBackground.colorLight);
					panel.setColorClick(new Color(82, 147, 242));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					panel.setColorBackground(ColorBackground.colorGRB394348);
					panel.setColorClick(ColorBackground.colorGRB394348);
				} else {
					panel.setColorBackground(ColorBackground.colorGRB240242245);
					panel.setColorClick(ColorBackground.colorGRB239239239);
				}
			}
		});
		
		txtWarranty.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if (txtWarranty.getText().equals("")) {
					txtWarranty.setHint("Bảo Hành");
				}
			}
		});
	}

	@Override
	public TableCustomCell createComponentCellEditor(TableCustom arg0, TableRowData arg1, Object o, int arg3,
			int arg4) {
		CellProductWarranty cell = new CellProductWarranty();
		cell.setData(o);
		return cell;
	}

	@Override
	public Object getData() {
		String warranty = txtWarranty.getText();
		return new ModelProductWarranty(warranty);
	}

	@Override
	public void setData(Object o) {
		if (o != null) {
			ModelProductWarranty data = (ModelProductWarranty) o;
			txtWarranty.setHint("");
			txtWarranty.setText(data.getWarranty());
		}
	}
}
