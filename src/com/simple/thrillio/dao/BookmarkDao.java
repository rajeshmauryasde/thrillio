package com.simple.thrillio.dao;

import com.simple.thrillio.DataStore;
import com.simple.thrillio.entities.Bookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmark() {
		return DataStore.getBookmarks();
	}
}
