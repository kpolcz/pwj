import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {



    @FXML
    private TextField nameF;

    @FXML
    private TextField idF;

    @FXML
    private TextField startF;

    @FXML
    private TextField finF;

    @FXML
    private TextField dateF;

    @FXML
    private Button loginButton;

    @FXML
    private Button startServer;

    @FXML
    private Button showRooms;
    private Scene scene;


    void sendData(){
        DBserver dbs=new DBserver();
        new Thread(dbs).start();
        DBCon dbc=new DBCon();
       int id= Integer.parseInt(idF.getText());
       String  name=nameF.getText();
       String start=startF.getText();
       String fin=finF.getText();
       String date=dateF.getText();
       String busyFrom=date+" "+start;
       String busyUntil=date+" "+fin;
       dbc.BookRoom(id,busyFrom,busyUntil,name);

    }
    Manager manager=null;
    void initialize(Manager manager)
    {
        this.manager=manager;

        //startServer.setOnAction(event -> new Thread(dbs).start());
        loginButton.setOnAction(event -> sendData());
        showRooms.setOnAction(event -> manager.showViewScreen());
    }

}
