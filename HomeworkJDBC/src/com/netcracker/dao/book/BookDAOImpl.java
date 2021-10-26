package com.netcracker.dao.book;


import com.netcracker.dao.BasicDAO;
import com.netcracker.model.Book;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository("bookDAO")
@Transactional
public class BookDAOImpl extends BasicDAO implements IBookDAO {
    @Override
    public void saveBook(Book entity) {
        persist(entity);
    }

    @Override
    public List<Book> findAllBooks() {
        Criteria criteria = getSession().createCriteria(Book.class);
        return criteria.list();
    }

    @Override
    public Book findBookById(int id) {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.add(Restrictions.eq("id", id));
        return (Book)criteria.uniqueResult();
    }

    @Override
    public void deleteBookById(int id) {
        Query query = getSession().createQuery("delete from Book where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public long countRow() {
        Criteria criteria = getSession().createCriteria(Book.class);
        Object res = criteria.setProjection(Projections.rowCount()).uniqueResult();
        return Long.parseLong(res.toString());
    }

    @Override
    public List getBooksByTitlePrice() {  //task 2b
        Criteria criteria = getSession().createCriteria(Book.class);
        Criterion titleBook = Restrictions.like("title", "%Window%");
        Criterion priceBook = Restrictions.gt("price", 20000);

        criteria.add(Restrictions.or(titleBook, priceBook));
        return criteria.list();
    }

    @Override
    public List getBooksByDistrictQtyMore10() {  //task 5d
        SQLQuery query = getSession().createSQLQuery("select book.title, book.storehouse, book.qty, book.price" +
                "from purchase, shop, book" +
                "where purchase.book_id = book.book_id and purchase.shop_id = shop.book_id and" +
                "book.storehouse = shop.district and" +
                "book.qty > 10" +
                "order by book.price");
        return query.list();
    }


}
