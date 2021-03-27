package com.blog.blog;

import java.time.LocalDate;

public class Blog {

	private final BlogID blogID;
	private BlogType blogType;
	private String author;
	private final LocalDate creationDate;
	
	public BlogID id() {
		return this.blogID;
	}
	public Blog(BlogID blogID, BlogType blogType, String author, LocalDate creationDate) {
		super();
		this.blogID = blogID;
		this.blogType = blogType;
		this.author = author;
		this.creationDate = creationDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((blogID == null) ? 0 : blogID.hashCode());
		result = prime * result + ((blogType == null) ? 0 : blogType.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (blogID == null) {
			if (other.blogID != null)
				return false;
		} else if (!blogID.equals(other.blogID))
			return false;
		if (blogType != other.blogType)
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Blog [blogID=" + blogID + ", blogType=" + blogType + ", author=" + author + ", creationDate="
				+ creationDate + "]";
	}
	

	

}
