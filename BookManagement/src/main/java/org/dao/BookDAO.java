package org.dao;

import java.util.ArrayList;
import java.util.List;

import org.entities.Book;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;

public class BookDAO {
	protected SessionFactory sessionFactory;
	
	protected void setup() {
		// code to load Hibernate Session factory
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			System.out.println("111111111");
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			System.out.println("22222222222");
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	protected void exit() {
		sessionFactory.close();
	}

	protected void create() {
		Book book = new Book();
		book.setTitle("Effective Python");
		book.setAuthor("Joshua Bloch");
		book.setPrice(32.59f);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(book);

		session.getTransaction().commit();
		session.close();
	}
	protected void getall() {
		Session session = sessionFactory.openSession();
		List<Book> listStudent = new ArrayList<Book>();
		session.getTransaction().begin();
		String sql = "Select e from Book e";
		Query query = session.createQuery(sql);
		listStudent = query.list();
		session.getTransaction().commit();
		for(Book book: listStudent) {
			System.out.println(book);
		}
		session.close();
	}
	protected void read() {
		Session session = sessionFactory.openSession();

		int bookId = 1;
		Book book = session.get(Book.class, bookId);

		System.out.println("Title: " + book.getTitle());
		System.out.println("Author: " + book.getAuthor());
		System.out.println("Price: " + book.getPrice());

		session.close();
	}

	protected void update() {
		Book book = new Book();
		book.setIdBook(20);
		book.setTitle("Ultimate Java Programming");
		book.setAuthor("Nam Ha Minh");
		book.setPrice(19.99f);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(book);

		session.getTransaction().commit();
		session.close();
	}

	protected void delete() {
		Book book = new Book();
		book.setIdBook(20);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(book);

		session.getTransaction().commit();
		session.close();
	}

	public static void main(String[] args) {
		BookDAO manager = new BookDAO();
		manager.setup();
		manager.read();
		manager.exit();
	}
}
