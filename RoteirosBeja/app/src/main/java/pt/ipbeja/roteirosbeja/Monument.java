package pt.ipbeja.roteirosbeja;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Monument {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;

    private String shortDescription;

    private String longDescription;

    private String image;

    public Monument(long id, String title, String shortDescription, String longDescription, String image) {

        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.image = image;
    }

    public long getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getImage() {
        return image;
    }
}
