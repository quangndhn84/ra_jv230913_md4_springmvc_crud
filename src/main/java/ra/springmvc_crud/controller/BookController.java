package ra.springmvc_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.springmvc_crud.model.Books;
import ra.springmvc_crud.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/bookController")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/getAll")
    public ModelAndView getAllBooks() {
        ModelAndView mav = new ModelAndView("books");
        List<Books> listBooks = bookService.findAll();
        mav.addObject("listBooks", listBooks);
        return mav;
    }

    @GetMapping("initCreate")
    public String initCreate(ModelMap modelMap) {
        //1. Khởi tạo đối tượng sách để map với form nhập liệu
        Books bookNew = new Books();
        //2. add vào modelMap
        modelMap.addAttribute("bookNew", bookNew);
        return "newBook";
    }

    @PostMapping("/create")
//    public String create(@ModelAttribute("bookNew") Books book){
//
//    }
    public String create(Books bookNew) {
        boolean result = bookService.save(bookNew);
        if (result) {
            return "redirect:getAll";
        }
        return "error";
    }

    @GetMapping("/initUpdate")
//    public String initUpdate(@RequestParam("bookId") int bookIdUpdate){
    public String initUpdate(ModelMap modelMap, @RequestParam("bookId") int bookId) {
        Books bookUpdate = bookService.getBookById(bookId);
        modelMap.addAttribute("bookUpdate", bookUpdate);
        return "updateBook";
    }

    @PostMapping("/update")
    public String updateBook(Books updateBook) {
        boolean result = bookService.update(updateBook);
        if (result) {
            return "redirect:getAll";
        }
        return "error";
    }

    @GetMapping("/delete")
    public String deleteBook(int bookId) {
        boolean result = bookService.delete(bookId);
        if (result) {
            return "redirect:getAll";
        }
        return "error";
    }

}
