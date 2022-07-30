package com.applid.gym.di

import android.content.Context
import com.applid.gym.common.Constants
import com.applid.gym.data.api.Api
import com.applid.gym.data.repositories.DataStoreRepositoryImpl
import com.applid.gym.data.repositories.HomeRepositoryImpl
import com.applid.gym.data.repositories.SignInRepositoryImpl
import com.applid.gym.data.repositories.SignUpRepositoryImpl
import com.applid.gym.domain.repositories.DataStoreRepository
import com.applid.gym.domain.repositories.HomeRepository
import com.applid.gym.domain.repositories.SignInRepository
import com.applid.gym.domain.repositories.SignUpRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi() : Api{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideSignUpRepository(api: Api) : SignUpRepository {
        return SignUpRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideSignInRepository(api: Api) : SignInRepository {
        return SignInRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideHomeRepository(api : Api) : HomeRepository {
        return HomeRepositoryImpl(api = api)
    }

    @Singleton
    @Provides
    fun provideDataStoreRepository(@ApplicationContext context: Context) : DataStoreRepository {
        return DataStoreRepositoryImpl(context = context)
    }
}