package henryleon.cinemasreservation.Controllers;

import henryleon.cinemasreservation.Repositories.SeatRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
