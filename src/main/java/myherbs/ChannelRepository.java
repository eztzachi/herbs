package myherbs;

import myherbs.dao.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by tezra on 8/4/15.
 */
public interface ChannelRepository extends MongoRepository<Channel, String> {
}
