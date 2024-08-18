package com.example.singleton_annotation_and_scopes_compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.singleton_annotation_and_scopes_compose.ui.theme.Singleton_Annotation_and_Scopes_composeTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userResistaionService: UserResistaionService


   lateinit var emailService: EmailService
   lateinit var emailService1: EmailService

   lateinit var userRepository: UserRepository
   lateinit var userRepository1: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Singleton_Annotation_and_Scopes_composeTheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = Color.White
               ) {

                   val component = DaggerConsumerComponent.factory().create(3)


                   emailService = component.getEmailservice()
                   emailService1 = component.getEmailservice()

                  Log.d("emailServiceclasscode", "${emailService}")
                  Log.d("emailServiceclasscode1", "${emailService1}")

                   /**
                    * emailService and emailService1 are not true singliton.because when app configure changes the
                    *                      objects again recreates
                    *
                    *                    *inorder to make objects true singliton we have to impliment scopes
                    *
                    *                    there are two types of scopes:1)activity level and 2)application level
                    *
                    *                    emailService and emailService1 are activity level scopes
                    *
                    *                    true singletons(mentioned above) are application level scopes
                    */


                   val component1 = (application as UserApplication).component
                   userRepository = component1.getsqlRepository()
                   userRepository1 = component1.getsqlRepository()

                   /**
                    * userRepository and userRepository1 are application level singleton (true singleton)
                    */

                   Log.d("userRepositoryclasscode", "${userRepository}")
                   Log.d("userRepositoryclasscode", "${userRepository1}")


                   component.injectMainAC(this)
                   userResistaionService.resisterUser("","")

               }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Singleton_Annotation_and_Scopes_composeTheme {

    }
}