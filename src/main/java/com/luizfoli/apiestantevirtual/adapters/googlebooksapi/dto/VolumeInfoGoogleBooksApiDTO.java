package com.luizfoli.apiestantevirtual.adapters.googlebooksapi.dto;

public class VolumeInfoGoogleBooksApiDTO {

	private String title;
	private String subTitle;
	private String[] authors;
	private String publisher;
	private String publishedDate;
	private String description;
	private int pageCount;
	private int averageRating;
	private int ratingsCount;
	private ImageLinksGoogleBooksApiDTO imageLinks;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}
	public int getRatingsCount() {
		return ratingsCount;
	}
	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
	}
	public ImageLinksGoogleBooksApiDTO getImageLinks() {
		return imageLinks;
	}
	public void setImageLinks(ImageLinksGoogleBooksApiDTO imageLinks) {
		this.imageLinks = imageLinks;
	}
	
	
	
	
}
