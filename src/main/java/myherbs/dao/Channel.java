package myherbs.dao;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.annotation.Id;

/**
 * Created by tezra on 8/8/15.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Channel {

    @Id
    private String id;
    private String name;

    public Channel() {
    }

    public Channel(String name) {
        this.name = name;
    }
}
