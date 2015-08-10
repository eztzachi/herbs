package myherbs;

import myherbs.dao.Herb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tezra on 7/31/15.
 */
@RestController
@RequestMapping("/api/herbs")
public class HerbController {

    @Autowired
    private HerbRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List herbList() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Herb viewHerb(@PathVariable String id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Herb editHerb(@RequestBody Herb updatedItem, @PathVariable String id) {
        updatedItem.setId(id);
        return repository.save(updatedItem);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Herb addHerb(@RequestBody Herb herb) {
        System.out.println("POST");
        herb.setId(null);
        return repository.save(herb);
    }
}
