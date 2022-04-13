package jjfactory.sample;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@RequiredArgsConstructor
public class saveTest {

    private final SampleRepository sampleRepository;

    private static Unit unitA = new Unit("a","123");
    private static Unit unitB = new Unit("a","123");

    @Test
    void sameTest(){
        sampleRepository.save(unitA);
        sampleRepository.save(unitB);

        List<Unit> all = sampleRepository.findAll();
        for( int i = 0;i<all.size(); i++){
            Unit unit = all.get(i);
            System.out.println(unit);
        }
    }

}
