package com.hachimakidev.techstore.view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class HomeView {

    public Scene homeScene() {
        CatalogoView catalogo_view = new CatalogoView();
        VBox box_catalogo = catalogo_view.catalogo();

        Scene home_scene = new Scene(box_catalogo, 1080, 720);
        return home_scene;
    }
}

