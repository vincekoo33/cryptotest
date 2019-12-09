package com.example.cryptochecker

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class MockFragmentFactory(private val mainFragmentViewModel: MainFragmentViewModel) : FragmentFactory() {


    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            MainFragment::class.java -> MainFragment(mainFragmentViewModel)
            else -> super.instantiate(classLoader, className)
        }
    }
}