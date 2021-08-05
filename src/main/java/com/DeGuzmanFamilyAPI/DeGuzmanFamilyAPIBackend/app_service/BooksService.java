package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Books;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.BooksRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.BooksInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.BookNameException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;

@Service
public class BooksService implements BooksInterface {

	@Autowired
	BooksRepository booksRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BooksService.class);

	@Override
	public List<Books> findAllBooksInformation() {
		List<Books> list = booksRepository.findAll();

		if (list.size() == 0 || list.isEmpty()) {
			LOGGER.warn("Books list is empty: " + list.size());
		}

		return booksRepository.findAll();
	}

	public boolean checkBookNanes(String name) {
		
		List<Books> bookList = booksRepository.findAll();
		List<String> namesList;
		boolean result = false;
		
		namesList = bookList.stream().map(Books::getName).collect(Collectors.toList());
		
		if (namesList.contains(name) ) {
			result = true;
		}
		
		return result;
	}
	
//	public ResponseEntity<Map<String, Object>> getAllTutorialsPage(
//			@RequestParam(required = false) String name,
//			@RequestParam(defaultValue = "0") int page, 
//			@RequestParam(defaultValue = "3") int size) {
//
//		try {
//			
//			List<Books> books = booksRepository.findAll();
//			
//			Pageable paging = PageRequest.of(page, size);
//			
//			System.out.println(paging);
//			
//			Page<Books> pageBooks;
//			
//			if (name == null) {
//				pageBooks = booksRepository.findAll(paging);
//			} 			
//			else {
//				pageBooks = booksRepository.findByNameContaining(name,paging);
//			}
//			
////			pageBooks = booksRepository.findAll(paging);
//			
//			System.out.println(pageBooks);
//			
//			books = pageBooks.getContent();
//			
//			System.out.println(books + "this is books");
//			
//			Map<String,Object> response = new HashMap<>();
//			response.put("books", books);
//			response.put("currentPage",pageBooks.getNumber());
//			response.put("totalItems",pageBooks.getTotalElements());
//			response.put("totalPages", pageBooks.getTotalPages());
//			
//			return new ResponseEntity<>(response,HttpStatus.OK);
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@Override
	public ResponseEntity<Books> findBooksInformationById(@PathVariable int book_id) throws ResourceNotFoundException {

		Books books = null;

		if (book_id <= 0) {
			LOGGER.warn("Invalid Book ID Number");
		} else {
			books = booksRepository.findById(book_id)
					.orElseThrow(() -> new ResourceNotFoundException("Cannot find Book with ID Number: " + book_id));
			LOGGER.info("Retrieved Book information for ID Number: " + book_id);
		}

		return ResponseEntity.ok().body(books);
	}

	@Override
	public ResponseEntity<Books> findBookInformationByName(@PathVariable String name) {

		Books books = null;

		if (name == null || name == "") {
			LOGGER.warn("Name cannot be nulll");
		} else {
			books = booksRepository.findBookByName(name);
			LOGGER.info(name + " was found");
		}

		return ResponseEntity.ok().body(books);
	}

	@Override
	public Books addBooksInformation(@Valid @RequestBody Books book) throws BookNameException {
		
		if (checkBookNanes(book.getName())) {
			throw new BookNameException("Book Already Exists");
		}
		
		if (book.author == "" || book.author == null) {
			LOGGER.warn("Author is null");
		} else if (book.name == "" || book.name == null) {
			LOGGER.warn("Name is null");
		} else {
			LOGGER.info(book.name + " " + "has been added!");
		}
		return booksRepository.save(book);
	}

	@Override
	public ResponseEntity<Books> updateBooksInformation(int book_id, @Valid @RequestBody Books bookDetails) {
		Books book = null;
		try {
			book = booksRepository.findById(book_id)
					.orElseThrow(() -> new ResourceNotFoundException("Book information"));
			book.setAuthor(bookDetails.getAuthor());
			book.setName(bookDetails.getName());

		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}

		final Books updatedBookDetails = booksRepository.save(bookDetails);
		LOGGER.info(updatedBookDetails.name + " " + "has been added");
		return ResponseEntity.ok().body(updatedBookDetails);
	}

	@Override
	public Map<Boolean, String> deleteBookInformation(int book_id) {

		Map<Boolean, String> response = null;

		if (book_id <= 0) {
			LOGGER.warn("Book ID number is invalid");
		} else {
			LOGGER.info("Book has been deleted with ID " + book_id);
			booksRepository.deleteById(book_id);
			response = new HashMap<Boolean, String>();
			response.put(Boolean.TRUE, "Deleted");
		}
		return response;
	}

	@Override
	public Map<Boolean, String> deleteAllBookInformation() {

		List<Books> list = booksRepository.findAll();

		Map<Boolean, String> response = new HashMap<>();

		booksRepository.deleteAll();

		if (list.size() == 0 || list.isEmpty()) {
			response.put(Boolean.TRUE, "All Books Information has been deleted");
			LOGGER.info("All books have been deleted");
		}

		return response;
	}

	@Override
	public long getBookCount() {
		return booksRepository.count();
	}

}
