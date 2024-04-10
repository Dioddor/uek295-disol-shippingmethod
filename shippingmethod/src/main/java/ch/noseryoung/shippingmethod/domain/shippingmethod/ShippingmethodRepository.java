package ch.noseryoung.shippingmethod.domain.shippingmethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingmethodRepository extends JpaRepository<Shippingmethod, Integer> {
}
