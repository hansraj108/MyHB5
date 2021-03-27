package com.hr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.exception.ResourceNotFoundException;
import com.hr.model.Blog;
import com.hr.service.BlogService;

@RestController
@RequestMapping("/api/v1/blogs")
@CrossOrigin(origins = "http://localhost:4200")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public List<Blog> getAllBlogs() {
        return blogService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable(value = "id") Long blogId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(blogService.findById(blogId));
    }

    @PostMapping("")
    public Blog createBlog( @RequestBody Blog blog){
        return blogService.saveBlog(blog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable(value = "id") Long blogId,@RequestBody Blog blogDetails) throws ResourceNotFoundException {
        return ResponseEntity.ok(blogService.updateBlog(blogId, blogDetails));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteBlog(@PathVariable(value = "id") Long blogId) throws Exception {
        return blogService.deleteBlog(blogId);
    }
}