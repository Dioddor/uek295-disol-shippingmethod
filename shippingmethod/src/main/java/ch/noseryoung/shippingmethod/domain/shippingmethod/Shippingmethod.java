package ch.noseryoung.shippingmethod.domain.shippingmethod;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Column(nullable = false)
    private int shipping_id;

    @Column(nullable = false)
    @Size(min = 2, max = 15)
    @NotBlank(message = "Name must contain a value")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Duration must contain a value")
    private String duration;

    @Column(nullable = false)
    @NotNull(message = "Price must contain a value")
    private float price_in_$;
}