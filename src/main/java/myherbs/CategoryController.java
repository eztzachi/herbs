package myherbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tezra on 8/4/15.
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List categoryList() {
        return repository.findAll();
    }
}
