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

    @Autowired
    private AuthorService authorService;


    @RequestMapping("/list")
    public String list(Model model) {
        logger.info("begin to run AuthorController list...");
        List<Author> authors = authorService.getList();
        model.addAttribute("templates/author", authors);
        return "author/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "author/toAdd";
    }

    @RequestMapping("/add")
    public String add(Author author) {
        authorService.save(author);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        Author author=authorService.findById(id);
        model.addAttribute("templates/author", author);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(Author author) {
        authorService.edit(author);
        return "redirect:/list";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        authorService.delete(id);
        return "redirect:/list";
    }
}
