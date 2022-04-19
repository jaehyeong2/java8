package jjfactory.jdbc.service;

import jjfactory.jdbc.domain.Member;
import jjfactory.jdbc.repository.MemberRepositoryV1;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;

import static jjfactory.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceV1Test {

    private final String MEMBER_A = "memberA";
    private final String MEMBER_B = "memberB";
    private final String MEMBER_EX = "ex";

    private MemberRepositoryV1 memberRepository;
    private MemberServiceV1 memberService;

    @BeforeEach
    void beforeEach(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        memberRepository = new MemberRepositoryV1(dataSource);
        memberService = new MemberServiceV1(memberRepository);
    }

    @AfterEach
    void after() throws SQLException {
        memberRepository.delete(MEMBER_A);
        memberRepository.delete(MEMBER_EX);
    }

    @Test
    @DisplayName("정상 이체")
    void accountTransfer() throws SQLException {
        //given
        Member memberA = new Member(MEMBER_A, 10000);
        Member memberB = new Member(MEMBER_B, 10000);
        memberRepository.save(memberA);
        memberRepository.save(memberB);

        //when
        memberService.accountTransfer(memberA.getMemberId(),memberB.getMemberId(),2000);

        //then
        Member findA = memberRepository.findById(memberA.getMemberId());
        Member findB = memberRepository.findById(memberB.getMemberId());
        assertThat(findA.getMoney()).isEqualTo(8000);
        assertThat(findB.getMoney()).isEqualTo(12000);
    }

    @Test
    @DisplayName("이체중 예외발생")
    void accountTransferEX() throws SQLException {
        //given
        Member memberA = new Member(MEMBER_A, 10000);
        Member memberEX = new Member(MEMBER_EX, 10000);
        memberRepository.save(memberA);
        memberRepository.save(memberEX);

        //when
        assertThatThrownBy(() -> memberService.accountTransfer(memberA.getMemberId(),memberEX.getMemberId(),2000))
                .isInstanceOf(IllegalStateException.class);

        //then
        Member findA = memberRepository.findById(memberA.getMemberId());
        Member findB = memberRepository.findById(memberEX.getMemberId());
        assertThat(findA.getMoney()).isEqualTo(8000);
        assertThat(findB.getMoney()).isEqualTo(10000);
    }

}