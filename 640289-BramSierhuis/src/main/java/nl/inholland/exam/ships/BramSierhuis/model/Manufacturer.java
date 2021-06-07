package nl.inholland.exam.ships.BramSierhuis.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Manufacturer {
    @Id
    private long id;
    private String name;
    private String affiliation;
    private String ceo;

    @OneToMany(mappedBy = "manufacturerId")
    Set<Ship> ships = new HashSet<>();
}
