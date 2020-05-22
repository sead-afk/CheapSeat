package com.example.seadgacanovic;

import java.util.List;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface usedDao {

    @Query("SELECT * FROM users")
    List<users> getAll();

    @Insert
    void insertSingleUser (users user);

    @Insert
    void insertMultipleUsers (List<users> userList);

    @Update
    void updateUser (users user);

    @Delete
    void deleteUser (users user);
}
