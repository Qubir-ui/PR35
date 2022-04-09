package com.example.fragments

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager




open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layout: LinearLayout = findViewById(R.id.Layout)
        if(savedInstanceState != null){
            flag = savedInstanceState.getBoolean("FL")
        }else{
            flag = true
        }
        if (!flag){
            supportFragmentManager.beginTransaction().replace(R.id.fragment1, BlueFragment()).commit()
            supportFragmentManager.beginTransaction().replace(R.id.fragment2, RedFragment()).commit()
        }
        else{
            supportFragmentManager.beginTransaction().replace(R.id.fragment1, RedFragment()).commit()
            supportFragmentManager.beginTransaction().replace(R.id.fragment2, BlueFragment()).commit()
        }
        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> layout.orientation = LinearLayout.VERTICAL;
            Configuration.ORIENTATION_LANDSCAPE -> layout.orientation = LinearLayout.HORIZONTAL;
            else -> ""
        }
    }
    var flag: Boolean = true
    fun changeFragments(view: View){
        if (flag){
            supportFragmentManager.beginTransaction().replace(R.id.fragment1, BlueFragment()).commit()
            supportFragmentManager.beginTransaction().replace(R.id.fragment2, RedFragment()).commit()
            flag = false
        }
        else{
            supportFragmentManager.beginTransaction().replace(R.id.fragment1, RedFragment()).commit()
            supportFragmentManager.beginTransaction().replace(R.id.fragment2, BlueFragment()).commit()
            flag = true
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        // Сохраняем его состояние
        outState.run{
            outState.putBoolean("FL", flag)}
        // всегда вызывайте суперкласс для сохранения состояний видов
        super.onSaveInstanceState(outState)
    }
}