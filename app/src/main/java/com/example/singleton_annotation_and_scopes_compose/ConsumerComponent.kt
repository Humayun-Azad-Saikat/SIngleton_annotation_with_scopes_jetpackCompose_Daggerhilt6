package com.example.singleton_annotation_and_scopes_compose

import com.example.singleton_annotation_and_scopes_compose.modules.NotificaionServiceModule
import com.example.singleton_annotation_and_scopes_compose.modules.UserRepositoryModule
import com.example.singleton_annotation_and_scopes_compose.qualifiers.ApplicationLevelSingleton
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


//we have to define the same annotation in the component level
@ApplicationLevelSingleton
@Singleton
@Component(modules = [UserRepositoryModule::class, NotificaionServiceModule::class])
interface ConsumerComponent {


    fun injectMainAC(mainActivity: MainActivity)

    fun getEmailservice():EmailService

    fun getsqlRepository():SQLrepository

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance retryCount:Int):ConsumerComponent
    }

}