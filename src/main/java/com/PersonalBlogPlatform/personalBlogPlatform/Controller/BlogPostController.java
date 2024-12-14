package com.PersonalBlogPlatform.personalBlogPlatform.Controller;

import com.PersonalBlogPlatform.personalBlogPlatform.Entity.BlogPost;
import com.PersonalBlogPlatform.personalBlogPlatform.Services.IServiceBlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/blogposts")
public class BlogPostController {
    @Autowired
    private IServiceBlogPost serviceBlogPost;

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPosts(){
        return new ResponseEntity<>(serviceBlogPost.getBlogPost(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id){
        Optional<BlogPost> blogPost = serviceBlogPost.getBlogPostById(id);
//        if(blogPost.isPresent()){
//            return new ResponseEntity<>(blogPost.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
      return blogPost.map(ResponseEntity::ok) .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createBlogpost(@RequestBody BlogPost blogPost) {
        serviceBlogPost.createBlogPost(blogPost);
        return new ResponseEntity<>("BlogPost created successfully", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateBlogPostById(@PathVariable Long id, @RequestBody BlogPost blogPost){
        serviceBlogPost.updateBlogPostById(id, blogPost);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBlogPostById(@PathVariable Long id){
        serviceBlogPost.deleteBlogPostById(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
