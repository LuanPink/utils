package componentTable;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class CellAction extends TableCustomCell {

	private String role;

	JButton btnEdit;
	JButton btnDelete;

	public CellAction() {
		this.role = role;
		setOpaque(false);
		setLayout(null);

		btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon(CellAction.class.getResource("/icon/edit.png")));
		btnEdit.setBackground(getBackground());
		btnEdit.setBorder(null);
		btnEdit.setBounds(0, 0, 39, 39);
		add(btnEdit);

		btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(CellAction.class.getResource("/icon/delete.png")));
		btnDelete.setBorder(null);
		btnDelete.setBackground(getBackground());
		btnDelete.setBounds(40, 0, 39, 39);

//		btnDelete.setVisible(false);

		add(btnDelete);

	}

	public static int rowSelected = -1;

	public void addEvent(TableCustom table, TableRowData data, int row) {
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (data.isEditing()) {
					table.cancelEditRowAt(row);
					btnEdit.setIcon(new ImageIcon(CellAction.class.getResource("/icon/edit.png")));
					rowSelected = -1;

				} else {
					table.editRowAt(row);
					btnEdit.setIcon(new ImageIcon(CellAction.class.getResource("/icon/cancel.png")));
					rowSelected = row;
				}

			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public void checkIcon(TableRowData data) {
		if (data.isEditing()) {
			btnEdit.setIcon(new ImageIcon(CellAction.class.getResource("/icon/cancel.png")));
		} else {
			btnEdit.setIcon(new ImageIcon(CellAction.class.getResource("/icon/edit.png")));
		}
	}

	@Override
	public Component createComponentCellRenderOnEditor(TableCustom table, TableRowData data, int row, int column) {

		return null;
	}

	@Override
	public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
		CellAction cell = new CellAction();
		cell.checkIcon(data);
		cell.addEvent(table, data, row);
		return cell;
	}

	@Override
	public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int col) {
		CellAction cell = new CellAction();
		cell.checkIcon(data);
		cell.addEvent(table, data, row);

		return cell;
	}

	@Override
	public Object getData() {
		return null;
	}

	@Override
	public void setData(Object arg0) {
		// TODO Auto-generated method stub

	}
}
