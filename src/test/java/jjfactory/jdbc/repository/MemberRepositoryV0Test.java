package jjfactory.jdbc.repository;

import jjfactory.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    void saveAndUpdateTest() throws SQLException {
        Member member = new Member("member8",2000);
        repository.save(member);

        repository.update(member.getMemberId(),5000);
        Member findMem = repository.findById(member.getMemberId());

        assertEquals(5000,findMem.getMoney());

        repository.delete(member.getMemberId());
        org.assertj.core.api.Assertions.assertThatThrownBy(() ->
                repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void findById() throws SQLException {
        Member member = new Member("member4",400000);
        repository.save(member);

        Member findMember = repository.findById(member.getMemberId());
        log.info("find member ={}",findMember);

        assertEquals("member4",findMember.getMemberId());
    }

}