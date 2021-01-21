package com.liubaobaospringboot.springboottest.repository;

import com.liubaobaospringboot.springboottest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**具有映射后，创建接口，继承JpaRepository*/
/**JpaRepository里面的泛型第一个是实体类的类型，第二个是主键的类型*/
public interface BookRepository extends JpaRepository<Book,Integer> {

}
