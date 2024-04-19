package ra.springmvc_crud.repositoryImp;

import org.springframework.stereotype.Repository;
import ra.springmvc_crud.model.Books;
import ra.springmvc_crud.repository.BookRepository;
import ra.springmvc_crud.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImp implements BookRepository {
    @Override
    public List<Books> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Books> listBooks = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_book()}");
            ResultSet rs = callSt.executeQuery();
            listBooks = new ArrayList<>();
            while (rs.next()) {
                Books book = new Books();
                book.setBookId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setPrice(rs.getFloat("price"));
                book.setStatus(rs.getBoolean("book_status"));
                listBooks.add(book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listBooks;
    }

    @Override
    public boolean save(Books book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call insert_book(?,?,?)}");
            callSt.setString(1, book.getBookName());
            callSt.setFloat(2, book.getPrice());
            callSt.setBoolean(3, book.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public Books getBookById(int bookId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Books book = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_book_by_id(?)}");
            callSt.setInt(1, bookId);
            ResultSet rs = callSt.executeQuery();
            book = new Books();
            if (rs.next()) {
                book.setBookId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setPrice(rs.getFloat("price"));
                book.setStatus(rs.getBoolean("book_status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return book;
    }

    @Override
    public boolean update(Books book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_book(?,?,?,?)}");
            callSt.setInt(1, book.getBookId());
            callSt.setString(2, book.getBookName());
            callSt.setFloat(3, book.getPrice());
            callSt.setBoolean(4, book.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(int bookId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_book(?)}");
            callSt.setInt(1, bookId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
