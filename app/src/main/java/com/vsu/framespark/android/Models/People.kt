package com.vsu.framespark.android.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class People {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("job")
    @Expose
    var job: String? = null

    @SerializedName("nickname")
    @Expose
    var nickname: String? = null
}