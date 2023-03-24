package com.github.jesushzc.todoapplication.di

import com.github.jesushzc.todoapplication.repository.NotesRepository
import com.github.jesushzc.todoapplication.repository.NotesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNotesRepository(notesRepository: NotesRepositoryImpl): NotesRepository

}