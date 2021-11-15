package com.simple.thrillio.entities;

import java.util.Arrays;

import com.simple.thrillio.constants.BookGenre;
import com.simple.thrillio.partner.Shareable;

public class Book extends Bookmark implements Shareable {

	private int publicationYear;
	private String publisher;
	private String[] authors;
	private String genre;
	private double amazonRating;

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}

	@Override
	public String toString() {
		return super.toString() + " Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", authors="
				+ Arrays.toString(authors) + ", genre=" + genre + ", amazonRating=" + amazonRating + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if (genre.equals(BookGenre.PHILOSOPHY) || genre.equals(BookGenre.SELF_HELP)) {
			return false;
		}
		return true;
	}
	
	private String join(String[] list, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (String author : authors) {
			sb.append(author).append(delimiter);
		}
		for (int i = 0; i < delimiter.length(); i++) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	@Override
	public String getItemData() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<item>");
		sb.append("<title>").append(getTitle()).append("</item>");
		sb.append("<type>Book</type>");
		sb.append("<authors>").append(join(authors, ", ")).append("</authors>");
		sb.append("<publisher>").append(publisher).append("</publisher>");
		sb.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
		sb.append("<genre>").append(genre).append("</genre>");
		sb.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
		sb.append("</item>");
		
		return sb.toString();
	}

}
