package de.dkh.db.bo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * POJO for User-Object being managed in the associated Grid
 * 
 * @author dkh
 *
 */
@AllArgsConstructor
public class User {
	@Getter
	@Setter
	private int id;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String adress;
	@Getter
	@Setter
	private String mail;
	@Getter
	@Setter
	private LocalDate bday;

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}

	public static Comparator<User> getComparator() {
		return new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {

				if (o1.getName() == null && o2.getName() == null) {
					return 0;
				}

				if (o1.getName() == null) {
					return -1;
				}

				if (o2.getName() == null) {
					return 1;
				}
				return o1.getName().compareTo(o2.getName());
			}
		};
	}

}
