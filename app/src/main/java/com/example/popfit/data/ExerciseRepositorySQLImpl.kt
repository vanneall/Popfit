package com.example.popfit.data

import androidx.lifecycle.LiveData
import com.example.popfit.domain.Exercise
import com.example.popfit.domain.ExerciseRepository
import com.example.popfit.storage.ExerciseDao
import javax.inject.Inject

class ExerciseRepositorySQLImpl @Inject constructor(private val exerciseDao: ExerciseDao) :
    ExerciseRepository {
    override fun getAllExercise(): LiveData<List<Exercise>> = exerciseDao.getAllExercise()
    override suspend fun insert(exercise: Exercise) = exerciseDao.insertExercise(exercise)
    override suspend fun update(exercise: Exercise) = exerciseDao.updateExercise(exercise)
    override suspend fun delete(exercise: Exercise) = exerciseDao.deleteExercise(exercise)
}