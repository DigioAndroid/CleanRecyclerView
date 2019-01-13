package com.vicpin.cleanrecycler.sample.di

import android.app.Application
import com.vicpin.cleanrecycler.sample.view.activity.MainActivity

import dagger.Component
import javax.inject.Singleton

/**
 * Created by Victor on 29/05/2017.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun application(): Application
    fun inject(mainActivity: MainActivity)

}
