package com.example.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.binding.BookBinding;
import com.example.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/addbook")
	public ResponseEntity<String> getBookData(@RequestBody BookBinding binding) {
          boolean bookData = bookService.getBookData(binding);
          if(bookData) {
        	  String msg="Book saved..!";
        	  return new ResponseEntity<String>(msg,HttpStatus.OK);
          }
          else {
			String msg2="Book not saved..!";
			return new ResponseEntity<String>(msg2,HttpStatus.BAD_REQUEST);
		}
         
		
	}

}
