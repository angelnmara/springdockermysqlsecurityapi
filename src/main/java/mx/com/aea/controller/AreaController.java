package mx.com.aea.controller;

import mx.com.aea.model.Area;
import mx.com.aea.repository.AreaJpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AreaController {
    private final AreaJpaRepository repository;

    public AreaController(AreaJpaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/area")
    public void saveArea(@RequestBody Area area){
        area.setFechaCreacion(new Date());
        repository.save(area);
    }

    @GetMapping("/area")
    public List<Area> getArea(){
        return repository.findAll();
    }

    @PutMapping("/area/{id}")
    public Area updateArea(@RequestBody Area newArea, @PathVariable Long id){
        return repository.findById(id).map(Area ->{
            Area.setNombreArea(newArea.getNombreArea());
            Area.setDescripcionArea(newArea.getDescripcionArea());
            Area.setFechaActualizacion(new Date());
            return repository.save(Area);
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
