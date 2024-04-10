package ch.noseryoung.shippingmethod.domain.shippingmethod;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import java.util.NoSuchElementException;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestController
@RequestMapping("/shippingmethod")
public class ShippingmethodController {

    @Autowired
    private ShippingmethodService shippingmethodService;

    @Operation(description = "Receive a list of all shippings that are stored in the db. Access to this Endpoint requires READ authority", summary = "get all addresses that are stored in the db")
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/")
    public ResponseEntity<Object> getShippingmethod() {
        return ResponseEntity.ok().body(shippingmethodService.getShippingmethods());
    }

    @Operation(description = "Receive a specific address by id that is stored in the db. Access to this Endpoint requires READ authority", summary = "get address by a specific id that is stored in the db")
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{addressId}")
    public ResponseEntity<Shippingmethod> getShippingById(@PathVariable("addressId") Integer shipping_id)
            throws InstanceNotFoundException, ShippmentNotFoundException {
        return ResponseEntity.ok().body(shippingmethodService.getShippingById(shipping_id));
    }

    @Operation(description = "add address that will be stored in the db, requires CREATE Authority", summary = "add address that will be stored in the db")
    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping("/")
    public ResponseEntity<Shippingmethod> addShippingmethod(@Valid @RequestBody Shippingmethod shippingmethod)
            throws AccessDeniedException {
        return ResponseEntity.ok().body(shippingmethodService.addShippingmethod(shippingmethod));
    }

    @Operation(description = "Delete address that is stored in the db by its id. Access to this Endpoint requires DELETE authority", summary = "delete address by id that is stored in the db")
    @PreAuthorize("hasAuthority('DELETE')")
    @DeleteMapping("/{addressId}")
    public String deleteShippingmethod(@PathVariable("addressId") int index) {
        shippingmethodService.deleteShippingmethod(index);
        return "You Deleted " + index;
    }

    @Operation(description = "Update existing Address in the db with new values. Access to this Endpoint requires UPDATE authority", summary = "update existing address that is stored in the db")
    @PreAuthorize("hasAuthority('UPDATE')")
    @PutMapping("/{addressId}")
    public ResponseEntity<Shippingmethod> updateShippingmethod(@Valid @PathVariable("shippingId") int shipping_id,
            @Valid @RequestBody Shippingmethod shippingmethod)
            throws AccessDeniedException, InstanceNotFoundException, ShippmentNotFoundException {
        shippingmethodService.updateShippingmethod(shipping_id, shippingmethod);
        return ResponseEntity.status(200).body(shippingmethodService.updateShippingmethod(shipping_id, shippingmethod));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException element) {
        return ResponseEntity.status(404).body(element.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException element) {
        return ResponseEntity.badRequest().body(element.getBindingResult().getFieldError().getField() + " is invalid: "
                + element.getBindingResult().getFieldError().getDefaultMessage());
    }

    public class ShippmentNotFoundException extends Exception {
        public ShippmentNotFoundException(String message) {
            super(message);
        }

        public ShippmentNotFoundException() {
            super();
        }
    }

    @ExceptionHandler(ShippingmethodController.ShippmentNotFoundException.class)
    public ResponseEntity<String> handleAddressControllerAddressNotFoundException(
            ShippingmethodController.ShippmentNotFoundException element) {
        return ResponseEntity.status(404).body(element.getMessage());
    }

    @ExceptionHandler(ShippmentNotFoundException.class)
    public ResponseEntity<String> handleShippmentNotFoundException(ShippmentNotFoundException element) {
        return ResponseEntity.status(404).body(element.getMessage());
    }

    @ExceptionHandler(InstanceNotFoundException.class)
    public ResponseEntity<String> handleInstanceNotFoundException(InstanceNotFoundException element) {
        return ResponseEntity.status(404).body(element.getMessage());
    }

    @ExceptionHandler(InstanceAlreadyExistsException.class)
    public ResponseEntity<String> handleInstanceAlreadyExistsException(InstanceAlreadyExistsException element) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException element) {
        return ResponseEntity.status(403).body(element.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException element) {
        return ResponseEntity.status(404).body(element.getMessage());
    }
}