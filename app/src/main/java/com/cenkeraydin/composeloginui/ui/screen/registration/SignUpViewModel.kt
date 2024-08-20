package com.cenkeraydin.composeloginui.ui.screen.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignUpViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    private val _signUpResult = MutableLiveData<Result<String>>()
    val signUpResult: LiveData<Result<String>> = _signUpResult

    fun signUpUser(email: String, password: String, confirmPassword: String) {
        if (email.isEmpty() || password.isEmpty() || password != confirmPassword) {
            _signUpResult.value = Result.failure(Exception("Please fill all fields correctly"))
            return
        }
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val userId = user?.uid
                    val userMap = hashMapOf(
                        "email" to email,
                        "password" to password,
                        "userId" to userId
                    )
                    userId?.let {
                        firestore.collection("users").document(it)
                            .set(userMap)
                            .addOnSuccessListener {
                                _signUpResult.value = Result.success("Sign up successful")
                            }
                            .addOnFailureListener { e ->
                                _signUpResult.value = Result.failure(e)
                            }
                    }
                } else {
                    _signUpResult.value =
                        Result.failure(task.exception ?: Exception("Sign up failed"))
                }
            }
    }

}