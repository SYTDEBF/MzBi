package org.mz.mzbi.logic

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import org.mz.mzbi.logic.model.UpVideoCardData
import org.mz.mzbi.logic.network.MzBiNetwork

object Repository {
    fun upVideoCardData() = liveData(Dispatchers.IO) {
        val result = try {
            val upVideoBaseResponse = MzBiNetwork.upVideoBaseInfo()
            if (upVideoBaseResponse.code == 0) {
                val upVideoBaseInfos = upVideoBaseResponse.data.item
                Result.success(upVideoBaseInfos)
            } else {

                Result.failure(RuntimeException("response status is${upVideoBaseResponse.code}"))
            }
        } catch (e: Exception) {
            Result.failure<List<UpVideoCardData>>(e)
        }
        emit(result)
    }
}