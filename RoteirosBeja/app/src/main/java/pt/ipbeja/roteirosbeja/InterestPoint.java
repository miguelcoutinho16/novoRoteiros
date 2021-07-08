package pt.ipbeja.roteirosbeja;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class InterestPoint {

    @PrimaryKey(autoGenerate = true)
    private int idPoint;

    private String name;

    private String description;

    private String images;

    private String maps;

    private long eachInterestID;


    public InterestPoint(int idPoint, String name,String description, String images, String maps, long eachInterestID){

        this.idPoint = idPoint;
        this.name = name;
        this.description = description;
        this.images = images;
        this.maps = maps;
        this.eachInterestID = eachInterestID;
    }

    public int getIdPoint() {
        return idPoint;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getImages(){
        return images;
    }

    public String getMaps() {
        return maps;
    }

    public long getEachInterestID() {
        return eachInterestID;
    }
}
