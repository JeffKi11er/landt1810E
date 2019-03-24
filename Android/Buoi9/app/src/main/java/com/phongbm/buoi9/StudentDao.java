package com.phongbm.buoi9;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM Student")
    List<Student> getAll();
    @Query("SELECT * FROM Student WHERE score >= :score")
    List<Student> getByScore(int score);
    @Insert
    void insert(Student... students);
    @Update
    void update(Student... students);
    @Delete
    void delete(Student... students);

}
