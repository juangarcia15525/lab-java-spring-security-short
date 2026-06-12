package com.example.blogcms.config;

import com.example.blogcms.model.Author;
import com.example.blogcms.model.BlogPost;
import com.example.blogcms.repository.AuthorRepository;
import com.example.blogcms.repository.BlogPostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BlogPostRepository blogPostRepository;

    public DataLoader(AuthorRepository authorRepository, BlogPostRepository blogPostRepository) {
        this.authorRepository = authorRepository;
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public void run(String... args) {
        if (authorRepository.count() > 0) {
            return;
        }

        Author aiko = authorRepository.save(new Author("Aiko Tanaka"));
        Author jonas = authorRepository.save(new Author("Jonas Schmidt"));
        authorRepository.save(new Author("Cas Van Dijk"));

        blogPostRepository.save(new BlogPost(aiko, "Boost Your Productivity with 10 Easy Tips", "Productivity - we all want it but it seems ..."));
        blogPostRepository.save(new BlogPost(aiko, "How to Focus", "Do you ever sit down to work and find yourself ..."));
        blogPostRepository.save(new BlogPost(jonas, "Learn to Speed Read in 30 Days", "Knowledge, not ability, is the great determiner of ..."));
    }
}
