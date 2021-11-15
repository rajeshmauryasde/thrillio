package com.simple.thrillio;

import com.simple.thrillio.constants.KidFriendlyStatus;
import com.simple.thrillio.constants.UserType;
import com.simple.thrillio.controllers.BookmarkController;
import com.simple.thrillio.entities.Bookmark;
import com.simple.thrillio.entities.User;

public class View {
//	public static void bookmark(User user, Bookmark[][] bookmarks) {
//		System.out.println("User " + user.getEmail() + " is bookmarking");
//		for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
//			int typeOffset = (int) (Math.random() * DataStore.BOOKMARKS_TYPES_COUNT);
//			int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
//
//			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
//			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
//
//			System.out.println(bookmark);
//		}
//	}

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("User " + user.getEmail() + " is browsing");

		int bookmarkCount = 0;
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean bookmarkDecision = getBookmarkDecision(bookmark);

					if (bookmarkDecision) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New item bookmarked --- " + bookmark);
					}
				}

				if (user.getUserType().equals(UserType.CHIEF_EDITOR) || user.getUserType().equals(UserType.EDITOR)) {
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							bookmark.setKidFriendlyStatus(kidFriendlyStatus);
							System.out.println("\nKid friendly status: " + kidFriendlyStatus + ", " + bookmark + "\n");
						}
					}
				}
			}
		}
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		// TODO Auto-generated method stub
		double randomValue = Math.random();

		if (randomValue < 0.4) {
			return KidFriendlyStatus.APPROVED;
		} else if (randomValue >= 0.4 && randomValue < 0.8) {
			return KidFriendlyStatus.REJECTED;
		} else {
			return KidFriendlyStatus.UNKNOWN;
		}
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		// TODO Auto-generated method stub
		return Math.random() < 0.5 ? true : false;
	}

}
