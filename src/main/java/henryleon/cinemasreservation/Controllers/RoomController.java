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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Room create(@RequestBody Room room) {
        return this.roomRepository.save(room);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Room> show(@PathVariable Long id) {
        return this.roomRepository.findById(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public List<Room> update(@PathVariable Long id, @RequestBody Room room) {
        Optional<Room> optionalRoom = this.roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            Room r = optionalRoom.get();
            r.setName(room.getName());
            r.setStatus(room.getStatus());
            this.roomRepository.save(r);
        }
        return this.roomRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<Room> destroy(@PathVariable Long id) {
        Optional<Room> optionalRoom = this.roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            this.roomRepository.deleteById(id);
        }
        return this.roomRepository.findAll();
    }
}
