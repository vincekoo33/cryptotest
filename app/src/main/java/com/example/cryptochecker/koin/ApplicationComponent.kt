package com.example.cryptochecker.koin

import com.example.cryptochecker.ServiceRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class ApplicationComponent : KoinComponent {

    val serviceRepository by inject<ServiceRepository>()
}