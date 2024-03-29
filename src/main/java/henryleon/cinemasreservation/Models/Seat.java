package henryleon.cinemasreservation.Models;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "seats")
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "@room")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer row;
    private Integer col;
    private Boolean status;

    @ManyToMany(targetEntity = Reservation.class)
    @JoinColumn(name="reservations_id", referencedColumnName="reservations_id")
    private List<Reservation> reservations;

    @ManyToOne(targetEntity = Room.class, fetch = FetchType.EAGER)
    private Room room;

    @CreationTimestamp
    private Date created_at;
    @UpdateTimestamp
    private Date updated_at;

    public Seat() {}

    public Seat(Room room, Integer row, Integer col, Boolean status) {
        this.room = room;
        this.row = row;
        this.col = col;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
