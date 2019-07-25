package henryleon.cinemasreservation.Repositories;

import henryleon.cinemasreservation.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
