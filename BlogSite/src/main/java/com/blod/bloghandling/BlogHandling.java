package com.blod.bloghandling;

import com.blog.blog.Blog;
import com.blog.blog.BlogID;

public interface BlogHandling {

	public abstract void createBlog(Blog blog);
	public abstract Blog updateBlog(Blog blog);
	public abstract void deleteBlog(BlogID blogID);
	
	
}
