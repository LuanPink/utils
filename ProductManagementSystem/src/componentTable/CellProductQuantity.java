package componentTable;

import javax.swing.JPanel;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

import animation.TextField;
import color.ColorBackground;
import componentCreateProduct.PanelTitle;
import model.ModelProduct;
import model.ModelProductQuantity;
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

public class CellProductQuantity extends TableCustomCell {
	private TextField txtQuantity;
	private PanelTitle panel;

	public CellProductQuantity() {

		panel = new PanelTitle();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(20, Short.MAX_VALUE)));

		txtQuantity = new TextField();
		txtQuantity.setFont(new Font("Roboto", Font.PLAIN, 11));
		txtQuantity.setHint("Số Lượng");
		txtQuantity.setForeground(ColorBackground.colorLight);
		txtQuantity.setCaretColor(ColorBackground.colorLight);

		txtQuantity.setBorder(null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addContainerGap().addComponent(txtQuantity, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(txtQuantity,
				GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		txtQuantity.addMouseListener(new MouseAdapter() {
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
		
		txtQuantity.addCaretListener(new CaretListener() {	
			@Override
			public void caretUpdate(CaretEvent e) {
				if(txtQuantity.getText().equals("")) {
					txtQuantity.setHint("Số Lượng");
				}
			}
		});
	}

	@Override
	public TableCustomCell createComponentCellEditor(TableCustom arg0, TableRowData arg1, Object o, int arg3,
			int arg4) {
		CellProductQuantity cell = new CellProductQuantity();
		cell.setData(o);
		return cell;
	}

	@Override
	public Object getData() {
		String quantity = txtQuantity.getText();
		return new ModelProductQuantity(Integer.parseInt(quantity));
	}

	@Override
	public void setData(Object o) {
		if (o != null) {
			ModelProductQuantity data = (ModelProductQuantity) o;
			txtQuantity.setHint("");
			txtQuantity.setText(data.getQuantity() + "");
		}
	}
}
