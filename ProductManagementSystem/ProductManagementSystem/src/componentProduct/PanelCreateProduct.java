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
import componentDialog.DialogQuestion;
import dao.DAOProducts;
import model.ModelProduct;
import model.ModelProductColor;
import model.ModelProductDescriber;
import model.ModelProductId;
import model.ModelProductImage;
import model.ModelProductMaterial;
import model.ModelProductName;
import model.ModelProductPrice;
import model.ModelProductQuantity;
import model.ModelProductSize;
import model.ModelProductStatus;
import model.ModelProductType;
import model.ModelProductVAT;
import model.ModelProductWarranty;
import model.ModelSupplier;
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

	private DAOProducts daoProducts=new DAOProducts();
	
	private DialogQuestion question = new DialogQuestion(null);
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
		LuuSanPham();
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
	public void LuuSanPham() {
		panelWarranty.btnAddProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				
//				System.out.println(+"sas");
//				System.out.println();
//				System.out.println();
//				System.out.println();
//				System.out.println();
//				System.out.println();
//				System.out.println();	
//				System.out.println();
//				System.out.println();
//				System.out.println();
//				System.out.println();
//				System.out.println();
//				System.out.println();
//				System.out.println();
//				panelTitleProduct.CheckNameProduct();
//				panelPrice.Prices();
//				panelPrice.Quantitys();
//				panelWarranty.CheckBaohanh();
//				panelWarranty.checkthue();
//				panelTitleProduct.CheckDecribe();
//				panelManufacturer.checkSize();
//				panelPrice.ProductType();
//				panelSupplier.Checknhachungcap();
//				panelImageProduct.PathImg();
//				panelManufacturer.checkCol();
//				panelManufacturer.Checkchatlieu();
//				panelWarranty.CheckDecribe();
//				panelManufacturer.Checkhangsanxuat();
				if(check()!=null) {
					if(daoProducts.insert(check())>0) {
						question.lblTextMessage.setText("Thêm Nhân Viên Thành Công");
						int x = 650;
						int y = 290;
						MainForm.setLocationDialog(x, y);
						MainForm.setLocationMouseDragged(x, y);
						question.setLocation(MainForm.xScreen, MainForm.yScreen);
						question.setAlwaysOnTop(true);
						question.setVisible(true);
					}else {
						question.lblTextMessage.setText("Thêm Nhân Viên Thất Bại");
						int x = 650;
						int y = 290;
						MainForm.setLocationDialog(x, y);
						MainForm.setLocationMouseDragged(x, y);
						question.setLocation(MainForm.xScreen, MainForm.yScreen);
						question.setAlwaysOnTop(true);
						question.setVisible(true);
					}
				}
			}
		});
	}
	public ModelProduct check() {
		if(panelTitleProduct.CheckNameProduct()!=null) {//
			System.out.println(panelTitleProduct.CheckNameProduct());
			if(panelPrice.Prices()>0.0) {//
				System.out.println(panelPrice.Prices());
				if(panelPrice.Quantitys()>0) {//
					System.out.println(panelPrice.Quantitys());
					if(panelWarranty.CheckBaohanh()!=null) {//
						System.out.println(panelWarranty.CheckBaohanh());
						if(panelWarranty.checkthue()!=0) {//
							System.out.println(panelWarranty.checkthue());
							if(panelTitleProduct.CheckDecribe()!=null) {//
								System.out.println(panelTitleProduct.CheckDecribe());
								if(panelImageProduct.PathImg()!=null) {//
									System.out.println(panelImageProduct.PathImg());
									if(panelSupplier.Checknhachungcap()!=null) {
										System.out.println(panelSupplier.Checknhachungcap()+"ncc");
										if(panelPrice.ProductType()!=null) {
											System.out.println(panelPrice.ProductType());
											if(panelManufacturer.checkSize()>0) {
												System.out.println(panelManufacturer.checkSize());
												if(panelManufacturer.checkCol()>0) {
													System.out.println(panelManufacturer.checkCol());
													if(panelManufacturer.Checkchatlieu()!=null) {
														System.out.println(panelManufacturer.Checkchatlieu());
														ModelProductName modelProductName=new ModelProductName(panelTitleProduct.CheckNameProduct());
														ModelProductId modelProductId=new ModelProductId(daoProducts.SelectAll().size()+1+"");
														ModelProductPrice modelProductPrice=new ModelProductPrice(panelPrice.Prices());
														ModelProductQuantity modelProductQuantity=new ModelProductQuantity(panelPrice.Quantitys());
														ModelProductWarranty modelProductWarranty=new ModelProductWarranty(panelWarranty.CheckBaohanh());
														ModelProductVAT modelProductVAT=new ModelProductVAT(panelWarranty.checkthue()+"");
														ModelProductDescriber modelProductDescriber=new ModelProductDescriber(panelTitleProduct.CheckDecribe());
														ModelProductImage modelProductImage=new ModelProductImage(panelImageProduct.PathImg());
														ModelProductStatus modelProductStatus=new ModelProductStatus("1");
														ModelSupplier modelSupplier=new ModelSupplier(panelSupplier.Checknhachungcap());
														ModelProductType modelProductType=new ModelProductType(panelPrice.ProductType());
														ModelProductSize modelProductSize=new ModelProductSize(panelManufacturer.checkSize()+"");
														ModelProductColor modProductColor=new ModelProductColor(panelManufacturer.checkCol()+"");
														ModelProductMaterial modelProductMateria=new ModelProductMaterial(panelManufacturer.Checkchatlieu());
														ModelProduct modelProduct=new ModelProduct(modelProductId,modelProductName,modelProductPrice, modelProductQuantity, modelProductWarranty, modelProductVAT, modelProductDescriber,modelProductImage, modelProductStatus, modelSupplier, modelProductType, modelProductSize, modProductColor, modelProductMateria);
														return modelProduct;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
}
