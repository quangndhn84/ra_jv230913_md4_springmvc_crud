package ra.springmvc_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
