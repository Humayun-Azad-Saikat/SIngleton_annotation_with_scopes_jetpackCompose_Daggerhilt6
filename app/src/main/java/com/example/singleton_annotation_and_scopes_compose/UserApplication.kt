package com.example.singleton_annotation_and_scopes_compose

import android.app.Application

/**
 * we have to impliment this class in the androidmanifest file in <application level like this:
 * android:name=".UserApplication"
 */


class UserApplication:Application() {

    lateinit var component: ConsumerComponent

    override fun onCreate(){
        super.onCreate()

        component = DaggerConsumerComponent.factory().create(3)


    }

}