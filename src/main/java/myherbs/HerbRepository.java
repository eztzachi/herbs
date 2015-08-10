package myherbs;

import myherbs.dao.Herb;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by tezra on 7/31/15.
 */
public interface HerbRepository extends MongoRepository<Herb, String> {
    Herb findByEnglishName(String englishName);
}
