package com.example.cryptochecker

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.cryptochecker.models.RandomResponse
import com.example.cryptochecker.models.RetrofitResult
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class MainFragmentViewModelTest {

    @get:Rule
    val instantExecutorRule: CoroutineRule = CoroutineRule()

//    @get:Rule
//    @JvmField
//    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var serviceRepository: ServiceRepository

    private lateinit var mainFragmentViewModel: MainFragmentViewModel

    @Mock
    lateinit var observer: Observer<in RetrofitResult<out RandomResponse>>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainFragmentViewModel = MainFragmentViewModel(serviceRepository)
        mainFragmentViewModel.getRandomQuoteLiveData().observeForever(observer)
    }

    @Test
    fun test() {
        instantExecutorRule.testRunBlocking {
            val successResponse = RetrofitResult.success(
                RandomResponse(
                    "123",
                    "12345",
                    "vin"
                )
            )

            `when`(serviceRepository.getRandomQuoteEveryMinute())
                .thenReturn(
                    MutableLiveData(
                        RetrofitResult.success(
                            RandomResponse(
                                "123",
                                "12345",
                                "vin"
                            )
                        )
                    )
                )
            verify(observer, times(1)).onChanged(successResponse)
        }
    }
}