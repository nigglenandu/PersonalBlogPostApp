package com.PersonalBlogPlatform.personalBlogPlatform.Services;

import com.PersonalBlogPlatform.personalBlogPlatform.Entity.BlogPost;

import java.util.List;
import java.util.Optional;

public interface IServiceBlogPost {

    List<BlogPost> getBlogPost();

    Optional<BlogPost> getBlogPostById(Long id);

    void createBlogPost(BlogPost blogPost);

    boolean updateBlogPostById(Long id, BlogPost blogPost);

    boolean deleteBlogPostById(Long id);
}
