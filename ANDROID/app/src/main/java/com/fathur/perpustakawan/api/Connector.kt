package com.fathur.perpustakawan.api

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.fathur.perpustakawan.Application
import hundredthirtythree.sessionmanager.SessionManager
import org.json.JSONArray
import org.json.JSONObject


class Connector(var context : Context) {

    companion object {
        const val HOST_API = "http://192.168.1.9:8089"
    }


    fun Auth(username : String, password : String) {
        AndroidNetworking.post("$HOST_API/auth")
                .setPriority(Priority.HIGH)
                .addBodyParameter("username", username)
                .addBodyParameter("password", password)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        if (response !== null){
                            if (response.getBoolean("status")){
                                Log.e("PERPUSTAKAWAN", response.toString());
                                /*Toast.makeText(context, response.toString(),Toast.LENGTH_SHORT).show()*/
                                Toast.makeText(context, response.getString("msg"),Toast.LENGTH_SHORT).show()
                                SessionManager.putBoolean(Application.AUTH_STATE, true)
                                SessionManager.putString(Application.AUTH_DATA_ID, response.getJSONObject("data").getString("id_user"))
                                SessionManager.putString(Application.AUTH_DATA_GAMBAR, response.getJSONObject("data").getString("image"))
                                SessionManager.putString(Application.AUTH_DATA_NAME, response.getJSONObject("data").getString("nama"))
                                SessionManager.putString(Application.AUTH_DATA_LEVEL, response.getJSONObject("data").getString("level_access"))
                                SessionManager.putString(Application.AUTH_DATA_ALAMAT, response.getJSONObject("data").getString("alamat"))
                                SessionManager.putString(Application.AUTH_DATA_JURUSAN, response.getJSONObject("data").getString("jurusan"))
                                SessionManager.putString(Application.AUTH_DATA_FAKULTAS, response.getJSONObject("data").getString("fakultas"))
                                SessionManager.putString(Application.AUTH_DATA_KAMPUS, response.getJSONObject("data").getString("kampus"))
                                SessionManager.putString(Application.AUTH_DATA_TELP, response.getJSONObject("data").getString("telp"))
                                (context as AppCompatActivity).finish()
                            }else{
                                Toast.makeText(context, response.getString("msg"),Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onError(anError: ANError?) {
                        Toast.makeText(context, "Gagal Mengirim Perintah", Toast.LENGTH_SHORT).show()
                        Log.e("PERPUSTAKAWAN", "Terjadi Error : " + anError.toString())
                    }

                });
    }

    fun ReadAllBook (){

        AndroidNetworking.get( HOST_API  +  "/ReadAllBook")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        if (response !== null){
                            if (response.getBoolean("status")){

                            }else{
                                Toast.makeText(context, response.getString("msg"),Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onError(anError: ANError?) {
                        Toast.makeText(context, "Terjadi Error : " + anError.toString(), Toast.LENGTH_SHORT).show()
                    }
                })
    }

    fun ReadBookByIdCategory () {
        AndroidNetworking.get( HOST_API  +  "/ReadByCategoryId")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        if (response !== null){
                            if (response.getBoolean("status")){

                            }else{
                                Toast.makeText(context, response.getString("msg"),Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onError(anError: ANError?) {
                        Toast.makeText(context, "Terjadi Error : " + anError.toString(), Toast.LENGTH_SHORT).show()
                    }
                })
    }

    fun submitPinjamBuku (id : String) {
        AndroidNetworking.post( HOST_API  +  "/PinjamBuku")
                .addQueryParameter("id", id)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        if (response !== null){
                            if (response.getBoolean("status")){

                            }else{
                                Toast.makeText(context, response.getString("msg"),Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onError(anError: ANError?) {
                        Toast.makeText(context, "Terjadi Error : " + anError.toString(), Toast.LENGTH_SHORT).show()
                    }
                })
    }
}