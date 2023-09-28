package com.example.popfit

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.popfit.data.Exercise
import com.example.popfit.storage.ExerciseDao
import com.example.popfit.storage.ExerciseDatabase
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ExerciseDaoTest {

    private lateinit var dao: ExerciseDao

    @Before
    fun createDao(){
        dao = Room.inMemoryDatabaseBuilder(
            context = InstrumentationRegistry.getInstrumentation().context,
            klass = ExerciseDatabase::class.java
        ).build().createExerciseDao()
    }

    @Test
    fun should_return_correct_size_of_db_after_inserting(){
        dao.insertExercise(
            Exercise(
                title = "Mock",
                currentWeighInKg = 1.0f,
                upWeightInNextTime = false
            )
        )

        val exceptedSize = 1
        val actualSize = dao.getAllExercise().value?.size

        Assert.assertEquals(exceptedSize, actualSize)
    }

}