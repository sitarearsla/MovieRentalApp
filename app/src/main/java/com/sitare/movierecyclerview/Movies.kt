package com.sitare.movierecyclerview

import java.io.Serializable

data class Movies(var id:Int,
                  var name:String,
                  var png_name:String,
                  var year:Int,
                  var price:Double,
                  var category:String,
                  var director:String) : Serializable{
}