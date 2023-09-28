package com.example.popfit.di

import com.example.popfit.data.ExerciseRepositorySQLImpl
import com.example.popfit.domain.DeleteAllFruitsUseCase
import com.example.popfit.domain.DeleteUseCase
import com.example.popfit.domain.GetAllExerciseUseCase
import com.example.popfit.domain.GetAllFruitsFromDbUseCase
import com.example.popfit.domain.InsertUseCase
import com.example.popfit.domain.UpdateUseCase
import com.example.popfit.domain.WriteAllFruitsToDbUseCase
import com.example.popfit.storage.FruitDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetAllExerciseUseCase(exerciseRepositorySQLImpl: ExerciseRepositorySQLImpl) =
        GetAllExerciseUseCase(exerciseRepositorySQLImpl)

    @Provides
    @ViewModelScoped
    fun provideInsertUseCase(exerciseRepositorySQLImpl: ExerciseRepositorySQLImpl) =
        InsertUseCase(exerciseRepositorySQLImpl)

    @Provides
    @ViewModelScoped
    fun provideUpdateUseCase(exerciseRepositorySQLImpl: ExerciseRepositorySQLImpl) =
        UpdateUseCase(exerciseRepositorySQLImpl)

    @Provides
    @ViewModelScoped
    fun provideDeleteUseCase(exerciseRepositorySQLImpl: ExerciseRepositorySQLImpl) =
        DeleteUseCase(exerciseRepositorySQLImpl)

    @Provides
    @ViewModelScoped
    fun provideDeleteAllFruitsUseCase(fruitDao: FruitDao) =
        DeleteAllFruitsUseCase(fruitDao)

    @Provides
    @ViewModelScoped
    fun provideWriteAllFruitsToDbUseCase(fruitDao: FruitDao) =
        WriteAllFruitsToDbUseCase(fruitDao)

    @Provides
    @ViewModelScoped
    fun provideGetAllFruitsFromDbUseCase(fruitDao: FruitDao) =
        GetAllFruitsFromDbUseCase(fruitDao)
}