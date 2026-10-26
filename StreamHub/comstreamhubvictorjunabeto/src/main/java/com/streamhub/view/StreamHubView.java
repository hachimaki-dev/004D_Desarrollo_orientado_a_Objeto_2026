package com.streamhub.view;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;




public class StreamHubView {
    
    public Scene streamHubScene(){
        UserDataView user_data = new UserDataView();

        VBox v_data = user_data.userData();
        Scene streamhub_Scene = new Scene(v_data, 800, 400);
        return streamhub_Scene;








        
        
    } 


    
}
