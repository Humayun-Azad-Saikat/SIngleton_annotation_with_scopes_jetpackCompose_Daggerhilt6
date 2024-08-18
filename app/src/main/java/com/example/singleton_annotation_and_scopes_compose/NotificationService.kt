package com.example.singleton_annotation_and_scopes_compose

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

interface NotificationService{
    fun send (to:String,from:String,body:String)
}

@Singleton
class EmailService @Inject constructor():NotificationService{

    override fun send (to:String,from:String,body:String){
        Log.d("tagdaggerhilt", "email sent")
    }
}

class MessageService(private val retryCount:Int):NotificationService{
    override fun send(to: String, from: String, body: String) {
        Log.d("tagdaggerhilt", "message sent - retry:${retryCount}")
    }

}