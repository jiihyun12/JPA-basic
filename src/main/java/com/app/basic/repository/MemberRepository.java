package com.app.basic.repository;

import com.app.basic.domain.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // 데이터 추가
    public void save(Member member) {
        entityManager.persist(member);
    }

    // 1개 유저 조회
    public List<Member> findAll() {
        return entityManager.createQuery("SELECT m FROM Member m").getResultList();
    }

    // update - 변경 감지(더티 체크)
    public void findById(int id) {
        Member member = entityManager.find(Member.class, id);
    }


    // 삭제
    public void delete(Member member) {
        entityManager.remove(member);
    }


}
