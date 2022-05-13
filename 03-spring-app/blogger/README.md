# Blogging App 

## Features

### Required 

- Users can signup to create accounts
  - Users have username, email, bio (text), avatar (img url)
- Users can login to their accounts
- Users can write blog articles 
  - Blog articles should have a heading, subheading, tags and content body 
  - Assume reasonable length for heading, subheading, no limit on body
  - Body content will be html
  - Tags are an array of strings
- Users can comment on blog articles
  - Comments will have a title and a body 
  - Title is optional, but body is required
- Users can like blog articles
- Users can follow other users 
- Users can see list of all other users 
  - Users can see profile of individual users
  - Users can search for profiles by username (or part)
- There should be a feed of all articles (reverse chronological order)
  - Ability to filter blogs by tags 
  - Ability to filter blogs written by a specific user
  - Ability to search for articles by title
  - Ability to sort articles by \[date (default), likes\]
- There should be a feed of all articles of authors a user is following

### Future Scope 

- Add a image upload service so that \<img\> can be embedded in blog articles
- Add support for pagination when listing articles and users

## Technical Details

### Entities

#### User 

```json
{
  "username": "johndoe001",
  "email": "john@mail.com",
  "bio": "I am a software developer",
  "avatar": "https://avatars.dicebear.com/v2/johndoe001.png"
}
```
> NOTE: `password` has to be hashed and stored too


#### Article 

#### Comment

