package jp.te4a.spring.boot.myapp6.mybootapp6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public BookForm save(BookForm bookForm) {
      BookBean bookBean = new BookBean();
      BeanUtils.copyProperties(bookForm, bookBean);
      bookRepository.save(bookBean);
      return bookForm;
    }
    

    public BookForm update(BookForm bookForm) {
      BookBean bookBean = new BookBean();
      BeanUtils.copyProperties(bookForm, bookBean);
      bookRepository.save(bookBean);
      return bookForm;
    }
  public void delete(Integer id) {
        BookBean bookBean = new BookBean();
        bookBean.setId(id);
      bookRepository.delete(bookBean);
    }
  public List<BookForm> findAll() {
    List<BookBean> beanList = bookRepository.findAll();
    List<BookForm> formList = new ArrayList<BookForm>();
    for(BookBean bookBean: beanList) {
      BookForm bookForm = new BookForm();
      BeanUtils.copyProperties(bookBean, bookForm);
      formList.add(bookForm);
    }
    return formList;
    }

  public BookForm findOne(Integer id) {
    BookBean bookBean = new BookBean();
    Optional<BookBean> opt = bookRepository.findById(id);
     opt.ifPresent(book -> {
        BeanUtils.copyProperties(book, bookBean);
    });
    

    BookForm bookForm = new BookForm();
    BeanUtils.copyProperties(bookBean, bookForm);
    return bookForm;
  }
}
