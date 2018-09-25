package top.zhaohaoren.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zhaohaoren.springboot.AuthorSettings;

@RestController
public class AuthorController {

    @Autowired
    AuthorSettings authorSettings;

    @RequestMapping("/showAuthor")
    public AuthorSettings showAuthor() {
        return authorSettings;
    }
}
