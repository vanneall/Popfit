package com.example.popfit.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.popfit.data.Exercise

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    fun getAllExercise() : LiveData<List<Exercise>>

    @Insert
    fun insertExercise(exercise: Exercise)

    @Update
    fun updateExercise(exercise: Exercise)

    @Delete
    fun deleteExercise(exercise: Exercise)
}