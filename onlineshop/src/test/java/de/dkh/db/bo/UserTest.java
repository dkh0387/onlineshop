package de.dkh.db.bo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
	private User user1;
	private User user2;

	@BeforeEach
	void setUp() throws Exception {
		user1 = new User(1, "Andreas Hertweck", "Auenstraße 94, 14089 Spandau", "gerheide-hertweck@goggle-mail.none",
				LocalDate.of(1989, 4, 23));
		user2 = new User(2, "Bernd Hirtreiter", "Rönneburger Straße 71, 89607 Emerkingen",
				"r_hirtreiter@retromail.none", LocalDate.of(1989, 4, 23));
	}

	@Test
	@DisplayName("Testing the Comparator of the POJO User")
	void compareTest() {
		assertEquals(User.getComparator().compare(user1, user2), -1);
	}

}
