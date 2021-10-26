package com.netcracker;

import com.netcracker.config.SpringConfig;
import com.netcracker.model.Book;
import com.netcracker.service.IBookService;
import com.netcracker.service.ICustomerService;
import com.netcracker.service.IPurchaseService;
import com.netcracker.service.IShopService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        IBookService bookService = (IBookService)context.getBean("bookService");
        ICustomerService customerService = (ICustomerService)context.getBean("customerService");
        IPurchaseService purchaseService = (IPurchaseService)context.getBean("purchaseService");
        IShopService shopService = (IShopService)context.getBean("shopService");

        System.out.println(bookService.findAllBooks());
        bookService.saveBook(new Book("Anna Karenina", 450, "Dirizhabl", 3));
        bookService.countRow();

        System.out.println(customerService.findAllCustomers());

        System.out.println(purchaseService.findAllPurchases());

        System.out.println(shopService.findAllShops());




    }
}
