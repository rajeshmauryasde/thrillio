package com.simple.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.simple.thrillio.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1 : porn in url -- false
		Bookmark webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn-tiger--part-2.html",
				"http://www.javaworld.com");
		assertFalse("For porn in url, isKidFriendlyEligible() must return false", webLink.isKidFriendlyEligible());

		// Test 2 : porn in title -- false
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger porn Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		assertFalse("For porn in title, isKidFriendlyEligible() must return false", webLink.isKidFriendlyEligible());

		// Test 3 : adult in host -- false
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld-adult.com");
		assertFalse("For adult in host, isKidFriendlyEligible() must return false", webLink.isKidFriendlyEligible());

		// Test 4 : adult in url but not in host -- true
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger-adult-part-2.html",
				"http://www.javaworld.com");
		assertTrue("For adult in url but not in host, isKidFriendlyEligible() must return true", webLink.isKidFriendlyEligible());

		// Test 5 : adult in title only -- true
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming adult Tiger Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		assertTrue("For adult in title only, isKidFriendlyEligible() must return true", webLink.isKidFriendlyEligible());
	}

}
