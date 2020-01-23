import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application{

    @Override public void start(Stage stage) throws IOException, SQLException {
        Scene scene = new Scene(new StackPane());

        Manager mng=new Manager(scene);
        mng.showMainScreen();
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
launch(args);

//        DBCon dbc=new DBCon();
//        DBserver dbs=new DBserver();
//        new Thread(dbs).start();
//        System.out.println("werks");
//        dbc.getBookings();
//        System.out.println("fin");
    }
}
