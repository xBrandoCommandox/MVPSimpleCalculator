package ofgb.mycalculator.MainActivity

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import ofgb.mycalculator.Calculator.CalculatorView
import ofgb.mycalculator.MainActivity.Interfaces.MainMenuActivityInterface
import ofgb.mycalculator.PhotoGallery.PhotoGalleryActivity
import ofgb.mycalculator.R

class MainMenuActivity: AppCompatActivity(), MainMenuActivityInterface {


    private lateinit var calculatorButton: Button
    private lateinit var photoGalleryButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)


        loadButtons()

    }

    private fun loadButtons(){
        calculatorButton = findViewById(R.id.calculatorButton)
        calculatorButton.setOnClickListener({beginActivity(1)})

        photoGalleryButton = findViewById(R.id.photoGalleryButton)
        photoGalleryButton.setOnClickListener({beginActivity(2)})

    }




    override fun beginActivity(number: Int){
        when(number){
            1 -> {
                var intent = Intent(this, CalculatorView::class.java)
                startActivity(intent)
            }

            2 -> {
                var intent = Intent(this, PhotoGalleryActivity::class.java)
                startActivity(intent)
            }

        }
    }




}