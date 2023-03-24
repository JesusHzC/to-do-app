package com.github.jesushzc.todoapplication.di

import android.content.Context
import com.github.jesushzc.todoapplication.database.NotesDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext
        context: Context
    ): NotesDB{
        return NotesDB.getInstance(context)
    }

}