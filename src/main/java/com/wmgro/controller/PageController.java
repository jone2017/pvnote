package com.wmgro.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 跳转到静态页面
 */
@Slf4j
@RequestMapping("page")
@Controller
public class PageController {

    @GetMapping("/{url}")
    public String pageUrl(@PathVariable String url){
        log.info("用户点击页面"+url);
        return url;
    }
}
