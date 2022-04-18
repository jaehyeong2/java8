package jjfactory.jdbc.repository;

import com.zaxxer.hikari.HikariDataSource;
import jjfactory.jdbc.connection.ConnectionConst;
import jjfactory.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static jjfactory.jdbc.connection.ConnectionConst.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 repository;

    @BeforeEach
    void beforeEach(){
        //기본 DriverManager - 항상 새로운 커넥션 획득
//        DriverManagerDataSource  dataSource = new DriverManagerDataSource(URL,USERNAME,PASSWORD);
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        repository = new MemberRepositoryV1(dataSource);
        log.info("before each ============================================");
    }

    @Test
    void saveAndUpdateTest() throws SQLException, InterruptedException {
        Member member = new Member("member8",2000);
        repository.save(member);

        repository.update(member.getMemberId(),5000);
        Member findMem = repository.findById(member.getMemberId());

        assertEquals(5000,findMem.getMoney());

        repository.delete(member.getMemberId());
        org.assertj.core.api.Assertions.assertThatThrownBy(() ->
                repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);

        Thread.sleep(1000);
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