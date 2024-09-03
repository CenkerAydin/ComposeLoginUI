package com.cenkeraydin.composeloginui.di

import com.cenkeraydin.composeloginui.data.repository.NoteRepositoryImpl
import com.cenkeraydin.composeloginui.domain.repository.Repository
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
    abstract fun bindRepository(repositoryImpl: NoteRepositoryImpl): Repository
}