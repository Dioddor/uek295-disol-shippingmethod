package ch.noseryoung.shippingmethod.domain.shippingmethod;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "shippingmethod")
public class Shippingmethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_id")
    private Integer shipping_id;

    @Column(name = "name")
    @NotBlank(message = "Name must contain a value")
    private String name;

    @Column(name = "duration")
    @Size(min = 2, max = 20)
    @NotBlank(message = "Duration must contain a value")
    private String duration;

    @Column(name = "price_in_$")
    @NotBlank(message = "Price must contain a value")
    private float price;
}