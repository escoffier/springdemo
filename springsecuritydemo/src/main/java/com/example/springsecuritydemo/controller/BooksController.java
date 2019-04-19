package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.model.Book;
import com.example.springsecuritydemo.model.Reader;
import com.example.springsecuritydemo.repository.BooksRepository;
import com.example.springsecuritydemo.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
//@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/books/{reader}", method = RequestMethod.GET)
    public String getBooks(@PathVariable("reader") String reader,
                           Model model) {
        List<Book> bookList = booksRepository.findByReader(reader);
        if (bookList != null) {
            model.addAttribute("books", bookList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String addToReadingList(@ModelAttribute Book book) {
        //book.setReader(reader);
        booksRepository.save(book);
        return "result";
    }


    @RequestMapping(value = "/readers/{username}", method = RequestMethod.GET)
    public String getReader(@PathVariable String username, Model model) {
        Reader r = readerRepository.findByUsername(username);

        if (r != null) {
            model.addAttribute("reader", r);
        }

        return "readerResult";
    }

    @RequestMapping(value = "/readers", method = RequestMethod.POST)
    public String addReader(@ModelAttribute Reader reader) {

        reader.setPassword(passwordEncoder.encode(reader.getPassword()));
        readerRepository.save(reader);
        return "readerResult";
    }

    @RequestMapping(value = "/readers/creating", method = RequestMethod.GET)
    public String getReader() {
//        Reader r = readerRepository.findByUsername(username);
//
//        if (r != null) {
//            model.addAttribute("reader" , r);
//        }

        return "addreader";
    }

}
