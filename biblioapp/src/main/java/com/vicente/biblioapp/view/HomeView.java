package com.vicente.biblioapp.view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class HomeView {
    public Scene homeScene() {

        UserDataView user_data = new UserDataView();

        VBox box_user_data = user_data.userData();

        Scene home_scene = new Scene(box_user_data, 600, 300);

        return home_scene;
    }
}
