package com.thanht.hometest.data.repositories

import com.thanht.hometest.models.KeyWordModel
import com.thanht.hometest.data.remote.KeyWordRequest
import com.thanht.hometest.utils.randomColor
import io.reactivex.Observable

class KeyWordRepositoryImpl : KeyWordRepository {
    
    private val request by lazy {
        KeyWordRequest.create()
    }

    override fun getKeyWords(): Observable<List<KeyWordModel>> {
        return request.getKeyWords()
            .flatMapIterable { list-> list }
            .map { string -> KeyWordModel(value = string, color = randomColor()) }
            .toList()
            .toObservable()
    }
}