package ch.noseryoung.shippingmethod.domain.shippingmethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ShippingmethodService {

    @Autowired
    private ShippingmethodRepository repository;

    public List<Shippingmethod> getShippingmethods() {
        return repository.findAll()
        // .orElseThrow(() -> new MethodArgumentNotValidException(getMessage));
        ;
    }

    public Shippingmethod getShippingById(int index) {
        return repository.findById(index)
                .orElseThrow(() -> new NoSuchElementException("Product with id " + index + "does not exist"));
    }

    public Shippingmethod addShippingmethod(Shippingmethod shippingmethod) {
        return repository.save(shippingmethod);
    }

    public void deleteShippingmethod(int index) {
        if (!repository.existsById(index)) {
            throw new IllegalArgumentException("This id does not exist " + index);
        } else {
            repository.deleteById(index);
        }
    }

    public Shippingmethod updateShippingmethod(int index, Shippingmethod shippingmethod) {
        repository.findById(index);
        shippingmethod.setShipping_id(index);
        return repository.save(shippingmethod);
    }

}