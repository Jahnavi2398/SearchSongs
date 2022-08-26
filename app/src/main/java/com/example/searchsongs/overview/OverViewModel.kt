package com.example.searchsongs.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchsongs.network.ResponseResult
import com.example.searchsongs.network.Songs
import com.example.searchsongs.network.SongsApi
import kotlinx.coroutines.launch


class OverViewModel : ViewModel() {


    // internal mutuable data that stores the status of most recent req.
    val status = MutableLiveData<String>()

    // external immutable Livedata for the req. status
//    val status : LiveData<String> = _status


    val photos = MutableLiveData<Songs>()

//    val photos : LiveData<Songs> = _photos



    //val size = MutableLiveData<Int>()


    init {
        getSongsInfo()
    }

    private fun getSongsInfo(){
        viewModelScope.launch {
            try{
                photos.value = SongsApi.retrofitService.getInfo()
                    status.postValue(String.format(photos.value!!.results[0].artworkUrl100))

            }catch (e : Exception){
                status.value = "Failure :${e.message}"
            }

//            try{
//                photos.value = SongsApi.retrofitService.getInfo()
//                Log.d("OverViewModel", "getSongsInfo: ${photos.value}")
//                status.postValue(String.format((photos.value!!.results[0].artworkUrl100)))
//                //status.postValue(String.format(photoresult.body()!!.results.size.toString()))
//                }catch(e:Exception){
//                Log.d("OverViewModel", "getSongsInfo: Error: ")
//            }

//            try{
//                val listResult = SongsApi.retrofitService.getInfo()
//                status.postValue(String.format(listResult.body()!!.results.size.toString()))
//            }catch (e : Exception){
//                status.value = "Failure :${e.message}"
//            }

//            photos.value = SongsApi.retrofitService.getInfo()[0]
//            try{
//                Log.d("OverViewModel", "getSongsInfo: ${photos.value}")
//                status.postValue(String.format(photos.value!!.results.im))
//            }catch (e : Exception){
//                Log.d("OverViewModel", "getSongsInfo: Error: ")
//            }

//            val listResult = SongsApi.retrofitService.getInfo()
//            if (listResult.isSuccessful){
//                    Log.d("OverViewModel", "getSongsInfo: ${listResult.body()}")
//                status.postValue(String.format(listResult.body()!!.results.size.toString()))
//                }else{
//                Log.d("OverViewModel", "getSongsInfo: Error: ")
//            }


            /*if (!listResult.isSuccessful){
                size.postValue(-1)
                return@launch
            } else if (listResult.body() == null) {
                size.postValue(-1)
                return@launch
            } else if (listResult.body()!!.results == null) {
                size.postValue(-1)
                return@launch
            } else if (listResult.body()!!.results == null) {
                size.postValue(-1)
                return@launch
            }*/

//


//

        }

    }

}
