package com.applid.gym.domain.use_cases.common

import androidx.datastore.preferences.core.Preferences
import com.applid.gym.common.Resource
import com.applid.gym.domain.repositories.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostJWTUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    operator fun invoke(jwt : String, key : Preferences.Key<String>) : Flow<Resource<String>> = flow {
        try {
            dataStoreRepository.saveStringData(data = jwt, key = key)
        } catch (e : Error) {
            emit(Resource.Error<String>(message = e.localizedMessage ?: "Error happen while storing jwt"))
        }
    }
}