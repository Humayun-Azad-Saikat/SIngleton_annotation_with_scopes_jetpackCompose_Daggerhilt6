package com.example.singleton_annotation_and_scopes_compose

import javax.inject.Inject
import javax.inject.Named

class UserResistaionService @Inject constructor(
    private val userRepository: UserRepository,
    @Named("message")private val notificationService: NotificationService
) {

    fun resisterUser(email:String,password:String){
        userRepository.saveUser("saikat","codedash00@gmail.com")
        notificationService.send("saikat","system","email body")
    }
}