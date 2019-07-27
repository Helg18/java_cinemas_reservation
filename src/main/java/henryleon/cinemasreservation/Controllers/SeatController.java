package henryleon.cinemasreservation.Controllers;

import henryleon.cinemasreservation.Models.Seat;
import henryleon.cinemasreservation.Repositories.SeatRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/seats")
public class SeatController {
    private final SeatRepository seatRepository;

    public SeatController(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List getAllSeats() {
        return this.seatRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Seat> show(@PathVariable Long id) {
        return this.seatRepository.findById(id);
    }
}
