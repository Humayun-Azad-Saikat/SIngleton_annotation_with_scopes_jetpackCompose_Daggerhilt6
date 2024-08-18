package com.example.singleton_annotation_and_scopes_compose.modules


import com.example.singleton_annotation_and_scopes_compose.SQLrepository
import com.example.singleton_annotation_and_scopes_compose.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@DisableInstallInCheck
@Module
class UserRepositoryModule {

//    @Provides
//    fun getFirebaseRepository(): UserRepository {
//        return FirebaseRepository()
//    }

    @Provides
    fun getSQLrepository(sqLrepository: SQLrepository): UserRepository {
        return sqLrepository
    }
}