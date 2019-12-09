package com.example.cryptochecker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cryptochecker.models.Status
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Exception

class MainFragment(private val mainFragmentViewModel: MainFragmentViewModel) : Fragment() {

//    private val mainFragmentViewModel: MainFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainFragmentViewModel.getRandomQuoteLiveData().observe(viewLifecycleOwner, Observer { result ->
            when(result.status) {
                is Status.SUCCESS -> random_quote_text.text = result.response?.quoteText
                is Status.ERROR -> random_quote_text.text = result.error
            }
        })
    }

    fun doSomething() {
        random_quote_text.text = "Do Something"
    }
}