package nl.inholland.exam.ships.BramSierhuis.model;

import lombok.*;
import nl.inholland.exam.ships.BramSierhuis.model.dto.ShipDTO;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ship {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private long manufacturerId;
    private String type;
    private double length;
    private long cost;

    //Convert a shipDTO to a ship object
    public Ship (ShipDTO shipDTO){
        this.name = shipDTO.getName();
        this.manufacturerId = shipDTO.getManufacturerId();
        this.type = shipDTO.getType();
        this.length = shipDTO.getLength();
        this.cost = shipDTO.getCost();
    }
}
