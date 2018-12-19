package com.neo.web;

import com.neo.entity.Author;
import com.neo.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private String PREFIX = "/author/";
    @Autowired
    private AuthorService authorService;


    @RequestMapping("/list")
    public String list(Model model) {
        logger.info("begin to run AuthorController list...");
        List<Author> authors = authorService.getList();
        model.addAttribute("authors", authors);
        return PREFIX + "list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        logger.info("toAdd ....");
        return PREFIX + "add";
    }

    @RequestMapping("/add")
    public String add(Author author) {
        authorService.save(author);
        return "redirect:" + PREFIX + "list";
//        return PREFIX + "list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        Author author=authorService.findById(id);
        model.addAttribute("author", author);
        return PREFIX + "edit";
    }

    @RequestMapping("/edit")
    public String edit(Author author) {
        authorService.edit(author);
        return "redirect:" + PREFIX + "list";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        authorService.delete(id);
        return "redirect:" + PREFIX + "list";
    }
}
