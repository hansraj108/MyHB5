package com.hr.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hr.model.Blog;
import com.hr.service.BlogService;

@Component
public class DbSeeder implements CommandLineRunner {
    private BlogService blogService;

    @Autowired
    public DbSeeder(BlogService blogService){
        this.blogService = blogService;
    }

    @Override
    public void run(String... strings) throws Exception{
        for(int i =0; i<5; i++){
            Blog blog = new Blog();
            blog.setTitle("My blog creation.");
            blog.setBody("<br class=\"Apple-interchange-newline\"><div id=\"bannerR\" style=\"margin: 0px -160px 0px 0px; padding: 0px; position: sticky; top: 20px; width: 160px; height: 10px; float: right; color: rgb(0, 0, 0); font-family: &quot;Open Sans&quot;, Arial, sans-serif; font-size: 14px;\"></div><div class=\"boxed\" style=\"margin: 10px 28.7969px; padding: 0px; clear: both; color: rgb(0, 0, 0); font-family: &quot;Open Sans&quot;, Arial, sans-serif; font-size: 14px; text-align: center;\"><div id=\"lipsum\" style=\"margin: 0px; padding: 0px; text-align: justify;\"><p style=\"margin-right: 0px; margin-bottom: 15px; margin-left: 0px; padding: 0px;\">hansraj tandel</u></p></div></div>");
            blog.setCreatedBy("Admin");
            blog.setUpdatedBy("Admin");
            blogService.saveBlog(blog);
        }
    }
}