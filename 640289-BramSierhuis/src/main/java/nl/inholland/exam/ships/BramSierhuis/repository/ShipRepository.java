package nl.inholland.exam.ships.BramSierhuis.repository;

import nl.inholland.exam.ships.BramSierhuis.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRepository extends JpaRepository<Ship, Long> {
}
