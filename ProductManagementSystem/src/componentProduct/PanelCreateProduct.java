package componentProduct;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import color.ColorBackground;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCreateProduct.PanelWarranty;
import componentCreateProduct.PanelManufacturerProduct;
import componentCreateProduct.PanelSupplier;
import componentCreateProduct.PanelPriceProduct;
import componentCreateProduct.PanelTitleProduct;
import componentCreateProduct.PanelmageProduct;
import view.MainForm;
import view.PanelMode;

public class PanelCreateProduct extends JPanel {

	private PanelTitleProduct panelTitleProduct;
	private PanelmageProduct panelImageProduct;
	private PanelPriceProduct panelPrice;
	private PanelManufacturerProduct panelManufacturer;
	private PanelSupplier panelSupplier;
	private PanelWarranty panelWarranty;
	private JLabel lbNewProduct;

	public PanelCreateProduct() {
		setOpaque(false);

		lbNewProduct = new JLabel("Sản Phẩm Mới");
		lbNewProduct.setForeground(new Color(252, 252, 252));
		lbNewProduct.setFont(new Font("Roboto", Font.BOLD, 30));

		panelTitleProduct = new PanelTitleProduct();

		panelImageProduct = new PanelmageProduct();

		panelPrice = new PanelPriceProduct();

		panelManufacturer = new PanelManufacturerProduct();

		panelSupplier = new PanelSupplier();

		panelWarranty = new PanelWarranty();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelTitleProduct, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lbNewProduct, GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE).addContainerGap())
				.addComponent(panelImageProduct, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
				.addComponent(panelManufacturer, GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
				.addComponent(panelPrice, GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
				.addComponent(panelSupplier, GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
				.addComponent(panelWarranty, GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lbNewProduct, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelTitleProduct, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelImageProduct, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelPrice, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelManufacturer, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelSupplier, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelWarranty, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(49, Short.MAX_VALUE)));
		setLayout(groupLayout);
		if(MainForm.mode == "Dark") {
			lbNewProduct.setForeground(ColorBackground.colorLight);
		}else {
			lbNewProduct.setForeground(ColorBackground.colorDark);
		}
		action();
	}

	public void action() {
		PanelMode.actionButonModeDark(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lbNewProduct.setForeground(ColorBackground.colorLight);
			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lbNewProduct.setForeground(ColorBackground.colorDark);
			}
		});
	}

}
