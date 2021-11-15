package com.simple.thrillio.controllers;

import com.simple.thrillio.entities.Bookmark;
import com.simple.thrillio.entities.User;
import com.simple.thrillio.managers.BookmarkManager;

public class BookmarkController {
	private static BookmarkController bookmarkController = new BookmarkController();
	
	private BookmarkController() {
	}
	
	public static BookmarkController getInstance() {
		return bookmarkController;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().share(user, bookmark);
	}

}
