package com.liubaobaospringboot.springboottest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {

    /**BookRepository自动输入*/
    @Autowired
    private BookRepository bookRepository;

    /**测试一个方法*/
    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());
    }
}