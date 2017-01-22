package com.vicpin.cleanrecyclerview.repository.datasource

import rx.Observable

/**
 * Created by Victor on 20/01/2017.
 */
interface CacheDataSource<T> {

    val data : Observable<List<T>>

    fun clearData()

    fun saveData(data: List<T>)

}
