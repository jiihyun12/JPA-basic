package com.app.basic.repository;

import com.app.basic.domain.entity.Member;
import com.app.basic.domain.type.MemberGender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
@Commit
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void memberSaveTest() {
        Member member = new Member();

        member.setMemberEmail("test1234@gmail.com");
        member.setMemberPassword("1234");
        member.setMemberName("홍길동");
        member.setMemberAge(17);
        member.setMemberGender(MemberGender.MALE);
    }
//}
//
////    @Test
//    public void memberUpdateTest() {
//        Optional<Member> updateMember = memberRepository.findById(252L);
//
//        updateMember.ifPresent((member) -> {
//            member.setMemberName("홍길길");
////            memberRepository.save(member);
//        });
//    }
//
//    // 수정
//    @Test
//    public void memberUpdateTest() {
//        Optional<Member> optionalMember = memberRepository.findById(252L);
//        optionalMember.ifPresent(member -> {
//            member.setMemberName("홍길길");
//            memberRepository.save(member); // save로 병합
//            log.info("Updated Member: {}", member);
//        });
//    }
//
//    // 조회
//    @Test
//    public void findMemberTest() {
//        Optional<Member> optionalMember = memberRepository.findById(252L);
//        optionalMember.ifPresentOrElse(
//                member -> log.info("조회된 회원: {}", member),
//        );
//    }
//
//    // 삭제
//    @Test
//    public void deleteMemberTest() {
//        Long id = 252L;
//            memberRepository.delete(id);
//            log.info("삭제 완료: ID = {}", id);
//        }
//    }
//
//
//
//
//
