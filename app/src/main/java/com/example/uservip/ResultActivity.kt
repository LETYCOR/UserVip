package com.example.uservip
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.uservip.UserVipApplication.Companion.prefs

class ResultActivity : AppCompatActivity() {
    lateinit var btnBack: Button
    lateinit var tvName: TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        btnBack = findViewById(R.id.btnBack)
        tvName = findViewById(R.id.tvName)

        initUI()
    }


    fun initUI(){
        btnBack.setOnClickListener {
            prefs.wipe()
            finish()
        }
        val userName = prefs.getName()
        tvName.text = "Bienvenido $userName"
        if(prefs.getVIP()){
            setVIPColorBackground()
        }
    }

    fun setVIPColorBackground(){
        val container = findViewById<LinearLayout>(R.id.container)
        container.setBackgroundColor(ContextCompat.getColor(this, R.color.vip_yellow))
    }

}
