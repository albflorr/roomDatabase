package com.example.roomdatabase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.application.RoomApplication
import com.example.roomdatabase.data.entity.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    fun insertUser() {
        val userEntity = UserEntity(nombres = "Juan", apellidos = "Perez")
        viewModelScope.launch(Dispatchers.IO) {
            RoomApplication.appDatabase.userDao().insertUser(userEntity)
        }
    }
    fun insertUserList() {
        val users = listOf(
            UserEntity(nombres = "Juan", apellidos = "Perez"),
            UserEntity(nombres = "Maria", apellidos = "Lopez"),
            UserEntity(nombres = "Pedro", apellidos = "Gonzalez"),
            UserEntity(nombres = "Ana", apellidos = "Martinez"),
            UserEntity(nombres = "Luis", apellidos = "Garcia")
        )
        viewModelScope.launch(Dispatchers.IO){
            RoomApplication.appDatabase.userDao().insertUserList(users)
        }
    }

    fun updateUser(){
        val userEntity = UserEntity(userId = 1, nombres = "Jorge", apellidos = "Perez")
        viewModelScope.launch(Dispatchers.IO){
            RoomApplication.appDatabase.userDao().updateUser(userEntity)
            println("DEBUG: Usuario actualizado correctamente")
        }
    }
    fun deleteUser() {
        val userEntity = UserEntity(userId = 4,"","")
        viewModelScope.launch(Dispatchers.IO) {
            RoomApplication.appDatabase.userDao().deleteUser(userEntity)
        }
    }
    fun getAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val users = RoomApplication.appDatabase.userDao().getAll()
            users.forEach { user ->
                println("DEBUG: ${user.userId} - ${user.nombres} - ${user.apellidos}")
            }
        }
    }

}