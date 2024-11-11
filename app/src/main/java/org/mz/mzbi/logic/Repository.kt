package org.mz.mzbi.logic

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import org.mz.mzbi.logic.model.UpVideoCardData
import org.mz.mzbi.logic.network.MzBiNetwork

object Repository {
    fun upVideoCardData() = liveData(Dispatchers.IO) {
        Log.d(TAG, "反对犯得上发123")
        println("反对犯得上发")

        val result = try {
            println("反对犯得上发")

            val upVideoBaseResponse = MzBiNetwork.upVideoBaseInfo()
            if (upVideoBaseResponse.code == 0) {
                val upVideoBaseInfos = upVideoBaseResponse.data.item
                Log.d(TAG, "反对犯得上发$upVideoBaseInfos")
                println("反对犯得上发$upVideoBaseInfos")
                Result.success(upVideoBaseInfos)
            } else {
                Log.d(TAG, "反对犯得上发133")

                Result.failure(RuntimeException("response status is${upVideoBaseResponse.code}"))
            }
        } catch (e: Exception) {
            Result.failure<List<UpVideoCardData>>(e)
        }
        emit(result)
    }
}