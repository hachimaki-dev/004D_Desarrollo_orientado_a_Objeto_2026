package com.hachimakidev.bibliotech;

import com.hachimakidev.bibliotech.view.HomeView;
import com.hachimakidev.bibliotech.view.BookView;
import javafx.application.Application;
import javafx.stage.Stage;

public class BiblioTechApp extends Application {
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        HomeView home_view = new HomeView();
        stage.setTitle("BiblioTech");
        stage.setScene(home_view.homeScene(this::mostrarLibros));
        stage.show();


    }

        public void mostrarLibros() {
        BookView book_view = new BookView();

        stage.setScene(book_view.bookscene());
    }




    public static void main(String[] args) {
        launch(args);
    }
    
}
