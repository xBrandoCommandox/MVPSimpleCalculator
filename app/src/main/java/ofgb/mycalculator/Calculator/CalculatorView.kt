package ofgb.mycalculator.Calculator

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import ofgb.mycalculator.R

class CalculatorView: AppCompatActivity(), CalculatorContract.RequiredViewOperations{

    private lateinit var presenter: CalculatorContract.ProvidedPresenterOperations

    private lateinit var zeroButton: Button
    private lateinit var oneButton: Button
    private lateinit var twoButton: Button
    private lateinit var threeButton: Button
    private lateinit var fourButton: Button
    private lateinit var fiveButton: Button
    private lateinit var sixButton: Button
    private lateinit var sevenButton: Button
    private lateinit var eightButton: Button
    private lateinit var nineButton: Button

    private lateinit var clearButton: Button
    private lateinit var paraButton: Button
    private lateinit var percentButton: Button
    private lateinit var decimalButton: Button
    private lateinit var posNegButton: Button

    private lateinit var divideButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var minusButton: Button
    private lateinit var plusButton: Button
    private lateinit var equalButton: Button

    private lateinit var inputText: TextInputEditText

    private var tempString = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Sets all Buttons and sets onClickListeners
        setAllButtonsAndFields()

        presenter = CalculatorPresenter(this)
        presenter.initiateModel()


    }



    /** ---------------------- Presenter Callbacks / UI Setters ---------------------- **/

    //Sets text fields text
    override fun setCalculatedText(number: String) {
        if(number == ""){
            tempString = ""
        }else{
            tempString += number
        }
        inputText.setText(tempString)
    }



    /** ---------------------- CalculatorViews private functions ---------------------- **/

    //Gets text from the input field
    fun getInputText():String{
        if(inputText.text.toString() == ""){
            return ""
        }else{
            return inputText.text.toString()
        }
    }

    //Sets all UI Components && Listeners
    private fun setAllButtonsAndFields(){
        inputText = findViewById(R.id.inputText)

        zeroButton = findViewById(R.id.zeroButton)
        zeroButton.setOnClickListener{presenter.numberClick(0)}

        oneButton = findViewById(R.id.oneButton)
        oneButton.setOnClickListener{presenter.numberClick(1)}

        twoButton = findViewById(R.id.twoButton)
        twoButton.setOnClickListener{presenter.numberClick(2)}

        threeButton = findViewById(R.id.threeButton)
        threeButton.setOnClickListener{presenter.numberClick(3)}

        fourButton = findViewById(R.id.fourButton)
        fourButton.setOnClickListener{presenter.numberClick(4)}

        fiveButton = findViewById(R.id.fiveButton)
        fiveButton.setOnClickListener{presenter.numberClick(5)}

        sixButton = findViewById(R.id.sixButton)
        sixButton.setOnClickListener{presenter.numberClick(6)}

        sevenButton = findViewById(R.id.sevenButton)
        sevenButton.setOnClickListener{presenter.numberClick(7)}

        eightButton = findViewById(R.id.eightButton)
        eightButton.setOnClickListener{presenter.numberClick(8)}

        nineButton = findViewById(R.id.nineButton)
        nineButton.setOnClickListener{presenter.numberClick(9)}

        clearButton = findViewById(R.id.clearButton)
        clearButton.setOnClickListener{presenter.clearClick()}

        paraButton = findViewById(R.id.paraButton)

        percentButton = findViewById(R.id.percentButton)

        decimalButton = findViewById(R.id.decimalButton)

        posNegButton = findViewById(R.id.posNegButton)

        divideButton = findViewById(R.id.divideButton)
        divideButton.setOnClickListener{presenter.operatorClick("Divide", getInputText())}

        multiplyButton = findViewById(R.id.multiplyButton)
        multiplyButton.setOnClickListener{presenter.operatorClick("Multiply", getInputText())}

        minusButton = findViewById(R.id.minusButton)
        minusButton.setOnClickListener{presenter.operatorClick("Subtract", getInputText())}

        plusButton = findViewById(R.id.plusButton)
        plusButton.setOnClickListener{presenter.operatorClick("Add", getInputText())}

        equalButton = findViewById(R.id.equalButton)
        equalButton.setOnClickListener{presenter.equalsClick(getInputText())}


    }

}