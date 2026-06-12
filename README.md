# LAB Java | Spring Security

## Solution

Spring Boot REST API for a blog content management system with authors, posts, JPA tables, seeded data, and Spring Security.

### Run

```bash
mvn spring-boot:run
```

The API runs on:

```text
http://localhost:8081
```

### Admin credentials

```text
username: admin
password: admin123
```

### Public GET routes

```text
GET /api/posts
GET /api/posts/{id}
GET /api/authors
GET /api/authors/{id}
```

### Admin-only routes

Use Basic Auth with the admin credentials.

```text
POST /api/posts
PUT /api/posts/{id}
DELETE /api/posts/{id}
POST /api/authors
PUT /api/authors/{id}
DELETE /api/authors/{id}
```

### H2 console

```text
http://localhost:8081/h2-console
jdbc:h2:mem:blog_cms_db
```

## Lab Requirements

For this activity, you will be building a content management system for a blog with multiple authors.

1. **Create tables:** Create the tables for the blog post and author in your database.
2. **Use Spring Security:** Use Spring Security to create an admin role.
3. **Create routes:** Create the following routes:

- Get the post and the author
- Add post
- Add author
- Update post
- Update author
- Delete post
- Delete author

4. **Restrict access:** Use Spring Security to ensure only admins can access every route except the GET route, which should be publicly available.

### Blog Post Table

| id | author_id | title | post |
| --- | --- | --- | --- |
| 1 | 1 | Boost Your Productivity with 10 Easy Tips | Productivity - we all want it but it seems ... |
| 2 | 1 | How to Focus | Do you ever sit down to work and find yourself ... |
| 3 | 2 | Learn to Speed Read in 30 Days | Knowledge, not ability, is the great determiner of ... |

### Author Table

| id | name |
| --- | --- |
| 1 | Aiko Tanaka |
| 2 | Jonas Schmidt |
| 3 | Cas Van Dijk |
