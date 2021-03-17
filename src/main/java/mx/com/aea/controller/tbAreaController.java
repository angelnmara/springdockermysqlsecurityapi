package mx.com.aea.controller;

import mx.com.aea.model.tbArea;
import mx.com.aea.repository.tbAreaJpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class tbAreaController {
    private final tbAreaJpaRepository repository;

    public tbAreaController(tbAreaJpaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/area")
    public void saveArea(@RequestBody tbArea area){
        area.setFechaCreacionArea(new Date());
        repository.save(area);
    }

    @GetMapping("/area")
    public List<tbArea> getArea(){
        return repository.findAll();
    }

    @PutMapping("/area/{id}")
    public tbArea updateArea(@RequestBody tbArea newArea, @PathVariable Long id){
        return repository.findById(id).map(area->{
            area.setNombreArea(newArea.getNombreArea());
            area.setDescripcionArea(newArea.getDescripcionArea());
            area.setFechaActualizacionArea(new Date());
            return repository.save(area);
        }).orElseGet(()->{
            newArea.setIdArea(id);
            return repository.save(newArea);
        });
    }

    @DeleteMapping("/area/{id}")
    public void deleteArea(@PathVariable Long id){
        repository.deleteById(id);
    }

}
