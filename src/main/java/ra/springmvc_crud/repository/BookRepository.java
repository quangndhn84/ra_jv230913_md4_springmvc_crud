package ra.springmvc_crud.repository;

import ra.springmvc_crud.model.Books;

import java.util.List;

public interface BookRepository {
    List<Books> findAll();

    boolean save(Books book);
}
