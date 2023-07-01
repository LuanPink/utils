package componentTable;

import javax.swing.JTextArea;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

import color.ColorBackground;
import componentCreateProduct.PanelTitle;
import model.ModelProductDescriber;
import view.MainForm;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class CellProductDescriber extends TableCustomCell {
	private JTextArea txtDescriber;
	private PanelTitle panel;

	public CellProductDescriber() {

		panel = new PanelTitle();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE).addContainerGap()));

		txtDescriber = new JTextArea();
		txtDescriber.setFont(new Font("Roboto", Font.PLAIN, 11));
		txtDescriber.setForeground(ColorBackground.colorLight);
		txtDescriber.setCaretColor(ColorBackground.colorLight);
		txtDescriber.setOpaque(false);
		txtDescriber.setWrapStyleWord(true);
		txtDescriber.setLineWrap(true);
		txtDescriber.setBorder(null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addContainerGap().addComponent(txtDescriber, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(txtDescriber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		txtDescriber.addMouseListener(new MouseAdapter() {
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
	}

	@Override
	public TableCustomCell createComponentCellEditor(TableCustom arg0, TableRowData arg1, Object o, int arg3,
			int arg4) {
		CellProductDescriber cell = new CellProductDescriber();
		cell.setData(o);
		return cell;
	}

	@Override
	public Object getData() {
		return new ModelProductDescriber(txtDescriber.getText());
	}

	@Override
	public void setData(Object o) {
		if (o != null) {
			ModelProductDescriber data = (ModelProductDescriber) o;
			txtDescriber.setText(data.getDescriber());
		}
	}
}
