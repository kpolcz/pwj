
import java.io.IOException;
import java.net.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
public class DBCon {
    private static Statement createStatement(Connection connection) {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //UPDATE `sala` SET `busyFrom` = '2020-01-17 12:00:00', `busyUntil` = '2020-01-17 12:30:00', `bookedBy` = 'Adam Smith' WHERE `sala`.`id` = 1;
    public void BookRoom(int id, String from, String to, String teacher) {
//        if (!from.isBefore(to)) {
//            try {
//                String query = "UPDATE `sala` SET `empty`=0, `busyFrom` = '" + from + "', `busyUntil` = '" + to + ", `bookedBy` = '" + teacher + "' WHERE `sala`.`id` = " + id;
//                Connection c = Connect();
//                PreparedStatement ps = c.prepareStatement(query);
//                ps.execute();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } else
//            System.out.println("złe daty");
        try {
            InetAddress servAddr = InetAddress.getLocalHost();
            String query = "UPDATE `sala` SET `busyFrom` = '" + from + "', `busyUntil` = '" + to + "', `bookedBy` = '" + teacher + "' WHERE `sala`.`id` = " + id;
            byte buf[] = query.getBytes();
            DatagramSocket sck = new DatagramSocket();
            sck.send(new DatagramPacket(buf, buf.length, servAddr, 4321));
            //odbiór
//            buf = new byte[512];
//            DatagramPacket pck = new DatagramPacket(buf, buf.length);
//            sck.receive(pck);
//            System.out.println(new String(pck.getData(), 0, pck.getLength()));
//            sck.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  Vector<Sala> getBookings() {
        Vector<Sala> sale=new Vector<>();
        try {
            InetAddress servAddr = InetAddress.getLocalHost();
            String query = "SELECT * FROM `sala` ORDER BY id";
            byte buf[] = query.getBytes();
            DatagramSocket sck = new DatagramSocket();
            sck.send(new DatagramPacket(buf, buf.length, servAddr, 4321));
            //odbiór
            buf = new byte[1024];

            DatagramPacket pck = new DatagramPacket(buf, buf.length);

            sck.receive(pck);
            Sala newsala;
            int id=1;
            String s= new String(pck.getData(), 0, pck.getLength());
            sck.close();
            String arra[] =s.split("/");
            List<String> arr=new ArrayList<String>();
            arr= Arrays.asList(arra);
            System.out.println(arr.size()/4);
            for(int i=0;i<(arr.size());i=i+4) {

                id= Integer.parseInt(arr.get(i));
                newsala = new Sala(id, arr.get(i + 1), arr.get(i + 2), arr.get(i + 3));
                sale.add(newsala);
                System.out.println(newsala.toString());
                System.out.println(i);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return sale;
    }
}
