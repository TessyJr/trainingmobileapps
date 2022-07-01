package RoomDatabase;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "person")
public class Person {

    @ColumnInfo (name = "name")
    private  String name;

    @ColumnInfo(name = "id")
    @PrimaryKey (autoGenerate = true)
    private int id;

    @ColumnInfo(name = "address")
    private String address;

    @Ignore
    public Person(int id) {
        this.id = id;
    }

    public Person(String name, int id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    @Ignore
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}
