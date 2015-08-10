package myherbs;

import myherbs.dao.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by tezra on 8/4/15.
 */
public interface CategoryRepository extends MongoRepository<Category, String> {
}
