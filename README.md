# Blog CMS

Spring Boot REST API for a blog CMS with authors, posts, and Spring Security.

## Run

```bash
mvn spring-boot:run
```

The API runs on:

```text
http://localhost:8081
```

## Admin

```text
username: admin
password: admin123
```

## Public routes

```text
GET /api/posts
GET /api/posts/{id}
GET /api/authors
GET /api/authors/{id}
```

## Admin-only routes

```text
POST /api/posts
PUT /api/posts/{id}
DELETE /api/posts/{id}
POST /api/authors
PUT /api/authors/{id}
DELETE /api/authors/{id}
```

## H2 console

```text
http://localhost:8081/h2-console
jdbc:h2:mem:blog_cms_db
```
