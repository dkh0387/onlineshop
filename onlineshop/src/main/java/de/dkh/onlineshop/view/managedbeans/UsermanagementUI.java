package de.dkh.onlineshop.view.managedbeans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import javax.faces.event.ActionEvent;

import org.eclnt.editor.annotations.CCGenClass;
import org.eclnt.jsfserver.defaultscreens.ModalPopup;
import org.eclnt.jsfserver.defaultscreens.Statusbar;
import org.eclnt.jsfserver.defaultscreens.YESNOPopup;
import org.eclnt.jsfserver.defaultscreens.YESNOPopup.IYesNoListener;
import org.eclnt.jsfserver.elements.impl.FIXGRIDItem;
import org.eclnt.jsfserver.elements.impl.FIXGRIDListBinding;
import org.eclnt.jsfserver.elements.util.DefaultModalPopupListener;
import org.eclnt.jsfserver.pagebean.PageBean;

import de.dkh.core.Constants;
import de.dkh.db.bo.User;
import de.dkh.service.UserManagementService;
import lombok.Getter;
import lombok.Setter;

@CCGenClass(expressionBase = "#{d.UsermanagementUI}")
public class UsermanagementUI extends PageBean implements Serializable {

	private static final long serialVersionUID = 3392183545165173825L;
	@Getter
	private String pageName = "/usermanagement.xml";
	@Getter
	private String rootExpressionUsedInPage = "#{d.UsermanagementUI}";
	@Getter
	private String pageTitle = Constants.PAGE_TITLE;
	@Getter
	private String colName = Constants.USER_NAME;
	@Getter
	private String colAdress = Constants.USER_ADRESS;
	@Getter
	private String colMail = Constants.USER_MAIL;
	@Getter
	private String colBday = Constants.USER_BDAY;
	@Getter
	@Setter
	protected FIXGRIDListBinding<UserItem> rows = new FIXGRIDListBinding<UserItem>();
	@Getter
	private UserManagementService service;
	@Setter
	private Set<User> selectedUserSet = new HashSet<>();
	// ------------------------------------------------------------------------
	// inner classes
	// ------------------------------------------------------------------------

	/* Listener to the user of the page bean. */
	public interface IListener extends Serializable {
	}

	public class UserItem extends FIXGRIDItem implements java.io.Serializable {

		private static final long serialVersionUID = 8108052725578837558L;
		@Getter
		@Setter
		protected User user;

		public UserItem(User user) {
			this.user = user;

		}

		@Override
		public void onRowExecute() {
		}

		@Override
		public void onRowSelect() {
			selectedUserSet.add(user);
		}

	}

	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------

	private IListener listener;

	// ------------------------------------------------------------------------
	// constructors & initialization
	// ------------------------------------------------------------------------

	public UsermanagementUI() {
		prepare(null);
	}

	// ------------------------------------------------------------------------
	// public usage
	// ------------------------------------------------------------------------
	public void refreshGrid() {
		rows.getItems().clear();
		service.getUserSet().stream().map(user -> new UserItem(user)).forEach(item -> rows.getItems().add(item));
		rows.getItems().sort(getRowComparator());
	}

	/**
	 * No Test needed here since the add-logic already covered in
	 * {@linkplain NewUserUIIT}.
	 * 
	 * @param event
	 */
	public void onAddUser(ActionEvent event) {
		NewuserUI newUserUI = new NewuserUI(this);
		ModalPopup popup = openModalPopup(newUserUI, Constants.NEW_USER_PAGE_TITLE, 800, 500,
				new DefaultModalPopupListener(this, newUserUI));
		popup.setLeft(0);
		popup.setLeftTopReferenceCentered();
	}

	public void onRemoveSelectedUsers(ActionEvent event) {

		if (selectedUserSet.isEmpty()) {
			Statusbar.outputAlert(Constants.USER_DELETE_NO_SELECTION);
			return;
		}
		YESNOPopup popup = YESNOPopup.createInstance(Constants.USER_DELETE_DIALOG_TITLE,
				Constants.USER_DELETE_DIALOG_TEXT, new IYesNoListener() {
					@Override
					public void reactOnYes() {
						deleteSelectedUsers();
						refreshGrid();
					}

					@Override
					public void reactOnNo() {

					}
				});
		popup.setYesButtonImage(null);
		popup.setNoButtonImage(null);
		popup.getModalPopup().setStartfromrootwindow(true);
		popup.getModalPopup().setLeft(0);
		popup.getModalPopup().setLeftTopReferenceCentered();

	}

	public void onReload(ActionEvent event) {
		service = new UserManagementService();
		prepare(null);
	}

	/*
	 * Initialization of the bean. Add any parameter that is required within your
	 * scenario.
	 */
	public void prepare(IListener listener) {
		this.listener = listener;
		rows.getItems().clear();
		service = new UserManagementService();
		service.getUserSet().stream().map(user -> new UserItem(user)).forEach(item -> rows.getItems().add(item));
		rows.getItems().sort(getRowComparator());
	}

	// ------------------------------------------------------------------------
	// private usage
	// ------------------------------------------------------------------------
	private void deleteSelectedUsers() {
		service.getUserSet().removeAll(selectedUserSet);
		service.sort();
		selectedUserSet = new HashSet<>();
	}

	/**
	 * No Test needed since the {@linkplain User#getComparator()} already covered in
	 * {@linkplain UserTest}.
	 * 
	 * @return
	 */
	public Comparator<UserItem> getRowComparator() {
		return new Comparator<UserItem>() {

			@Override
			public int compare(UserItem o1, UserItem o2) {
				return User.getComparator().compare(o1.getUser(), o2.getUser());
			}
		};
	}

}
