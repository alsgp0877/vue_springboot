package com.folder.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.folder.app.Application;
import com.folder.app.mapper.UserMapper;

@SpringBootTest(classes = Application.class)
class TestApplicationTests {
    @Autowired UserMapper um;
	@Test
    @DisplayName("DataBase 접속 테스트")
	void contextLoads() {
        int result = um.test();
        assertEquals(0, result);

	}
}
