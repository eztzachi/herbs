package myherbs.dao;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.annotation.Id;

/**
 * Created by tezra on 8/4/15.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Category {

    @Id
    private String id;
    private String name;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }
}
