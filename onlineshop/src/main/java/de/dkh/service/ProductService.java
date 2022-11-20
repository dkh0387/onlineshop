package de.dkh.service;

import java.util.HashSet;
import java.util.Set;

import de.dkh.core.EProductType;
import de.dkh.db.bo.Product;
import lombok.Getter;

/**
 * Collect, sort and hold all the {@linkplain Product}. Manages all the
 * operations needed for shopping cart calculations.
 * 
 * @author dkh
 *
 */
public class ProductService {
	@Getter
	private Set<Product> productSet = new HashSet<>();

	public ProductService() {
		super();
		initProductSet();
	}

	public void sort() {
		productSet.stream().sorted(Product.getComparator());
	}

	private void initProductSet() {
		productSet.add(new Product(EProductType.MARMALADE, "Strawberry marmalade", 34, 3.50));
		productSet.add(new Product(EProductType.CHOCOLATE_CREAM, "Chocolate cream", 12, 2.75));
		productSet.add(new Product(EProductType.INSTANT_COFFEE, "Instant coffee", 23, 4.99));
		productSet.add(new Product(EProductType.SUGAR, "Sugar white", 456, 1.99));
	}

	public double calcTotal(Product product, int quantity) {
		return product.getPrice() * quantity;
	}

	public boolean checkAvailable(Product product, int quantity) {
		return productSet.stream().filter(p -> p.equals(product)).anyMatch(p -> p.getQuantity() >= quantity);
	}

	public Product getSelectedProduct(Product selectedProduct) {
		return productSet.stream().filter(p -> p.equals(selectedProduct)).findAny().get();
	}

	public void updateQuantity(Product selectedProduct, int quantity) {
		selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity);
	}

	public Object getQuantityFor(Product selectedProduct) {
		return getSelectedProduct(selectedProduct).getQuantity();
	}
}
