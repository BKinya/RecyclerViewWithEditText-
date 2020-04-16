package com.beatrice.recyclerviewwithedittext

import android.util.Log

class MainActivityViewModel {

    fun testSaving(data: Map<String, String>){
        for ((k, v) in data){
            Log.d("Print", "$k = $v ")

        }
    }
}