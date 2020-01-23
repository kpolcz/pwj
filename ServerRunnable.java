import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServerRunnable implements Runnable {
    DatagramSocket socket = new DatagramSocket(4321);
    private Lock lock = new ReentrantLock();

    private static Connection Connect() {
        String baza = "jdbc:mysql://localhost:3306/pwj2";
        String uname = "root";
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection(baza, uname, "");
        } catch (SQLException e) {
            System.out.println("Blad przy ladowaniu sterownika bazy!");
            e.printStackTrace();
            System.exit(1);
        }
        return connection;
    }

    public ServerRunnable() throws SocketException {
    }


    public void run() {


        try {

            while (true) {
                byte[] buf = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                /* 1. Oczekujemy na pakiet ... */
                socket.receive(packet);
                lock.lock();
                String received = new String(packet.getData(), 0, packet.getLength());
                String arr[] = received.split(" ", 2);
                String type = arr[0];
                System.out.println(received);
                Connection c = Connect();
                System.out.println("connecting to db");
                System.out.println(arr[0]);
                PreparedStatement ps = c.prepareStatement(received);
                switch (type) {
                    case "UPDATE": {
                        System.out.println("update");
                        ps.executeUpdate();
                        break;
                    }
                    case "SELECT": {
                        System.out.println("select");
                        ResultSet rs = ps.executeQuery();
                        String s="";
                        while(rs.next())
                        {
                            s+=rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3)+"/"+rs.getString(4)+"/";
                        }
                        System.out.println(s);
                        socket.send(new DatagramPacket(s.getBytes(), s.length(), packet.getAddress(), packet.getPort()));
                        break;
                    }
                }
                return;
            }

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            lock.unlock();
            socket.close();

            System.out.println("done");
        }
    }
}
