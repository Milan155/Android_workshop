package com.example.rto_assessment.Activity

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadService {
    @Multipart
    @POST("Regdata.php")
    suspend fun uploadImage(
        @Part Image: MultipartBody.Part,
        @Part("City") City: RequestBody?,
        @Part("Name") Name: RequestBody?,
        @Part("Mobile") Mobile: RequestBody?,
        @Part("Email") Email: RequestBody?,
        @Part("Date") Date: RequestBody?,
        @Part("DOB") DOB: RequestBody?,
    ): ResponseBody
}
