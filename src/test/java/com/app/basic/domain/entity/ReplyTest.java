package com.app.basic.domain.entity;

import com.app.basic.domain.type.ReplyStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional(rollbackFor = Exception.class) @Commit
class ReplyTest {
    @PersistenceContext
    private EntityManager entityManager;


    @Test
    public void insertTest() {
        Reply reply = new Reply();
        reply.setReplyContent("게시글3");
        reply.setReplyWrite("김세환");
        reply.setReplyStatus(ReplyStatus.PUBLIC);

//        영속
        entityManager.persist(reply);

    }

    @Test
    public void selectTest(){
        Reply foundReply = entityManager.find(Reply.class, 1L);
        log.info("{}", foundReply.toString());
    }

    @Test
    public void updateTest(){
        Reply foundReply = entityManager.find(Reply.class, 1L);
        foundReply.setReplyStatus(ReplyStatus.PRIVATE);
    }

    @Test
    public void deleteTest(){
        Reply foundReply = entityManager.find(Reply.class, 1L);
        entityManager.remove(foundReply);
    }

    @Test
    public void replySelectAllTest(){
//        JPA QL
//        1) *(와일드 카드) 사용이 불가능하다.
//        테이블에 알리아스(소문자) 붙여서 모든 데이터를 조회할 수 있다.
//        2) FROM절에 가져오는 테이블은 DB에 테이블이 아니라 엔터티 객체이다.
//        3) 타입을 알려주어야 한다.
        log.info("JPA QL 데이터 조회: {}", entityManager.createQuery("SELECT r FROM Reply r", Reply.class).getResultList().toString());

        log.info("단일행 조회: {}", entityManager.createQuery("SELECT r FROM Reply r WHERE r.id = :id", Reply.class).setParameter("id", 2L).getSingleResult().toString());

    }
}



