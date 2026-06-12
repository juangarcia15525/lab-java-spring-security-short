package com.example.blogcms.service;

import com.example.blogcms.dto.BlogPostRequest;
import com.example.blogcms.exception.ResourceNotFoundException;
import com.example.blogcms.model.Author;
import com.example.blogcms.model.BlogPost;
import com.example.blogcms.repository.AuthorRepository;
import com.example.blogcms.repository.BlogPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final AuthorRepository authorRepository;

    public BlogPostService(BlogPostRepository blogPostRepository, AuthorRepository authorRepository) {
        this.blogPostRepository = blogPostRepository;
        this.authorRepository = authorRepository;
    }

    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }

    public BlogPost findById(Long id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " was not found"));
    }

    public BlogPost create(BlogPostRequest request) {
        Author author = findAuthor(request.getAuthorId());
        return blogPostRepository.save(new BlogPost(author, request.getTitle(), request.getPost()));
    }

    public BlogPost update(Long id, BlogPostRequest request) {
        BlogPost blogPost = findById(id);
        blogPost.setAuthor(findAuthor(request.getAuthorId()));
        blogPost.setTitle(request.getTitle());
        blogPost.setPost(request.getPost());
        return blogPostRepository.save(blogPost);
    }

    public void delete(Long id) {
        blogPostRepository.delete(findById(id));
    }

    private Author findAuthor(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + authorId + " was not found"));
    }
}
