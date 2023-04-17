package com.kk.memechallengecompose.core.di

import com.kk.memechallengecompose.data.repository.RepositoryImp
import com.kk.memechallengecompose.domain.repository.IRepository
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
    abstract fun provideRepository(repositoryImp: RepositoryImp): IRepository
}