package com.PersonalBlogPlatform.personalBlogPlatform.Repository;

import com.PersonalBlogPlatform.personalBlogPlatform.Entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {
}
