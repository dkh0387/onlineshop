package de.dkh.db.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the selection of a {@linkplain Product}, everything needed to
 * process the check out.
 * 
 * @author dkh
 *
 */
@AllArgsConstructor
@Builder
public class ProductSelection {
	@Getter
	@Setter
	private String image;
	@Getter
	@Setter
	private int quantity;
	@Getter
	@Setter
	private double totalAmount;

}
