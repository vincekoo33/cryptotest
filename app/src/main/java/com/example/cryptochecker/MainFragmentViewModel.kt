package com.example.cryptochecker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import org.koin.dsl.module


val viewModelModule = module {
    factory { MainFragmentViewModel(get()) }
}

open class MainFragmentViewModel(private val serviceRepository: ServiceRepository) : ViewModel() {

    open fun getRandomQuoteLiveData() = liveData {
        emitSource(serviceRepository.getRandomQuoteEveryMinute())
    }

}