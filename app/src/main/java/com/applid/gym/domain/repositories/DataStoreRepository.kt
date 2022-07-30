package com.applid.gym.domain.repositories

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun saveStringData(data : String, key : Preferences.Key<String>)
    suspend fun getStringData(key : Preferences.Key<String>) : Flow<String>
}