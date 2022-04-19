package jjfactory.jdbc.repository;

import jjfactory.jdbc.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;


/**
 * JDBC - datasource 이용
 */
@Slf4j
@RequiredArgsConstructor
public class MemberRepositoryV2 {

    private final DataSource dataSource;

    // 등록
    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id,money) VALUES (? , ?) ";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2,member.getMoney());
            pstmt.executeUpdate();
            return member;
        }catch (SQLException e){
            log.error("db error", e);
            throw e;
        }finally {
            close(con,pstmt,null);
        }
    }

    // 조회
    public Member findById(String memberId) throws SQLException {
        String sql = "select * from member where member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1,memberId);

            rs = pstmt.executeQuery();
            if (rs.next()){
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            } else{
                throw new NoSuchElementException("member not found memberId : " + memberId);
            }

        }catch (SQLException e){
            log.error("db error",e);
            throw e;
        }finally {
            close(con,pstmt,rs);
        }
    }

    //삭제
    public void delete(String memberId) throws SQLException {
        String sql = "delete from member where member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1,memberId);
            pstmt.executeUpdate();

        }catch (SQLException e){
            log.error("db error",e);
            throw e;
        }finally {
            close(con,pstmt,null);
        }
    }

    // 업데이트
    public void update(String memberId, int money) throws SQLException {
        String sql = "update member set money =? where member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1,money);
            pstmt.setString(2,memberId);
            int resultSize = pstmt.executeUpdate();
            log.info("resultSize = {}",resultSize);

        }catch (SQLException e){
            log.error("db error",e);
            throw e;
        }finally {
            close(con,pstmt,null);
        }
    }


    private Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.info("get connection = {}, class = {}",connection,connection.getClass());
        return connection;
    }

    // 연결 해제용
    private void close(Connection con, Statement stmt, ResultSet rs) throws SQLException {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        JdbcUtils.closeConnection(con);
    }
}
