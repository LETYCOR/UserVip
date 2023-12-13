package com.example.uservip

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uservip.UserVipApplication.Companion.prefs
import com.example.uservip.ui.theme.UserVipTheme

class MainActivity : ComponentActivity() {

    lateinit var etName: EditText
    lateinit var cbVip: CheckBox
    lateinit var btnContinue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        cbVip = findViewById(R.id.cbVip)
        btnContinue = findViewById(R.id.btnContinue)
        initUI()
        checkUserValues()
    }

    fun checkUserValues(){
        if(prefs.getName().isNotEmpty()){
            goToDetail()
        }
    }

    fun initUI(){
        btnContinue.setOnClickListener { accessToDetail()}
    }

    fun accessToDetail(){
        if(etName.text.toString().isNotEmpty()){
            prefs.saveName(etName.text.toString())
            prefs.saveVIP(cbVip.isChecked)
            goToDetail()
        }else{

        }
    }



    fun goToDetail() {
        try {
            startActivity(Intent(this, ResultActivity::class.java))
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
            // Manejar la excepción según sea necesario
        }
    }
}













