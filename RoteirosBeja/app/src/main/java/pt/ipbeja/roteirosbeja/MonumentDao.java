package pt.ipbeja.roteirosbeja;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MonumentDao {

    @Query("SELECT * FROM Monument")
    List<Monument> getAll();

    @Query("SELECT * FROM Monument Where id = :monumentId")
    Monument getById(long monumentId);

    @Update
    void update(Monument info);

    @Insert
    void insert(Monument info);

}

