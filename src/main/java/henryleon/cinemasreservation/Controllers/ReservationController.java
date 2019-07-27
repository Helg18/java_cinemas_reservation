package henryleon.cinemasreservation.Controllers;

import henryleon.cinemasreservation.Models.Reservation;
import henryleon.cinemasreservation.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "reservations")
public class ReservationController {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Reservation> getAllReservations() {
        return this.reservationRepository.findAll();
    }
}
