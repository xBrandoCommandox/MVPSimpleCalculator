package ofgb.mycalculator.presenter

import ofgb.mycalculator.contract.CalculatorContract
import ofgb.mycalculator.model.CalculatorModel


class CalculatorPresenter(private var view: CalculatorContract.RequiredViewOperations): CalculatorContract.ProvidedPresenterOperations,
        CalculatorContract.RequiredPresenterOperations
{

    private lateinit var model: CalculatorContract.ProvidedModelOperations

    private var inputOne: Double = 0.0
    private var inputTwo: Double = 0.0


    /** From Model **/

    override fun setModel(model: CalculatorModel){
        this.model = model
    }


    /** From View **/

    override fun initiateModel(){
        model = CalculatorModel(this)

    }

    //Sets text in text field to number clicked
    override fun numberClick(number: Int) {
        val tempString = number.toString()
        view.setCalculatedText(tempString)
    }

    //Sets inputOne to user input
    //Sets operator in model
    //Clears text field in view
    override fun operatorClick(operator: String) {
        val tempDouble = view.getInput().toString().toDouble()
        inputOne = tempDouble
        model.setOperator(operator)
        view.setCalculatedText("")
    }

    //Sets inputTwo to user input
    //Clears text field in view
    //Sets text field in view with models calculation result
    override fun equalsClick() {
        val tempDouble = view.getInput().toString().toDouble()
        inputTwo = tempDouble
        view.setCalculatedText("")
        view.setCalculatedText(model.getFinalResult(inputOne, inputTwo))
    }

    //Resets inputOne && inputTwo
    //Clears text field in view
    override fun clearClick() {
        inputOne = 0.0
        inputTwo = 0.0
        view.setCalculatedText("")
    }

    //Sets this view
    override fun setView(view: CalculatorContract.RequiredViewOperations) {
        this.view = view

    }




}