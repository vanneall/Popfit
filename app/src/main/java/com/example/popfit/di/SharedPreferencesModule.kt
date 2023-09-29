package com.example.popfit.di

import android.content.Context
import androidx.room.PrimaryKey
import com.example.popfit.data.ImageSharedPrefRepImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferencesForImage(@ApplicationContext context: Context) =
        ImageSharedPrefRepImpl(context)

}