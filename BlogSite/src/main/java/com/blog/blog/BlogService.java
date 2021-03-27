package com.blog.blog;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BlogService {

	public static final Blog ROCKETSCIENCE = BlogBuilder.educational().withId("1111").authorName("hans").creationDate(LocalDate.now()).build();
	public static final Blog AGRISCIENCE = BlogBuilder.educational().withId("2222").authorName("raj").creationDate(LocalDate.now()).build();
	public static final Blog DAILYTECHINFO = BlogBuilder.educational().withId("3333").authorName("tan").creationDate(LocalDate.now()).build();
	public static final Blog GADGATEINFO = BlogBuilder.educational().withId("4444").authorName("DEL").creationDate(LocalDate.now()).build();

	private static Map<BlogID, Blog> blogs = new HashMap<BlogID, Blog>() {
        {
            put(ROCKETSCIENCE.id(), ROCKETSCIENCE);
            put(AGRISCIENCE.id(), AGRISCIENCE);
            put(DAILYTECHINFO.id(), DAILYTECHINFO);
            put(GADGATEINFO.id(), GADGATEINFO);
        }
    };

    public Blog blogFor(BlogID blogID) {
		return blogs.get(blogID);
	}

}
