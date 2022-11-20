package de.dkh.onlineshop.view.managedbeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

import javax.faces.event.ActionEvent;

import org.eclnt.editor.annotations.CCGenClass;
import org.eclnt.jsfserver.defaultscreens.Statusbar;
import org.eclnt.jsfserver.elements.impl.FIXGRIDItem;
import org.eclnt.jsfserver.elements.impl.FIXGRIDListBinding;
import org.eclnt.jsfserver.pagebean.PageBean;

import de.dkh.core.Constants;
import de.dkh.db.bo.Product;
import de.dkh.db.bo.ProductSelection;
import de.dkh.db.bo.User;
import lombok.Getter;
import lombok.Setter;

@CCGenClass(expressionBase = "#{d.ShoppingcartUI}")
public class ShoppingcartUI extends PageBean implements Serializable {

	private static final long serialVersionUID = 1986316111968906357L;
	@Getter
	private String pageName = "/shoppingcart.xml";
	@Getter
	private String rootExpressionUsedInPage = "#{d.ShoppingcartUI}";
	@Getter
	private String pageTitle = Constants.PROD_SHOPPING_CART_PAGE_TITLE;
	@Getter
	private String colImage = Constants.PRODUCT_IMAGE;
	@Getter
	private String colQuantity = Constants.PRODUCT_QUANTITY;
	@Getter
	private String colPrice = Constants.PRODUCT_TOTAL_PRICE;
	private IListener listener;
	private User selectedUser;
	private UsermanagementUI parentUI;
	@Getter
	@Setter
	protected FIXGRIDListBinding<OrderItem> rows = new FIXGRIDListBinding<OrderItem>();
	@Getter
	private boolean gridRendered;
	@Getter
	private boolean emptyCartRendered;

	// ------------------------------------------------------------------------
	// inner classes
	// ------------------------------------------------------------------------
	public class OrderItem extends FIXGRIDItem implements java.io.Serializable {

		private static final long serialVersionUID = -6001870183896270266L;
		@Getter
		@Setter
		private Product product;

		public OrderItem(Product product) {
			this.product = product;
		}

		public ProductSelection getProdSelection() {
			return selectedUser.getProdSelectionMap().getOrDefault(product, null);
		}

		@Override
		public void onRowExecute() {
		}

		@Override
		public void onRowSelect() {
		}

	}

	/* Listener to the user of the page bean. */
	public interface IListener extends Serializable {
	}

	// ------------------------------------------------------------------------
	// constructors & initialization
	// ------------------------------------------------------------------------

	public ShoppingcartUI() {
	}

	public ShoppingcartUI(User user, UsermanagementUI usermanagementUI) {
		this.parentUI = usermanagementUI;
		selectedUser = user;
		gridRendered = !selectedUser.getProdSelectionMap().isEmpty();
		emptyCartRendered = !gridRendered;
		prepare(null, selectedUser.getProdSelectionMap().keySet());
	}

	// ------------------------------------------------------------------------
	// public usage
	// ------------------------------------------------------------------------

	/*
	 * Initialization of the bean. Add any parameter that is required within your
	 * scenario.
	 */
	public void prepare(IListener listener, Set<Product> totalOrderSet) {
		this.listener = listener;

		if (totalOrderSet != null) {
			rows.getItems().clear();
			totalOrderSet.forEach(p -> rows.getItems().add(new OrderItem(p)));
		}
	}

	public void onPlaceOrder(ActionEvent event) {
		parentUI.closePopup(this);
		selectedUser.setProdSelectionMap(new HashMap<>());
		Statusbar.outputSuccess(String.format(Constants.ORDER_PLACED, selectedUser.getMail()));
	}

	// ------------------------------------------------------------------------
	// private usage
	// ------------------------------------------------------------------------
}
