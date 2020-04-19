package com.raven.cloud.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring JUnit测试
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJUnitTest {

    @Before
    public void before() throws Exception {
        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 开始测试 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    @Test
    public void test() {
        log.debug("Hello World By Kotlin Spring JUnit Test !!!");
    }

    @After
    public void after() {
        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 测试结束 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
