package de.dkh.onlineshop.view.managedbeans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.event.ActionEvent;

import org.eclnt.editor.annotations.CCGenClass;
import org.eclnt.jsfserver.defaultscreens.Statusbar;
import org.eclnt.jsfserver.pagebean.PageBean;

import de.dkh.core.Constants;
import de.dkh.core.Validator;
import de.dkh.db.bo.User;
import de.dkh.service.UserManagementService;
import lombok.Getter;
import lombok.Setter;

@CCGenClass(expressionBase = "#{d.NewuserUI}")
public class NewuserUI extends PageBean implements Serializable {

	private static final long serialVersionUID = -2445728022309238839L;
	@Getter
	private String pageName = "/newuser.xml";
	@Getter
	private String rootExpressionUsedInPage = "#{d.NewuserUI}";
	@Getter
	private String pageTitle = Constants.NEW_USER_PAGE_TITLE;
	@Getter
	private String lblName = Constants.USER_NAME;
	@Getter
	private String lblAdress = Constants.USER_ADRESS;
	@Getter
	private String lblMail = Constants.USER_MAIL;
	@Getter
	private String lblBday = Constants.USER_BDAY;
	@Getter
	private String lblBtnOK = Constants.BTN_OK;
	// ------------------------------------------------------------------------
	// inner classes
	// ------------------------------------------------------------------------

	/* Listener to the user of the page bean. */
	public interface IListener extends Serializable {
	}

	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------
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
	private UsermanagementUI parentUI;
	private IListener m_listener;
	@Setter
	private Validator validator;
	@Getter
	@Setter
	private Set<User> newUserSet = new HashSet<>();

	// ------------------------------------------------------------------------
	// constructors & initialization
	// ------------------------------------------------------------------------

	public NewuserUI() {
	}

	public NewuserUI(UsermanagementUI parentUI) {
		this.parentUI = parentUI;
		validator = new Validator();
	}

	/**
	 * For testing purpose only!
	 * 
	 * @param parentUI
	 */
	public NewuserUI(UsermanagementUI parentUI, Validator validator) {
		this.parentUI = parentUI;
		this.validator = validator;
	}

	// ------------------------------------------------------------------------
	// public usage
	// ------------------------------------------------------------------------
	public void onOK(ActionEvent event) {
		Map<String, Object> map = Map.of(Constants.USER_NAME, name == null ? "" : name, Constants.USER_ADRESS,
				adress == null ? "" : adress, Constants.USER_MAIL, mail == null ? "" : mail, Constants.USER_BDAY,
				bday == null ? "" : bday);
		List<String> emptyFields = validator.validateFields(map);
		boolean validMail = validator.validateMail(mail);

		if (emptyFields != null && (emptyFields.isEmpty() && validMail)) {

			User newUser = new User(getMaxUserID() + 1, name, adress, mail, bday);
			getUserSet().add(newUser);
			newUserSet.add(newUser);
			parentUI.refreshGrid();
			parentUI.closePopup(this);
		} else {
			Statusbar.outputError(
					!emptyFields.isEmpty() ? String.format(Constants.USER_NEW_FIELDS_ERROR, emptyFields.toString())
							: Constants.USER_NEW_MAIL_ERROR);
		}
	}

	/*
	 * Initialization of the bean. Add any parameter that is required within your
	 * scenario.
	 */
	public void prepare(IListener listener) {
		m_listener = listener;
	}

	// ------------------------------------------------------------------------
	// private usage
	// ------------------------------------------------------------------------
	/**
	 * Find the mx. id presented in the
	 * {@linkplain UserManagementService#getUserSet()}. If the set is empty return
	 * -1.
	 * 
	 * @return
	 */
	private int getMaxUserID() {
		return getUserSet().isEmpty() ? -1 : getUserSet().stream().mapToInt(User::getId).max().getAsInt();
	}

	private Set<User> getUserSet() {
		return parentUI.getService().getUserSet();
	}

}
