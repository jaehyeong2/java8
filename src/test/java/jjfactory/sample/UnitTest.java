package jjfactory.sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

public class UnitTest {

    private final String EXPECT_NAME = "lee";

    @Test
    @Disabled
    void generateName(){
        Unit unit = new Unit();
        String name = unit.getName();
        Assertions.assertNull(name);
    }

    @Test
    @DisplayName("이름 변경 테스트")
    void changeName(){
        Unit unit = new Unit();
        unit.changeName("lee");
        Assertions.assertEquals(EXPECT_NAME,unit.getName());
    }

    @Test
    void treeSet(){
        Set set = new TreeSet();
        set.add("첫번째");
        set.add("두번째");
        set.add("세번째");
    }
}
