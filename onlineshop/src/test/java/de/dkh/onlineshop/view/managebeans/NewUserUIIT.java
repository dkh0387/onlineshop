package de.dkh.onlineshop.view.managebeans;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.Collections;

import org.eclnt.jsfserver.beantesting.RequestSimlulation;
import org.eclnt.jsfserver.beantesting.Testing;
import org.eclnt.jsfserver.elements.BaseActionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import de.dkh.core.Validator;
import de.dkh.onlineshop.view.managedbeans.NewuserUI;
import de.dkh.onlineshop.view.managedbeans.UsermanagementUI;
import de.dkh.service.UserManagementService;

@ExtendWith(MockitoExtension.class)
class NewUserUIIT {
	private NewuserUI newUserUI;
	@Mock
	private UsermanagementUI mockParentUI;
	@Mock
	private Validator mockValidator;
	@Mock
	private UserManagementService mockService;

	@BeforeEach
	void setUp() throws Exception {
		newUserUI = new NewuserUI(mockParentUI, mockValidator);
		newUserUI.setName("name");
		newUserUI.setAdress("adress");
		newUserUI.setMail("mail");
		newUserUI.setBday(LocalDate.of(1900, 12, 12));
		Mockito.when(mockValidator.validateFields(Mockito.anyMap())).thenReturn(Collections.emptyList());
		Mockito.when(mockValidator.validateMail(Mockito.anyString())).thenReturn(true);
		Mockito.when(mockParentUI.getService()).thenReturn(mockService);
		Mockito.when(mockParentUI.getService().getUserSet()).thenReturn(Mockito.anySet());
	}

	/**
	 * All the attributes are setted to pass the {@linkplain this#mockValidator}.
	 */
	@Test
	@DisplayName("Testing the NEW-logic only")
	public void restoreReportTest() {

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
					newUserUI.onOK(event);
//					Testing.getPopupYESNOPopup().onYes(event);
				}

				@Override
				public void processRender() {
					assertTrue(newUserUI.getNewUserSet().size() == 1);
				}
			});

		} catch (Throwable t) {
			fail(String.format("-------------Test result:------------- FAILED! (%s)", t.getLocalizedMessage()));
		}

	}

}
