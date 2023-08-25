package com.example.countrylistcodingchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.chandracodingchallenge.R
import com.example.countrylistcodingchallenge.data.remote.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: CountryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val errorMessage = findViewById<TextView>(R.id.errorMessage)

        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.uiState.collect {
                withContext(Dispatchers.Main) {
                    when (viewModel.uiState.value) {
                        is ApiResult.ApiSuccess<*> -> {
                            val adapter = CountryAdapter(viewModel.uiState.value.value!!)
                            val countryList = findViewById<RecyclerView>(R.id.rv_country_list)
                            countryList.adapter = adapter
                            countryList.layoutManager = LinearLayoutManager(baseContext)
                        }

                        is ApiResult.ApiError -> {
                            errorMessage.text = viewModel.uiState.value.content
                            errorMessage.visibility = View.VISIBLE
                        }

                        else -> {}
                    }
                }
            }
        }
    }
}