package de.dkh.onlineshop.view.managebeans;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

import org.eclnt.jsfserver.beantesting.RequestSimlulation;
import org.eclnt.jsfserver.beantesting.Testing;
import org.eclnt.jsfserver.elements.BaseActionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.dkh.db.bo.User;
import de.dkh.onlineshop.view.managedbeans.UsermanagementUI;

/**
 * @TODO...
 * 
 * @author dkh
 *
 */
class UsermanagementUIIT {
	private UsermanagementUI userManamgementUI;

	@BeforeEach
	void setUp() throws Exception {
		userManamgementUI = new UsermanagementUI();
	}

	@Test
	@DisplayName("Testing the remove action if no users selected to be removed")
	void removeSelectedUsersTest1() {
		userManamgementUI.setSelectedUserSet(Collections.emptySet());

		try {
			Testing.startTest();

			Testing.simulateRequest(new RequestSimlulation() {

				@Override
				public void processUpdate() {
					// nothing todo...
				}

				@Override
				public void processInvoke() {
					BaseActionEvent event = Testing.createEvent("invoke()");
					userManamgementUI.onRemoveSelectedUsers(event);
//					Testing.getPopupYESNOPopup().onYes(event);
				}

				@Override
				public void processRender() {
					assertTrue(userManamgementUI.getRows().getItems().size() == 100);
				}
			});

		} catch (Throwable t) {
			fail(String.format("-------------Test result:------------- FAILED! (%s)", t.getLocalizedMessage()));
		}
	}

	@Test
	@DisplayName("Testing the remove action if 10 users selected to be removed")
	void removeSelectedUsersTest2() {
		userManamgementUI.setSelectedUserSet(Set.of(
				new User(1, "Gerheide Hertweck", "Auenstraße 94, 14089 Spandau", "gerheide-hertweck@goggle-mail.none",
						LocalDate.of(1989, 4, 23)),
				new User(2, "Rudolph Hirtreiter", "Rönneburger Straße 71, 89607 Emerkingen",
						"r_hirtreiter@retromail.none", LocalDate.of(1989, 4, 23)),
				new User(3, "Adelbert Brand", "Holbeinstraße 26, 45525 Hattingen an der Ruhr", "a.brand@trashmail.none",
						LocalDate.of(1989, 4, 23)),
				new User(4, "Andy Nietsch", "Mohlenweg 44, 56589 Datzeroth", "a.nietsch@web.none",
						LocalDate.of(1989, 4, 23)),
				new User(5, "Irmentraud Siems", "Königsheide 199, 49828 Esche", "irmentraud-siems@trashmail.none",
						LocalDate.of(1989, 4, 23)),
				new User(6, "Carl Lenze", "Brachtendorfer Weg 87, 29456 Hitzacker", "carl-1909@email.none",
						LocalDate.of(1989, 4, 23)),
				new User(7, "Uto Townsend", "Jakobistraße 172, 37581 Bad Gandersheim", "u.townsend@trashmail.none",
						LocalDate.of(1909, 7, 23)),
				new User(8, "Marhild Hornig", "Lötzener Straße 44, 75210 Keltern", "marhild.hornig@private.none",
						LocalDate.of(1989, 4, 23)),
				new User(9, "Ferhard Spohr", "Brabantstraße 94, 54518 Heidweiler", "ferhard.spohr@company.none",
						LocalDate.of(1989, 4, 23)),
				new User(10, "Friedwin Sattler", "Orsoyer Straße 153, 24238 Martensrade",
						"friedwin.1948@validmail.none", LocalDate.of(1989, 4, 23))));

		try {
			Testing.startTest();

			Testing.simulateRequest(new RequestSimlulation() {

				@Override
				public void processUpdate() {
					// nothing todo...
				}

				@Override
				public void processInvoke() {
					BaseActionEvent event = Testing.createEvent("invoke()");
					userManamgementUI.onRemoveSelectedUsers(event);
					Testing.getPopupYESNOPopup().onYes(event);
				}

				@Override
				public void processRender() {
					assertTrue(userManamgementUI.getRows().getItems().size() == 90);
				}
			});

		} catch (Throwable t) {
			fail(String.format("-------------Test result:------------- FAILED! (%s)", t.getLocalizedMessage()));
		}
	}

}
