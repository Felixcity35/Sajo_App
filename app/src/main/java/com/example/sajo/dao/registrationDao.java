package com.example.sajo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sajo.data.model.registerstudent;

@Dao
public interface registrationDao
{

    @Insert
    void registerstudent(registerstudent registerstudent);

    @Query("SELECT * FROM  registrationTable WHERE email LIKE :email")
    registerstudent getDetails(String email);
}
