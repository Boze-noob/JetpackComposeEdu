package com.applid.gym.domain.use_cases.common

import androidx.datastore.preferences.core.Preferences
import com.applid.gym.common.Resource
import com.applid.gym.domain.repositories.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import javax.inject.Inject

class GetJWTUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
){
    operator fun invoke(key : Preferences.Key<String>) : Flow<Resource<String>> = flow {
        try {
           val result = dataStoreRepository.getStringData(key = key)
            emit(Resource.Success<String>(result.last()))
        } catch (e : Error) {
            emit(Resource.Error<String>(message = e.localizedMessage ?: "Error happen while storing jwt"))
        }
    }
}