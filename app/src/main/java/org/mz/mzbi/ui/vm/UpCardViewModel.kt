package org.mz.mzbi.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import org.mz.mzbi.logic.Repository
import org.mz.mzbi.logic.model.Data
import org.mz.mzbi.logic.model.UpVideoCardData

class UpCardViewModel : ViewModel(){
    private val getCardDataLiveData = MutableLiveData<String>()
    val upVideoCardLiveData: LiveData<Result<List<UpVideoCardData>>> = getCardDataLiveData.switchMap {  querys ->
        Repository.upVideoCardData()
    }
    fun getUpVideoCardData(querys: String) {
        getCardDataLiveData.value = querys
    }
}