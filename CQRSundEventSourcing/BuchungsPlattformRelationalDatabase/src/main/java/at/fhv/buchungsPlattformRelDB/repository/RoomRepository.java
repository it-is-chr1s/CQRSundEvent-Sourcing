package at.fhv.buchungsPlattformRelDB.repository;

import at.fhv.buchungsPlattformRelDB.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Room findByNumber(int number);
    boolean existsByNumber(int number);
}
