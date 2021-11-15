package com.simple.thrillio;

import com.simple.thrillio.entities.Bookmark;
import com.simple.thrillio.entities.User;
import com.simple.thrillio.managers.BookmarkManager;
import com.simple.thrillio.managers.UserManager;

public class Launch {

	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		System.out.println("Loading data ...");
		DataStore.loadData();
		users = UserManager.getInstance().getUser();
		bookmarks = BookmarkManager.getInstance().getBookmark();
	}

	private static void printUser() {
		for (User user : users) {
			System.out.println(user);
		}
	}

	private static void printBookmark() {
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bm : bookmarkList) {
				System.out.println(bm);
			}
		}
	}

	private static void printData() {
		System.out.println("Printing data ...");
		printUser();
		printBookmark();
	}

	public static void start() {
//		System.out.println("Bookmarking ...");
		for (User user : users) {
			View.browse(user, bookmarks);
		}
	}

	public static void main(String[] args) {
		loadData();
//		printData();
		start();
	}

}
