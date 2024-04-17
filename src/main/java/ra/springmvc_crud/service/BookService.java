package ra.springmvc_crud.service;

import ra.springmvc_crud.model.Books;

import java.util.List;

public interface BookService {
    List<Books> findAll();

    boolean save(Books book);
}
