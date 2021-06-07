package nl.inholland.exam.ships.BramSierhuis.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data //TODO: Validate
@Entity
public class Manufacturer {
    @Id
    private long id;
    String name;
    String affiliation;
    String ceo;
    List<Ship> ships;
}
