package com.simple.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simple.thrillio.constants.BookGenre;
import com.simple.thrillio.managers.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		
		// 1. If it is philosphy book
		Bookmark book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
		assertFalse(book.isKidFriendlyEligible(), "If it's a philosphy book, return false");
		
		// 2. If it's a self help
		book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);
		assertFalse(book.isKidFriendlyEligible(), "it's a self help book, return false");
		
		// 3. If it's a another book genre
		book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.ART, 4.3);
		assertTrue(book.isKidFriendlyEligible(), "If it's a other kind book, return true");
	}

}
