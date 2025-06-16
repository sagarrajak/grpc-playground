package com.grpc_playground.grcp_playgroud.sec03;

import com.grpc_playground.grcp_playgroud.model.sec03.Book;
import com.grpc_playground.grcp_playgroud.model.sec03.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class Lec05Collections {
    private static final Logger logger = LoggerFactory.getLogger(Lec05Collections.class);



    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        String[] titles = {
                "The Silent Ocean", "Echoes of Tomorrow", "Crimson Dawn",
                "Whispers in the Dark", "Beyond the Horizon", "Digital Dreams",
                "Forgotten Legacy", "Embers of Eternity", "Neon Nexus",
                "The Last Sanctuary"
        };

        String[] authors = {
                "Alex Morgan", "Taylor Reed", "Jordan Casey",
                "Riley Parker", "Morgan Chase", "Casey Quinn",
                "Jamie Blake", "Drew Cameron", "Skyler James",
                "Taylor Morgan"
        };
        for (int i = 0; i < 10; i++) {
            var book = Book.newBuilder().setAuthor(authors[i])
                    .setTitle(titles[i])
                    .build();
            books.add(book);
        }
        var library  = Library.newBuilder()
                .setName("Java Library")
                .addAllBooks(books)
                .build();
        logger.info("all book\n {}", library.toString());
    }
}
