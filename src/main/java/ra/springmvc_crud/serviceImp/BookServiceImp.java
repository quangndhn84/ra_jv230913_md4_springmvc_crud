package ra.springmvc_crud.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.springmvc_crud.model.Books;
import ra.springmvc_crud.repository.BookRepository;
import ra.springmvc_crud.service.BookService;

import java.util.List;

@Service
public class BookServiceImp  implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Books> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public boolean save(Books book) {
        return bookRepository.save(book);
    }
}
