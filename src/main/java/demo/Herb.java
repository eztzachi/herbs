package demo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.annotation.Id;

/**
 * Created by tezra on 7/31/15.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Herb {

    @Id
    private String id;

    private String englishName;
    private String chineesehName;

    public Herb() {}

    public Herb(String englishName, String chineesehName) {
        this.englishName = englishName;
        this.chineesehName = chineesehName;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "Herb[id=%s, englishName='%s', chineesehName='%s']",
                id, englishName, chineesehName);
    }
}
