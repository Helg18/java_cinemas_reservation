package henryleon.cinemasreservation.Repositories;

import henryleon.cinemasreservation.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
