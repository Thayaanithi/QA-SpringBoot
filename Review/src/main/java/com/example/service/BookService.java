package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.repo.BookRepo;

@Service
public class BookService {
private BookRepo repo;

public BookService(BookRepo repo) {
	super();
	this.repo=repo;
}

public Book addBook(Book b1) {
	return this.repo.save(b1);
}
public List<Book> readBook(){
	return this.repo.findAll();
}
	public Book updateBook(int id,Book b2) {
		Optional<Book> myTempBook=this.repo.findById(id);
		Book existing=myTempBook.get();
		existing.setId(b2.getId());
		existing.settitle(b2.gettitle());
		existing.setPrice(b2.getPrice());
		existing.setAuthor(b2.getAuthor());
		return this.repo.save(existing);
	}
		public boolean deleteBook(int id) {
			this.repo.deleteById(id);
			boolean exists=this.repo.existsById(id);
			return !exists;
	}
}

