package ofgb.mycalculator.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ofgb.mycalculator.R

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d("Test","here");
    }
}
