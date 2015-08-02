package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tezra on 7/31/15.
 */
@RestController
@RequestMapping("/herbs")
public class HerbController {

    @Autowired
    private HerbRepository repository;

    @RequestMapping("/abc")
    public List findItems() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Herb updateItem(@RequestBody Herb updatedItem, @PathVariable String id) {
        updatedItem.setId(id);
        return repository.save(updatedItem);
    }
}
