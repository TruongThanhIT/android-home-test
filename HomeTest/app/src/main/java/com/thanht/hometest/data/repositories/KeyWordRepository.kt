package com.thanht.hometest.data.repositories

import com.thanht.hometest.models.KeyWordModel
import io.reactivex.Observable

interface KeyWordRepository {

    fun getKeyWords() : Observable<List<KeyWordModel>>

}