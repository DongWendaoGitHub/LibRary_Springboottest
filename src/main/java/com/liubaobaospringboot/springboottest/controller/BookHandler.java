package com.liubaobaospringboot.springboottest.controller;

import com.liubaobaospringboot.springboottest.entity.Book;
import com.liubaobaospringboot.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {

    @Autowired
    private BookRepository bookRepository;

    /*提供一个方法  findAll 是查询所有的图书*/
   /* @GetMapping("/findAll")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }*/
   /*按照页面去查询*/
    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return bookRepository.findAll(pageable);
    }

    /*增加   post*/
    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result != null){
            return "创建成功";
        }else{
            return "创建失败";
        }
    }

    /*董文道*/
    /*寻找id*/
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }
}
