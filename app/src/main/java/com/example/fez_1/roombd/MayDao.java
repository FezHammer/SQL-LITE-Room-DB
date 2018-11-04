package com.example.fez_1.roombd;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MayDao {

@Insert
void addItem(Items items);

@Query ("select * from Items")
List<Items> getItems();

@Delete
void deleteitem(Items items);





}
