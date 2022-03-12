package pl.sda.prices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PricesController {

    Map<String, BigDecimal> equipment = new HashMap<>();
    {
        equipment.put("k001", BigDecimal.valueOf(100));
        equipment.put("k002", BigDecimal.valueOf(5));
        equipment.put("k003", BigDecimal.valueOf(2966));
        equipment.put("k004", BigDecimal.valueOf(3586));
        equipment.put("k005", BigDecimal.valueOf(1));
    }


    @GetMapping("/equipment/{id}")
    public ResponseEntity<BigDecimal> getEquipmentPrice(@PathVariable String id){
        BigDecimal price = equipment.get(id);
        if (price == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(price);
    }

}
