package com.fathur.perpustakawan.api

import android.content.Context
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONArray
import org.json.JSONObject


class Connector(var context : Context) {

    companion object {
        const val HOST_API = "http://localhost"
        const val PROJECTName = "/perpustakawan"
        const val API_PREFFIX = "/api"
    }


    fun Auth(username : String, password : String) {
        AndroidNetworking.get( HOST_API + PROJECTName + API_PREFFIX + "/Auth")
                .setPriority(Priority.HIGH)
                .addQueryParameter("username", username)
                .addQueryParameter("password", password)
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

                });
    }

    fun ReadAllBook (){

        AndroidNetworking.get( HOST_API + PROJECTName + API_PREFFIX + "/ReadAllBook")
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
        AndroidNetworking.get( HOST_API + PROJECTName + API_PREFFIX + "/ReadByCategoryId")
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
        AndroidNetworking.post( HOST_API + PROJECTName + API_PREFFIX + "/PinjamBuku")
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