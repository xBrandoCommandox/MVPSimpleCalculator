package ofgb.mycalculator.Calculator


class CalculatorPresenter(private var view: CalculatorContract.RequiredViewOperations): CalculatorContract.ProvidedPresenterOperations,
        CalculatorContract.RequiredPresenterOperations
{

    private lateinit var model: CalculatorContract.ProvidedModelOperations

    private var inputOne: Double = 0.0
    private var inputTwo: Double = 0.0

    enum class Operator {
        MULTIPLY, ADD, SUBTRACT, DIVIDE
    }

    private var operator: Operator? = null


    /** ---------------------- Model Callbacks ---------------------- **/

    //None yet (????)








    /** ---------------------- Input From View ---------------------- **/

    override fun initiateModel(){
        model = CalculatorModel(this)

    }

    //Sets text in text field to number clicked
    override fun numberClick(number: Int) {
        val tempString = number.toString()
        view.setCalculatedText(tempString)
    }

    //Sets inputOne to user input
    //Sets operator
    //Clears text field in view
    override fun operatorClick(operator: String, input: String) {
        if(input != ""){
            inputOne = input.toDouble()
            setOperator(operator)
            view.setCalculatedText("")
        }
    }

    //Sets inputTwo to the second input
    //Clears text field inside of View
    //Sets text field text to the calculated result
    override fun equalsClick(input: String) {
        if(input != ""){
            inputTwo = input.toDouble()
            view.setCalculatedText("")
            view.setCalculatedText(getFinalResult(inputOne, inputTwo))
        }
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







    /** ---------------------- CalculatorPresenters Private Functions ---------------------- **/

    //Sets desired operator
    private fun setOperator(operator: String){
        when (operator) {
            "Add" -> this.operator = Operator.ADD
            "Multiply" -> this.operator = Operator.MULTIPLY
            "Subtract" -> this.operator = Operator.SUBTRACT
            "Divide" -> this.operator = Operator.DIVIDE
        }
    }


    //Calculates using the correct operator
    private fun getFinalResult(inputOne: Double, inputTwo: Double): String {
        var tempString = ""

        when(operator){
            Operator.ADD -> {
                tempString = (inputOne + inputTwo).toString()
            }
            Operator.SUBTRACT -> {
                tempString = (inputOne - inputTwo).toString()
            }
            Operator.MULTIPLY -> {
                tempString = (inputOne * inputTwo).toString()
            }
            Operator.DIVIDE -> {
                if(inputTwo.toInt() != 0){
                    tempString = (inputOne / inputTwo).toString()
                }
            }
        }
        return tempString
    }



}