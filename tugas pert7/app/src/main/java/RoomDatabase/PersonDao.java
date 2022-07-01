package RoomDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM person")
    LiveData<List<Person>> getPersons();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPerson(Person person);

    @Delete
    void deletePerson(Person person);

    @Query("UPDATE person SET name=:name WHERE id=:id ")
    void updatePerson (String name, int id);

}
