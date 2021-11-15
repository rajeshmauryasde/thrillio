package com.simple.thrillio.managers;

import com.simple.thrillio.dao.BookmarkDao;
import com.simple.thrillio.entities.Book;
import com.simple.thrillio.entities.Bookmark;
import com.simple.thrillio.entities.Movie;
import com.simple.thrillio.entities.User;
import com.simple.thrillio.entities.UserBookmark;
import com.simple.thrillio.entities.Weblink;

public class BookmarkManager {
	private static BookmarkManager bookmarkManager = new BookmarkManager();
	private BookmarkDao dao = new BookmarkDao();

	private BookmarkManager() {
	}

	public static BookmarkManager getInstance() {
		return bookmarkManager;
	}

	public Movie createMovie(long id, String title, int releaseYear, String[] cast, String[] directors, String genre,
			double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;
	}

	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, String genre,
			double amazonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);

		return book;
	}

	public Weblink createWebLink(long id, String title, String url, String host) {
		Weblink weblink = new Weblink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		weblink.setHost(host);

		return weblink;
	}

	public Bookmark[][] getBookmark() {
		return dao.getBookmark();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		
		dao.saveUserBookmark(userBookmark);
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println("Kid friendly marked by: " + user.getFirstName());
		System.out.println("\nKid friendly status: " + kidFriendlyStatus + ", " + bookmark + "\n");
	}

	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
		
		System.out.println("Data to be shared");
		if (bookmark instanceof Book) {
			System.out.println(((Book) bookmark).getItemData());
		}
		else {
			System.out.println(((Weblink) bookmark).getItemData());
		}
	}
}
