package com.blog.blog;

import java.time.LocalDate;

public class BlogBuilder {

	/*
	 * = BlogType.INFORMATIONAL; = new BlogID("1111"); = "hans";
	 */
	private BlogType blogType;
	private BlogID blogId;
	private String author;
	private LocalDate creationDate;

	private BlogBuilder(BlogType blogType) {
		this.blogType = blogType;
	}

	public static BlogBuilder educational() {
		return new BlogBuilder(BlogType.EDUCATIONAL);
	}

	public static BlogBuilder informational() {
		return new BlogBuilder(BlogType.INFORMATIONAL);
	}

	public BlogBuilder withId(String id) {
		this.blogId=new BlogID(id);
		return this;
	}
	public BlogBuilder authorName(String name) {
		this.author = name;
		return this;
	}

	public BlogBuilder creationDate(LocalDate date) {
		this.creationDate = date;
		return this;
	}

	public Blog build() {
		return new Blog(blogId, blogType, author, creationDate);
	}
}
