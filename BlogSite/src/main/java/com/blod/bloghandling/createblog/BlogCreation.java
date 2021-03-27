package com.blod.bloghandling.createblog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.blod.bloghandling.UserID;
import com.blog.blog.Blog;

public class BlogCreation {

	private final UserID userID;
    private Blog blog;
	
    public BlogCreation(UserID userID, Blog blog) {
		super();
		this.userID = userID;
		this.blog = blog;
	}
    
    
}
