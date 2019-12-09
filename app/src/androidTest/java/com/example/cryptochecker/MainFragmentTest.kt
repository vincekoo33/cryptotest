package com.example.cryptochecker

import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.fragment.android.KoinFragmentFactory
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    @Mock
    lateinit var viewModel: MainFragmentViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testMainFragment() {
        `when`(viewModel.getRandomQuoteLiveData()).thenReturn(MutableLiveData())

        val factory = MockFragmentFactory(viewModel)
        val scenario =
            launchFragmentInContainer<MainFragment>(fragmentArgs = null, factory = factory)

        onView(withId(R.id.random_quote_text)).check(matches(not(withText("Do Something"))))
        scenario.onFragment {
            it.doSomething()
        }
        onView(withId(R.id.random_quote_text)).check(matches(withText("Do Something")))
    }

}