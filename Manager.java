import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager {
    private Scene scene;

    public Manager(Scene scene) {
        this.scene = scene;
    }
    void showMainScreen()
    {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("sample.fxml")
            );
            scene.setRoot(loader.load());
            MainController controller =
                    loader.getController();
            controller.initialize(this);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void showViewScreen()
    {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("viewb.fxml")
            );
            scene.setRoot(loader.load());
            System.out.println("loaded");
            ViewController controller =
                    loader.getController();
            controller.initialize(this);
        } catch (IOException ex) {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
