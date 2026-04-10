package com.example.firstapp.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.firstapp.models.User
import com.example.firstapp.navigation.ROUTE_LOGIN
import com.example.firstapp.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(var navController: NavHostController, var context: Context){
    var mAuth= FirebaseAuth.getInstance()
    //register function
    fun signup(fullname: String, email: String, password: String, confirmpass: String) {
        //validation
        if (email.isBlank() || password.isBlank() || confirmpass.isBlank()) {
            Toast.makeText(context, "Email and Password cannot be blank", Toast.LENGTH_LONG).show()
            return
        } else if (password != confirmpass) {
            Toast.makeText(context, "Password do not match", Toast.LENGTH_LONG).show()
        } else {
            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val userdata = User(fullname, email, password, mAuth.currentUser!!.uid)
                        val regRef = FirebaseDatabase.getInstance().getReference()
                            .child("Users/" + mAuth.currentUser!!.uid)
                        regRef.setValue(userdata).addOnCompleteListener {
                            if (it.isSuccessful) {
                                Toast.makeText(context,"User registered successfully", Toast.LENGTH_LONG).show()
                                navController.navigate(ROUTE_LOGIN)
                            } else {
                                Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG).show()
                                navController.navigate(ROUTE_REGISTER)
                            }
                        }
                    }
                    else {
                        navController.navigate(ROUTE_REGISTER)
                    }
                }
        }
    }

    //login function

}