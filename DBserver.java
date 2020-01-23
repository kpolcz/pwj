import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.*;

public class DBserver implements Runnable{
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    protected Thread       runningThread= null;




    @Override
    public void run() {

        synchronized (this) {
            this.runningThread = Thread.currentThread();
            try {
               new Thread(new ServerRunnable()).start();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
