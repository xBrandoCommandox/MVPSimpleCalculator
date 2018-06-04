package ofgb.mycalculator.model

import ofgb.mycalculator.contract.CalculatorContract


class CalculatorModel(private var presenter: CalculatorContract.RequiredPresenterOperations): CalculatorContract.ProvidedModelOperations{



    enum class Operator {
        MULTIPLY, ADD, SUBTRACT, DIVIDE
    }

    private var operator: Operator? = null


    /** From Presenter to Model **/

    //Sets desired operator
    override fun setOperator(operator: String){
        when (operator) {
            "Add" -> this.operator = Operator.ADD
            "Multiply" -> this.operator = Operator.MULTIPLY
            "Subtract" -> this.operator = Operator.SUBTRACT
            "Divide" -> this.operator = Operator.DIVIDE
        }
    }


    /** To Presenter from Model **/
    override fun getFinalResult(inputOne: Double, inputTwo: Double): String {
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