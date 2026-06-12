package com.example.blogcms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BlogPostRequest {

    @NotNull(message = "Author id is required")
    private Long authorId;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Post content is required")
    private String post;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
