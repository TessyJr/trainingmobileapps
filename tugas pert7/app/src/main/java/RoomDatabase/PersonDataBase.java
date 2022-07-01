package RoomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, exportSchema = false, version = 1)
public abstract class PersonDataBase extends RoomDatabase {


    private static final String DB_name="company_db";
    private static PersonDataBase instance;

    public static synchronized PersonDataBase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(), PersonDataBase.class, DB_name)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();

        }
        return instance;
    }

    public abstract PersonDao personDao();
}
