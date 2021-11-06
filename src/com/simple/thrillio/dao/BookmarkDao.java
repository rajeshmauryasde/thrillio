package com.simple.thrillio.dao;

import com.simple.thrillio.DataStore;
import com.simple.thrillio.entities.Bookmark;
import com.simple.thrillio.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmark() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
