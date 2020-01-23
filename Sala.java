import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Sala {
    private int id;
    private Boolean empty =false;
    private String busyFrom;
    private String busyUntil;
    private String bookedBy;
    public String getBusyFrom() {
        return busyFrom;
    }

    public void setBusyFrom(String busyFrom) {
        this.busyFrom = busyFrom;
    }

    public Sala(int id, String busyFrom, String busyUntil, String bookedBy) {
        this.id = id;
        this.busyFrom = busyFrom;
        this.busyUntil = busyUntil;
        this.bookedBy = bookedBy;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", empty=" + empty +
                ", busyFrom='" + busyFrom + '\'' +
                ", busyUntil='" + busyUntil + '\'' +
                ", bookedBy='" + bookedBy + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public String getBusyUntil() {
        return busyUntil;
    }

    public void setBusyUntil(String busyUntil) {
        this.busyUntil = busyUntil;
    }
}
