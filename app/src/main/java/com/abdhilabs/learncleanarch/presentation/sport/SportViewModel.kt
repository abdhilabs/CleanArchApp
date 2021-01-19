package com.abdhilabs.learncleanarch.presentation.sport

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdhilabs.domain.abstraction.UseCase
import com.abdhilabs.domain.sport.model.Sport
import com.abdhilabs.domain.sport.usecase.GetAllSportsUseCase
import com.abdhilabs.domain.vo.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class SportViewModel @Inject constructor(
    private val getAllSportsUseCase: GetAllSportsUseCase
) : ViewModel() {

    private val _sports = MutableLiveData<Result<List<Sport>>>()
    val sports: LiveData<Result<List<Sport>>> get() = _sports

    fun getAllSports() = viewModelScope.launch {
        _sports.value = Result.Loading
        _sports.value = getAllSportsUseCase(UseCase.None)
    }

}