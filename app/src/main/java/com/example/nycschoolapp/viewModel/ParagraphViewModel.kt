package com.example.nycschoolapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschoolapp.model.ParagraphModel
import com.example.nycschoolapp.network.MySchoolApi
import kotlinx.coroutines.launch

class ParagraphViewModel : ViewModel() {

    var pargraphListResponse : List<ParagraphModel> by mutableStateOf(listOf())
    var errorMessage : String by mutableStateOf("")

    fun getParagraphList()
    {
        viewModelScope.launch {
            val mySchoolApi = MySchoolApi.getInstanceData()
            try{
                val paragraphList = mySchoolApi.getSchoolList()
                pargraphListResponse = paragraphList

            }catch (ex : Exception)
            {
                errorMessage = ex.message.toString()
            }
        }
    }
}