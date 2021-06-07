package nl.inholland.exam.ships.BramSierhuis.repository;

import nl.inholland.exam.ships.BramSierhuis.model.Manufacturer;
import nl.inholland.exam.ships.BramSierhuis.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
