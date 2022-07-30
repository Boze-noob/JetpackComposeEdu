package com.applid.gym.data.repositories

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.applid.gym.common.Constants
import com.applid.gym.domain.repositories.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = Constants.DATASTORE_NAME)

class DataStoreRepositoryImpl(private val context : Context) : DataStoreRepository {

    companion object {
        val JWT = stringPreferencesKey("JWT")
    }
    override suspend fun saveStringData(data : String, key : Preferences.Key<String>) {
        context.dataStore.edit { it ->
        it[key] = data
        }
    }

    override suspend fun getStringData(key : Preferences.Key<String>) : Flow<String> = context.dataStore.data
        .map { it ->
        it[key] ?: ""
    }
}