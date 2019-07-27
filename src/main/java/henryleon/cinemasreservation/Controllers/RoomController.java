package henryleon.cinemasreservation.Controllers;

import henryleon.cinemasreservation.Models.Room;
import henryleon.cinemasreservation.Repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List getAllRooms() {
        return this.roomRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Room> show(@PathVariable Long id) {
        return this.roomRepository.findById(id);
    }
}
