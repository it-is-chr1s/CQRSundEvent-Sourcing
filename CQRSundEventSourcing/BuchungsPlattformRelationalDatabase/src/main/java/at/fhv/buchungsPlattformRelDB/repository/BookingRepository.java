package at.fhv.buchungsPlattformRelDB.repository;

import at.fhv.buchungsPlattformRelDB.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    Booking findByReservationNumber(int reservationNumber);
    boolean existsByReservationNumber(int reservationNumber);
}
