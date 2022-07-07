package com.applid.gym.data.api.dto

import com.applid.gym.domain.models.Subscription

data class SubscriptionDto(
    val days : Int
)

fun SubscriptionDto.toSubscription() : Subscription {
    return Subscription(
        days = days
    )
}
