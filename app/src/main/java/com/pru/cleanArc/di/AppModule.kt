package com.pru.cleanArc.di

import com.pru.cleanArc.data.remote.CleanArchiAPI
import com.pru.cleanArc.data.repository.CleanArchiRepositoryImp
import com.pru.cleanArc.domain.repository.CleanArchiRepository
import com.pru.cleanArc.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCleanArchiAPI() : CleanArchiAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .build()
            .create(CleanArchiAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCleanArchiRepository(api: CleanArchiAPI): CleanArchiRepository {
        return CleanArchiRepositoryImp(api)
    }
}