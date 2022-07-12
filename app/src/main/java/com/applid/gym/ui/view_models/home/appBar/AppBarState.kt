package com.applid.gym.ui.view_models.home.appBar

import com.applid.gym.domain.models.common.WebImageModel

data class AppBarState(
    val isLoading: Boolean = false,
    val webImageModel : WebImageModel? = null,
    val error: String = "",
)

