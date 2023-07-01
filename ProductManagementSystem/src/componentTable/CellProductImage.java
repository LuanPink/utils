package componentTable;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

import color.ColorBackground;
import componentCreateProduct.PanelTitle;
import model.ModelProductImage;
import view.MainForm;

import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CellProductImage extends TableCustomCell {
	private JTextArea txtDescriber;
	private PanelTitle panel;
	private JLabel lblImage;

	public CellProductImage() {

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

		txtDescriber.setBorder(null);

		JLabel lblNewLabel_1 = new JLabel("Chọn ảnh");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 11));
		lblNewLabel_1.setIcon(new ImageIcon(CellProductImage.class.getResource("/icon/down-white.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(ColorBackground.colorLight);

		lblImage = new JLabel("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
								.addComponent(lblImage, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtDescriber, GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDescriber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblImage, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE).addContainerGap()));
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
		CellProductImage cell = new CellProductImage();
		cell.setData(o);
		return cell;
	}

	@Override
	public Object getData() {
		return null;
	}

	@Override
	public void setData(Object o) {
		if (o != null) {
			ModelProductImage data = (ModelProductImage) o;
			ImageIcon icon = new ImageIcon(
					new ImageIcon(CellProductImage.class.getResource("/icon/" + data.getProductImage())).getImage()
							.getScaledInstance(120, 120, Image.SCALE_SMOOTH));
			lblImage.setIcon(icon);
		}
	}
}
