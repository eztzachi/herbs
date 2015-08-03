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
    private String image;

    public Herb() {}

    public Herb(String englishName, String chineesehName, String image) {
        this.englishName = englishName;
        this.chineesehName = chineesehName;
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return String.format(
                "Herb[id=%s, englishName='%s', chineesehName='%s']",
                id, englishName, chineesehName);
    }
}
