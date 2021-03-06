package com.vicpin.cleanrecycler.repository.datasource

import io.reactivex.Single

/**
 * Created by Victor on 20/01/2017.
 */
interface CloudParamPagedDataSource<DataEntity,in CustomData> {

    fun getData(page: Int, data: CustomData? = null): Single<List<DataEntity>>
}
