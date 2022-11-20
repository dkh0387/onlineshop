package de.dkh.onlineshop.view.managedbeans;

import java.io.Serializable;
import java.util.Map;

import javax.faces.event.ActionEvent;

import org.eclnt.editor.annotations.CCGenClass;
import org.eclnt.jsfserver.defaultscreens.Statusbar;
import org.eclnt.jsfserver.pagebean.PageBean;

import de.dkh.core.Constants;
import de.dkh.db.bo.Product;
import de.dkh.db.bo.ProductSelection;
import lombok.Getter;
import lombok.Setter;

@CCGenClass(expressionBase = "#{d.ProdquantityUI}")

public class ProdquantityUI extends PageBean implements Serializable {
	private static final long serialVersionUID = -8586697818409524277L;
	@Getter
	private String pageName = "/prodquantity.xml";
	@Getter
	private String rootExpressionUsedInPage = "#{d.ProdquantityUI}";
	@Getter
	private String lblBtnOK = Constants.BTN_OK;
	private ProdcatalogUI prodcatalogUI;
	@Getter
	@Setter
	private int quantity;
	private IListener listener;
	// ------------------------------------------------------------------------
	// inner classes
	// ------------------------------------------------------------------------

	/* Listener to the user of the page bean. */
	public interface IListener extends Serializable {
	}

	// ------------------------------------------------------------------------
	// constructors & initialization
	// ------------------------------------------------------------------------

	public ProdquantityUI() {
	}

	public ProdquantityUI(ProdcatalogUI prodcatalogUI) {
		this.prodcatalogUI = prodcatalogUI;
		prepare(null);
	}

	// ------------------------------------------------------------------------
	// public usage
	// ------------------------------------------------------------------------
	public void onOK(ActionEvent event) {
		Product selectedProduct = getSelectedProduct();

		if (selectedProduct != null && prodcatalogUI.getService().checkAvailable(selectedProduct, quantity)) {
			updateProdCatalog(selectedProduct);
			prodcatalogUI.closePopup(this);
		} else {
			Statusbar.outputError(String.format(Constants.PROD_QUANTITY_SELECTION_ERROR, quantity,
					prodcatalogUI.getService().getQuantityFor(selectedProduct)));
		}
	}

	/*
	 * Initialization of the bean. Add any parameter that is required within your
	 * scenario.
	 */
	public void prepare(IListener listener) {
		this.listener = listener;
	}

	// ------------------------------------------------------------------------
	// private usage
	// ------------------------------------------------------------------------

	private void updateProdCatalog(Product selectedProduct) {
		double totalAmount = prodcatalogUI.getService().calcTotal(selectedProduct, quantity);
		updateProductSelectionFor(selectedProduct, totalAmount);
		prodcatalogUI.setQuantity(quantity);
		prodcatalogUI.setTotalAmount(totalAmount);
		prodcatalogUI.getService().updateQuantity(selectedProduct, quantity);
		prodcatalogUI.update();
	}

	private void updateProductSelectionFor(Product selectedProduct, double totalAmount) {
		Map<Product, ProductSelection> prodSelectionMap = prodcatalogUI.getSelectedUser().getProdSelectionMap();

		if (prodSelectionMap.containsKey(selectedProduct)) {
			prodSelectionMap.replace(selectedProduct, getProdSelectionFor(selectedProduct, totalAmount));
		} else {
			prodSelectionMap.put(selectedProduct,
					ProductSelection.builder().image(selectedProduct.getProductType().getImageSource())
							.quantity(quantity).totalAmount(totalAmount).build());
		}
	}

	private Product getSelectedProduct() {
		return prodcatalogUI.getSelectedProduct();
	}

	private ProductSelection getProdSelectionFor(Product selectedProduct, double totalAmount) {
		boolean containsKey = prodcatalogUI.getSelectedUser().getProdSelectionMap().containsKey(selectedProduct);
		int oldQuantity = containsKey
				? prodcatalogUI.getSelectedUser().getProdSelectionMap().get(selectedProduct).getQuantity()
				: 0;
		return quantity > 0
				? new ProductSelection(selectedProduct.getProductType().getImageSource(), oldQuantity + quantity,
						totalAmount)
				: null;
	}
}
