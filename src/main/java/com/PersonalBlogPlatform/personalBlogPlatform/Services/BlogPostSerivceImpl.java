package com.PersonalBlogPlatform.personalBlogPlatform.Services;

import com.PersonalBlogPlatform.personalBlogPlatform.Entity.BlogPost;
import com.PersonalBlogPlatform.personalBlogPlatform.Repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostSerivceImpl implements IServiceBlogPost{

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Override
    public List<BlogPost> getBlogPost() {
        return blogPostRepository.findAll();
    }

    @Override
    public Optional<BlogPost> getBlogPostById(Long id) {
        return blogPostRepository.findById(id);
    }

    @Override
    public void createBlogPost(BlogPost blogPost) {
        blogPostRepository.save(blogPost);
    }

    @Override
    public boolean updateBlogPostById(Long id, BlogPost blogPost) {
        Optional<BlogPost> optional = blogPostRepository.findById(id);
        if (optional.isPresent()) {
            BlogPost blogpost1 = optional.get();
            blogpost1.setTitle(blogPost.getTitle());
            blogpost1.setContent(blogPost.getContent());
            blogpost1.setAuthor(blogPost.getAuthor());
            blogPostRepository.save(blogpost1);
            return true;
        } else {
            return true;
        }
    }

    @Override
    public boolean deleteBlogPostById(Long id) {
        if(blogPostRepository.existsById(id)){
            blogPostRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
