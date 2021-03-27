package com.hr.mytest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.hr.main.BlogManagementApplication;
import com.hr.model.Blog;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BlogManagementApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl(){
		return "http://localhost:" + port + "/api/v1";
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAllBlogs(){
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/blogs", HttpMethod.GET, entity, String.class);

		assertNotNull(response.getBody());
	}

	@Test
	public void testGetBlogById(){
		Blog blog = restTemplate.getForObject(getRootUrl() + "/blogs/1", Blog.class);
		assertNotNull(blog);
	}

	@Test
	public void testCreateBlog(){
		Blog blog = new Blog();
		blog.setTitle("Tytuł");
		blog.setBody("Treść wpisu");
		blog.setCreatedBy("admin");
		blog.setUpdatedBy("admin");

		ResponseEntity<Blog> postResponse = restTemplate.postForEntity(getRootUrl() + "/blogs", blog, Blog.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateBlog(){
		int id = 1;
		Blog blog = restTemplate.getForObject(getRootUrl() + "/blogs/" + id, Blog.class);
		blog.setTitle("Testowy tytuł");
		blog.setBody("To jest testowa treść");

		restTemplate.put(getRootUrl() + "/blogs/" + id, blog);

		Blog updatedBlog = restTemplate.getForObject(getRootUrl() + "/blogs/" + id, Blog.class);
		assertNotNull(updatedBlog);
	}

	@Test
	public void testDeleteBlog(){
		int id = 2;
		Blog blog = restTemplate.getForObject(getRootUrl() + "/blogs/" + id, Blog.class);
		assertNotNull(blog);

		restTemplate.delete(getRootUrl() + "/users/" + id);

		try {
			blog = restTemplate.getForObject(getRootUrl() + "/blogs/" + id, Blog.class);
		} catch(final HttpClientErrorException e){
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}