package mx.com.aea.model;

import java.time.Year;

public class Annio {
    private final Integer value;

    public Annio(Integer value) throws Exception {
        this.value = validate(value);
    }

    private Integer validate(Integer value) throws Exception {
        if(value == null){
            throw new Exception("Annio no puede ser null");
        }
        return value;
    }

    public Integer getValue() {
        return value;
    }
}
