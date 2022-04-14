package jjfactory.connection;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class DBConnectionUtil {

    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jav?serverTimezone=Asia/Seoul",
                    "jae", "1234");
            log.info("get connection = {} , class = {}",connection,connection.getClass());
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
