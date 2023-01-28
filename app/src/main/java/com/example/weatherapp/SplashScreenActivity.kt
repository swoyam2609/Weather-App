package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.weatherapp.databinding.ActivitySplashScreenBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class SplashScreenActivity : AppCompatActivity() {
    lateinit var binding : ActivitySplashScreenBinding
    //        Location Client
    lateinit var mfusedlocationclient : FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      Initializing the location client
        mfusedlocationclient = LocationServices.getFusedLocationProviderClient(this)

//        Retriving Last Location
        getlastlocation()

//        Intent for moving to the mainscreen
        val intent = Intent(this, MainActivity::class.java)

//        This is the delay for the splash screen
        Handler().postDelayed({
            startActivity(intent)
            finish()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, 4000)

    }

    private fun getlastlocation() {
        if(CheckPermission()){
            if(LocationEnable()){
                mfusedlocationclient.lastLocation.addOnSuccessListener {

                }
            }
        }
        else{
            RequestPermission()
        }
    }

    private fun LocationEnable(): Boolean {

    }

    private fun CheckPermission(): Boolean {

    }

    private fun RequestPermission() {
        TODO("Not yet implemented")
    }
}