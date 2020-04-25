package com.example.sajo.data.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "registrationTable")
public class registerstudent
{

      @PrimaryKey @NonNull

      @ColumnInfo(name = "username")
          String username ;
      @ColumnInfo(name = "email")
        String email ;
      @ColumnInfo(name = "password")
         String password;

    public registerstudent() {
    }

    public registerstudent(@NonNull String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
