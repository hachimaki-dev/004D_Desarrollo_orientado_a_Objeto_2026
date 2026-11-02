package com.hachimakidev.musicstore.view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class HomeView {

    public Scene homeScene() {
        CatalogoView catalogo_view = new CatalogoView();
        VBox box_catalogo = catalogo_view.catalogo();

        Scene home_scene = new Scene(box_catalogo, 820, 560);
        return home_scene;
    }
}

