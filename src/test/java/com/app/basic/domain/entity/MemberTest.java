package com.app.basic.domain.entity;

import com.app.basic.domain.type.MemberGender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j @Transactional @Commit
class MemberTest {

//    @Test
//    public void ordinalTest() {
//        MemberGender m = MemberGender.MALE;
//        log.info("MALE : {}", m.toString());
//    }

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void memberInsertTest() {
        Member member = new Member();
        member.setMemberEmail("test123@gmail.com");
        member.setMemberPassword("1234");
        member.setMemberName("홍길동");
        member.setMemberAge(17);
        member.setMemberGender(MemberGender.MALE);

//        (영속)
        entityManager.persist(member);

        Member foundMember = entityManager.find(Member.class, member.getId());
        log.info("result: {}", member == foundMember);

    }

    //    마지막 회원가입한 유저를 조회 후 log에 출력하기
    @Test
    public void memberSelectTest(){
        Member foundMember = entityManager.find(Member.class, 102);
        foundMember.setMemberAge(100);
        log.info("result: {}", foundMember.toString());
    }

    @Test
    public void memberDeleteTest(){
        Member foundMember = entityManager.find(Member.class, 102);
        entityManager.remove(foundMember);
        log.info("result: {}", foundMember.toString());
    }

    @Test
    public void memberMergeTest(){
//        영속 상태 -> 준영속 상태
//        entityManager.flush(); entityManager.detach();
//        준영속 상태 -> 영속 상태
//        entityManager.merge();

//        (영속)
        Member foundMember = entityManager.find(Member.class, 2L);
//        (준영속)
        entityManager.detach(foundMember);
        foundMember.setMemberName("고길동");
//        (영속)
        entityManager.merge(foundMember);
        foundMember.setMemberName("도우너");

    }

}






