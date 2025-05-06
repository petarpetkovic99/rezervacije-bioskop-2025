package me.fit.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(
    name = Reservation.GET_RESERVATIONS_FOR_PERSON, 
    query = "SELECT r FROM Reservation r WHERE r.person.id = :id"
)
public class Reservation {

    public static final String GET_RESERVATIONS_FOR_PERSON = "Reservation.getReservationsForPerson";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    private Long id;
    private int numOfSeats;
    private String reservationDate;
    private boolean status;

    @ManyToOne()
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne()
    @JoinColumn(name = "projection_id")
    private Projection projection;

    public Reservation() {

    }

    public Reservation(int numOfSeats, String reservationDate, boolean status) {
        this.numOfSeats = numOfSeats;
        this.reservationDate = reservationDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getDate() {
        return reservationDate;
    }

    public void setDate(String date) {
        this.reservationDate = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + numOfSeats;
        result = prime * result + ((reservationDate == null) ? 0 : reservationDate.hashCode());
        result = prime * result + (status ? 1231 : 1237);
        result = prime * result + ((person == null) ? 0 : person.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reservation other = (Reservation) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (numOfSeats != other.numOfSeats)
            return false;
        if (reservationDate == null) {
            if (other.reservationDate != null)
                return false;
        } else if (!reservationDate.equals(other.reservationDate))
            return false;
        if (status != other.status)
            return false;
        if (person == null) {
            if (other.person != null)
                return false;
        } else if (!person.equals(other.person))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reservation [id=" + id + ", numOfSeats=" + numOfSeats + ", date reservation=" + reservationDate
                + ", status=" + status
                + ", person=" + person + "]";
    }

}
