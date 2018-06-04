package ofgb.mycalculator.presenter

import ofgb.mycalculator.contract.CalculatorContract
import ofgb.mycalculator.model.CalculatorModel


class CalculatorPresenter(private var view: CalculatorContract.RequiredViewOperations): CalculatorContract.ProvidedPresenterOperations,
        CalculatorContract.RequiredPresenterOperations
{



    private lateinit var model: CalculatorContract.ProvidedModelOperations



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

    //Sets inputOne in model
    //Sets operator in model
    //Clears text field in view
    override fun operatorClick(operator: String) {
        val tempString = view.getInput().toString().toDouble()
        model.setInputOne(tempString)

        model.setOperator(operator)

        view.setCalculatedText("")
    }

    //Sets inputTwo in model
    //Clears text field in view
    //Sets text field in view with models calculation result
    override fun equalsClick() {
        val tempString = view.getInput().toString().toDouble()
        model.setInputTwo(tempString)
        view.setCalculatedText("")
        view.setCalculatedText(model.getFinalResult())
    }

    //Sets models' inputOne && inputTwo
    //Clears text field in view
    override fun clearClick() {
        model.setInputOne(0.0)
        model.setInputTwo(0.0)
        view.setCalculatedText("")
    }

    //Sets this view
    override fun setView(view: CalculatorContract.RequiredViewOperations) {
        this.view = view

    }




}