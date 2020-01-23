import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Vector;

public class ViewController {

    @FXML
    private Label idF1;

    @FXML
    private Label idF2;

    @FXML
    private Label idF3;

    @FXML
    private Label idF4;

    @FXML
    private Label bfrom3;

    @FXML
    private Label bfrom2;

    @FXML
    private Label bfrom1;

    @FXML
    private Label bfrom4;

    @FXML
    private Label buntil1;

    @FXML
    private Label buntil2;

    @FXML
    private Label buntil3;

    @FXML
    private Label buntil4;

    @FXML
    private Label resby4;

    @FXML
    private Label resby3;

    @FXML
    private Label resby1;

    @FXML
    private Label resby2;


    @FXML
    private Button back;
Vector<Sala> sale;
    public void displayPage()
    {DBserver dbs=new DBserver();
        new Thread(dbs).start();

        DBCon dbc=new DBCon();
        sale=dbc.getBookings();
        idF1.setText(String.valueOf(sale.get(0).getId()));
        idF2.setText(String.valueOf(sale.get(1).getId()));
        idF3.setText(String.valueOf(sale.get(2).getId()));
        idF4.setText(String.valueOf(sale.get(3).getId()));
        bfrom1.setText(String.valueOf(sale.get(0).getBusyFrom()));
        bfrom2.setText(String.valueOf(sale.get(1).getBusyFrom()));
        bfrom3.setText(String.valueOf(sale.get(2).getBusyFrom()));
        bfrom4.setText(String.valueOf(sale.get(3).getBusyFrom()));
        buntil1.setText(String.valueOf(sale.get(0).getBusyUntil()));
        buntil2.setText(String.valueOf(sale.get(1).getBusyUntil()));
        buntil3.setText(String.valueOf(sale.get(2).getBusyUntil()));
        buntil4.setText(String.valueOf(sale.get(3).getBusyUntil()));
        resby1.setText(String.valueOf(sale.get(0).getBookedBy()));
        resby2.setText(String.valueOf(sale.get(1).getBookedBy()));
        resby3.setText(String.valueOf(sale.get(2).getBookedBy()));
        resby4.setText(String.valueOf(sale.get(3).getBookedBy()));
    }
    void initialize(Manager manager)
    {
        System.out.println("view");
        back.setOnAction(event -> {
            manager.showMainScreen();
            Thread.currentThread().interrupt();
        });
        displayPage();
    }
}
