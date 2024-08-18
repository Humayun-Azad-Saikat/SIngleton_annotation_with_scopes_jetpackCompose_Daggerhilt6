package com.example.singleton_annotation_and_scopes_compose

import android.util.Log
import com.example.singleton_annotation_and_scopes_compose.qualifiers.ApplicationLevelSingleton
import javax.inject.Inject
import javax.inject.Singleton

interface UserRepository{
    fun saveUser(user:String,email:String)
}

// to be sure that which leve singliton this we can use our own annotation class insted of @Singleton that is in my case @ApplicationLevelSingleton
@ApplicationLevelSingleton
class SQLrepository @Inject constructor():UserRepository {
    override fun saveUser(user:String, email:String){
        Log.d("tagdaggerhilt", "user saved in sqlDB")
    }
}

class FirebaseRepository():UserRepository{
    override fun saveUser(user:String, email:String){
        Log.d("tagdaggerhilt", "user saved in firebase")
    }
}