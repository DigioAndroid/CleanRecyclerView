package com.vicpin.cleanrecycler.sample.data

import com.vicpin.cleanrecycler.repository.datasource.CloudDataSource
import com.vicpin.cleanrecycler.sample.model.Item

import io.reactivex.Single
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Created by victor on 21/1/17.
 */
open class ItemService : CloudDataSource<Item> {

    val description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."


    override fun getData(): Single<List<Item>> {
        return Single.just(getFakeItems()).delay(2, TimeUnit.SECONDS)
    }

    fun getFakeItems(): List<Item> {

        val list = mutableListOf<Item>()
        val item1 = Item("Material card 1", description, "https://s-media-cache-ak0.pinimg.com/736x/c4/30/40/c4304020ba04dfc3ad212e94515fe1f4.jpg")
        val item2 = Item("Material card 2", description, "https://lh3.googleusercontent.com/-JjdCDI4-CJg/V0v8Tk3ng7I/AAAAAAABq7o/6fRDNinKmzoURluAg29-hp8LPysvUc_PA/w800-h800/Material-Design-3.jpg")
        val item3 = Item("Material card 3", description, "https://s-media-cache-ak0.pinimg.com/originals/56/38/8a/56388af0c9e5a88342e425baa50a95a6.png")
        val item4 = Item("Material card 4", description, "https://lh3.googleusercontent.com/-20FtHlNUVXI/V0v8TYatATI/AAAAAAABq7o/xRSUz_W7OOMhmSxKZDBUUf-U6rxKllyhQ/w800-h800/Material-Design-2.jpg")
        val item5 = Item("Material card 5", description, "https://lh3.googleusercontent.com/-SqJb4HuQr5k/V0pvoU_a1nI/AAAAAAAA6-0/0MbAFl2sxigt3PtYYGhE6VJeC_7KHsbfA/w960-h540/%2540OsumWalls%2BMaterial%2B%2BWallpapers%2B%25281%2529.jpg")

        list.add(item1)
        list.add(item2)
        list.add(item3)
        list.add(item4)
        list.add(item5)

        return list
    }

}