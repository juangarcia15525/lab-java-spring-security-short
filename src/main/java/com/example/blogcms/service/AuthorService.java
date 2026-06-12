package com.example.blogcms.service;

import com.example.blogcms.dto.AuthorRequest;
import com.example.blogcms.exception.ResourceNotFoundException;
import com.example.blogcms.model.Author;
import com.example.blogcms.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " was not found"));
    }

    public Author create(AuthorRequest request) {
        return authorRepository.save(new Author(request.getName()));
    }

    public Author update(Long id, AuthorRequest request) {
        Author author = findById(id);
        author.setName(request.getName());
        return authorRepository.save(author);
    }

    public void delete(Long id) {
        authorRepository.delete(findById(id));
    }
}
