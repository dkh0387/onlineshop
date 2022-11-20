package de.dkh.onlineshop.view.managedbeans;

import java.io.Serializable;
import java.util.Comparator;

import javax.faces.event.ActionEvent;

import org.eclnt.editor.annotations.CCGenClass;
import org.eclnt.jsfserver.defaultscreens.ModalPopup;
import org.eclnt.jsfserver.defaultscreens.Statusbar;
import org.eclnt.jsfserver.elements.impl.FIXGRIDItem;
import org.eclnt.jsfserver.elements.impl.FIXGRIDListBinding;
import org.eclnt.jsfserver.elements.util.DefaultModalPopupListener;
import org.eclnt.jsfserver.pagebean.PageBean;

import de.dkh.core.Constants;
import de.dkh.db.bo.Product;
import de.dkh.db.bo.ProductSelection;
import de.dkh.db.bo.User;
import de.dkh.service.ProductService;
import lombok.Getter;
import lombok.Setter;

@CCGenClass(expressionBase = "#{d.ProdcatalogUI}")
public class ProdcatalogUI extends PageBean implements Serializable {
	private static final long serialVersionUID = 1151046345599081271L;
	@Getter
	private String pageName = "/prodcatalog.xml";
	@Getter
	private String rootExpressionUsedInPage = "#{d.ProdcatalogUI}";
	@Getter
	private String pageTitle = Constants.PROD_CATALOG_PAGE_TITLE;
	@Getter
	private String colImage = Constants.PRODUCT_IMAGE;
	@Getter
	private String colDescription = Constants.PRODUCT_DESCRIPTION;
	@Getter
	private String colQuantity = Constants.PRODUCT_QUANTITY;
	@Getter
	private String colPrice = Constants.PRODUCT_PRICE;
	@Getter
	@Setter
	protected FIXGRIDListBinding<ProductItem> rows = new FIXGRIDListBinding<ProductItem>();
	@Getter
	private ProductService service;
	@Getter
	@Setter
	private Product selectedProduct;
	@Getter
	@Setter
	private User selectedUser;
	@Getter
	@Setter
	private String prodImage;
	private UsermanagementUI parentUI;
	@Getter
	@Setter
	private int quantity;
	@Getter
	@Setter
	private double totalAmount;

	// ------------------------------------------------------------------------
	// inner classes
	// ------------------------------------------------------------------------
	public class ProductItem extends FIXGRIDItem implements java.io.Serializable {
		private static final long serialVersionUID = 1185547286646420460L;
		@Getter
		@Setter
		private Product product;

		public ProductItem(Product product) {
			this.product = product;
		}

		@Override
		public void onRowExecute() {

			if (product != null) {
				ProductSelection productSelection = selectedUser.getProdSelectionMap().get(product);
				productSelection = ProductSelection.builder().image(colImage).quantity(0).totalAmount(0d).build();
				setSelectedProduct(product);
				prodImage = product.getProductType().getImageSource();
				openProdQuantityPopup();
			}

		}

		@Override
		public void onRowSelect() {
			setSelectedProduct(product);
		}

	}

	/* Listener to the user of the page bean. */
	public interface IListener extends Serializable {
	}

	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------

	private IListener listener;

	// ------------------------------------------------------------------------
	// constructors & initialization
	// ------------------------------------------------------------------------
	public ProdcatalogUI() {
	}

	public ProdcatalogUI(UsermanagementUI usermanagementUI) {
		prepare(null);
		parentUI = usermanagementUI;
		this.selectedUser = usermanagementUI.getSelectedUser();
	}

	// ------------------------------------------------------------------------
	// public usage
	// ------------------------------------------------------------------------

	/*
	 * Initialization of the bean. Add any parameter that is required within your
	 * scenario.
	 */
	public void prepare(IListener listener) {
		this.listener = listener;
		rows.getItems().clear();
		service = new ProductService();
		service.getProductSet().stream().map(product -> new ProductItem(product))
				.forEach(item -> rows.getItems().add(item));
		rows.getItems().sort(getRowComparator());

	}

	public Comparator<ProductItem> getRowComparator() {
		return new Comparator<ProductItem>() {

			@Override
			public int compare(ProductItem o1, ProductItem o2) {
				return Product.getComparator().compare(o1.getProduct(), o2.getProduct());
			}
		};
	}

	public void openProdQuantityPopup() {
		ProdquantityUI prodQuantityUI = new ProdquantityUI(this);
		ModalPopup popup = openModalPopup(prodQuantityUI, Constants.PROD_QUANTITY_PAGE_TITLE, 200, 100,
				new DefaultModalPopupListener(this, prodQuantityUI));
		popup.setLeft(0);
		popup.setLeftTopReferenceCentered();
	}

	public void onAddToCart(ActionEvent event) {
		quantity = 0;
		totalAmount = 0d;
		parentUI.closePopup(this);
		Statusbar.outputSuccess(Constants.ORDER_ADDED);
	}

	/**
	 * After user selection quantities of {@linkplain Product} have to be updated.
	 */
	public void update() {
		rows.getItems().clear();
		service.getProductSet().stream().map(product -> new ProductItem(product))
				.forEach(item -> rows.getItems().add(item));
		rows.getItems().sort(getRowComparator());
	}

	public boolean isBtnAddToCartEnabled() {
		return selectedUser.getProdSelectionMap().keySet().stream()
				.anyMatch(key -> selectedUser.getProdSelectionMap().get(key).getQuantity() > 0);
	}

	// ------------------------------------------------------------------------
	// private usage
	// ------------------------------------------------------------------------

}
