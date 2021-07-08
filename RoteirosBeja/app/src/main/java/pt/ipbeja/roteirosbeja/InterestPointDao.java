package pt.ipbeja.roteirosbeja;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface InterestPointDao {

    @Query("SELECT * FROM InterestPoint")
    List<InterestPoint> getAll();

//    @Query("SELECT * FROM InterestPoint Where id = :interestingId")
//    InterestPoint getById(long interestingId);

    @Query("SELECT * FROM InterestPoint WHERE eachInterestID = :infoID")
    List<InterestPoint> getAllForEach(long infoID);

    @Query("SELECT * FROM InterestPoint WHERE eachInterestID = :infoID")
    List<InterestPoint> getEachPos(long infoID);
}
