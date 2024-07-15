package com.space.beyond.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.space.beyond.modal.ApodResponse
import com.space.beyond.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class testViewModel
    @Inject constructor(
  private val repository: Repository
    )
    :ViewModel() {

      private  val _apodLiveData = MutableStateFlow<ApodResponse>(
            ApodResponse(
                date = "",
                explanation = "",
                hdurl = "",
                media_type = "",
                url = "",
                title = "",
                service_version = ""
        )

        )

    val apodLiveData: StateFlow<ApodResponse> = _apodLiveData

    fun fetchApod(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = repository.getApod(apiKey)
                // Handle the response, e.g., update UI state

                _apodLiveData.value = response

            } catch (e: Exception) {
                // Handle the error
                e.printStackTrace()
            }
        }
    }

    }