package com.scaler.blogger.comments;

import com.scaler.blogger.articles.ArticleEntity;
import com.scaler.blogger.users.UserEntity;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommentsRepositoryTests {

    @Autowired
    private CommentsRepository commentsRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    void can_add_comments(){ //Create Method testing

        //TODD : Need to add test case saving data of Author and Article
        commentsRepository.save(CommentEntity.builder()
                .body("New comment")
                .title("Elementary Watson")
                .build());

        CommentEntity commentEntityTest = commentsRepository.getById(1);
        Assertions.assertTrue(commentEntityTest != null);

    }

    @Test
    @Order(2)
    void get_comment_by_id(){

        CommentEntity commentEntityTest = commentsRepository.getById(1);

        Assertions.assertTrue(commentEntityTest != null);

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    void update_comment(){
        CommentEntity commentEntityTest = commentsRepository.getById(1);
        commentEntityTest.setTitle("You know my methods, Watson.");

        CommentEntity commentEntityUpdated = commentsRepository.save(commentEntityTest);

        Assertions.assertEquals("You know my methods, Watson.", commentEntityUpdated.getTitle(),
                "Title Matched");

    }

    @Test
    @Order(4)
    void delete_comment(){
        commentsRepository.delete(commentsRepository.getById(1));

        CommentEntity commentEntity = null;

        Optional<CommentEntity> commentEntityCheck = commentsRepository.findById(1);

        if(commentEntityCheck.isPresent())
            commentEntity = commentEntityCheck.get();

        Assertions.assertTrue(commentEntity == null);
    }

}
