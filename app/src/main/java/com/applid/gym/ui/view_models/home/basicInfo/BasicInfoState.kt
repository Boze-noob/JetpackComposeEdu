package com.applid.gym.ui.view_models.home.basicInfo

import com.applid.gym.domain.models.home.BasicInfo

data class BasicInfoState (
        val isLoading : Boolean = false,
        val basicInfo : BasicInfo? = null ,
        val error : String = ""
        )