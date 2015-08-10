package myherbs.dao;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.annotation.Id;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tezra on 7/31/15.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Herb {

    @Id
    private String id;

    private String englishName;
    private String chineseName;
    private String latinName;
    private String image;
    private Category category;
    private List<Channel> channels = new LinkedList<>();
    private List<Property> properties = new LinkedList<>();
//    private Range doage;
    private String cautionsAndContraIndications;
    private List<String> actionsAndIndications;
//    private List<ActionTag> actionTags;
    private String quotes;
//    private List<ActionTag> bestFor;

    public Herb() {}

    public Herb(String englishName, String chineseName, String image) {
        this.englishName = englishName;
        this.chineseName = chineseName;
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return String.format(
                "Herb[id=%s, category='%s', englishName='%s', chineseName='%s']",
                id, category, englishName, chineseName);
    }
}
