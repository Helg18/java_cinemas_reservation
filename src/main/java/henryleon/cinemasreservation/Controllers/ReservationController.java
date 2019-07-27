package henryleon.cinemasreservation.Controllers;

import henryleon.cinemasreservation.Models.Reservation;
import henryleon.cinemasreservation.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Reservation create(@RequestBody Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Reservation> show(@PathVariable Long id) {
        return this.reservationRepository.findById(id);
    }
}
