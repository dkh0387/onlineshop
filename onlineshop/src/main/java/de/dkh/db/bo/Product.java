package de.dkh.db.bo;

import java.util.Comparator;
import java.util.Objects;

import de.dkh.core.EProductType;
import lombok.Getter;
import lombok.Setter;

/**
 * POJO for products may be shopped in the onlineshop.
 * 
 * @author dkh
 *
 */
public class Product {
	@Getter
	@Setter
	private EProductType productType;
	@Getter
	@Setter
	private String description;
	@Getter
	@Setter
	private int quantity;
	@Getter
	@Setter
	private double price;

	public Product(EProductType productType, String description, int quantity, double price) {
		super();
		this.productType = productType;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public static Comparator<Product> getComparator() {
		return new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {

				if (o1 == null && o2 == null) {
					return 0;
				}

				if (o1 == null) {
					return -1;
				}

				if (o2 == null) {
					return 1;
				}
				return o1.getProductType().name().compareTo(o2.getProductType().name());
			}
		};

	}

	@Override
	public int hashCode() {
		return Objects.hash(productType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return productType == other.productType;
	}

}
