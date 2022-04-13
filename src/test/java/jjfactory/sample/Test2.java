package jjfactory.sample;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class Test2 {

    private final SampleRepository sampleRepository;

    @Test
    @Transactional
    void transactionTest(){
    }
}
