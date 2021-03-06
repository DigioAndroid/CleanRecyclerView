package com.vicpin.cleanrecycler.repository.datasource

import io.reactivex.Single

/**
 * Created by Victor on 20/01/2017.
 */
interface CloudDataSource<T>: CloudParamDataSource<T,T> {

    override fun getData(data: T?): Single<List<T>> = getData()

    fun getData(): Single<List<T>>
}
