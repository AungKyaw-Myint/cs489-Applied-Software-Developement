package com.cs489.LibrarySystem;

import com.cs489.LibrarySystem.dto.request.AddressRequestDto;
import com.cs489.LibrarySystem.dto.request.AuthorRequestDto;
import com.cs489.LibrarySystem.dto.request.BookRequestDto;
import com.cs489.LibrarySystem.dto.request.PublisherRequestDto;
import com.cs489.LibrarySystem.service.BookService;
import com.cs489.LibrarySystem.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LibrarySystemApplication {

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystemApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			//Create PublisherRequestDto
			PublisherRequestDto publisherRequestDto = new PublisherRequestDto(
					"Apress",
					new AddressRequestDto(
							"1A",
							"LLC One New York Plaza",
							"New York",
							"NY",
							1562
					)
			);
			System.out.println(publisherService.createPublisher(publisherRequestDto));
//			System.out.println("Find by name: " + publisherService.findPublisherByName("Apress"));
//			System.out.println(publisherService.findAllPublishers());

			BookRequestDto bookRequestDto = new BookRequestDto(
					"Flutter in Action",
					"9781617296147",
					new PublisherRequestDto(
							"Manning",
							new AddressRequestDto(
									"2A",
									"2000 N",
									"Fairfield",
									"IA",
									52556
							)
					),
					List.of(
							new AuthorRequestDto("Eric", "Windmill")
						   )

			);
			System.out.println("Saved new book: " + bookService.createBook(bookRequestDto));
			System.out.println("Found book: " + bookService.findBookByIsbn("9781617296147"));
			System.out.println("All books: " + bookService.findAllBooks());
		};
	}

}
