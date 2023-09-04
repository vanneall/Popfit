package com.example.popfit.di

import android.content.Context
import androidx.room.Room
import com.example.popfit.storage.ExerciseDao
import com.example.popfit.storage.ExerciseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideExerciseDao(@ApplicationContext context: Context): ExerciseDao {
        return Room.databaseBuilder(
            context = context,
            klass = ExerciseDatabase::class.java,
            name = "exercise_database"
        ).build().createDatabase()
    }
}