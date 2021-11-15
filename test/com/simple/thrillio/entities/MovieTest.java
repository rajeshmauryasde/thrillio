package com.simple.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.simple.thrillio.constants.MovieGenre;
import com.simple.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		// 1. If it's a horror movie
		Bookmark movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		assertFalse("If it's a horror movie, return false", movie.isKidFriendlyEligible());
		
		// 2. If it's a triller movie, return false
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);
		assertFalse("If it's a thriller movie, return false", movie.isKidFriendlyEligible());
		
		// 3. For other kind of movie, return true
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.CLASSICS,
				8.5);
		assertTrue("If it's a non-thriller, non-horror movie, return true", movie.isKidFriendlyEligible());
	}

}
