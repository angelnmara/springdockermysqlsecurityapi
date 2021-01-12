package mx.com.aea.model;


public class Mes {
    private final Integer value;

    public Mes(Integer value) throws Exception {
        this.value = validate(value);
    }

    private Integer validate(Integer value) throws Exception {
        if(value==null){
            throw new Exception("Mes no puede ser null");
        }
        if(value>12 || value == 0){
            throw new Exception("Mes no puede ser 0 o mayor a 12");
        }
        return value;
    }

    public Integer getValue() {
        return value;
    }
}
