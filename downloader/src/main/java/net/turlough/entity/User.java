package net.turlough.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by turlough on 06/08/16.
 */

@DatabaseTable(tableName = "user")
public class User {

    @Getter
    @Setter
    @DatabaseField(generatedId = true)
    private int id;

    @Getter
    @Setter
    @DatabaseField
    private String forename;

    @Getter
    @Setter
    @DatabaseField
    private String surname;

    public User() {

    }

    public User(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
    }


}
