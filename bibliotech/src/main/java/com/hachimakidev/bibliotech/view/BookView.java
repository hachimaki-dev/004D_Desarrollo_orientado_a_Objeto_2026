package com.hachimakidev.bibliotech.view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class BookView {

    public Scene bookscene(){
        FindBook fnd_book = new FindBook();

        VBox box_book_data = fnd_book.bookData();

        Scene book_scene = new Scene(box_book_data, 600, 500);

        return book_scene;

    }
    
}
