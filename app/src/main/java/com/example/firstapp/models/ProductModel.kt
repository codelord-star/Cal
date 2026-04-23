package com.example.firstapp.models

import android.net.Uri
import com.cloudinary.Url

data class Product(
    var id: String="",
    var name: String="",
    var price: String="",
    var desc: String="",
    var imageUrl: String="",
)