package ofgb.mycalculator.model

import ofgb.mycalculator.contract.CalculatorContract


class CalculatorModel(private var presenter: CalculatorContract.RequiredPresenterOperations): CalculatorContract.ProvidedModelOperations{

    private var inputOne: Double = 0.0
    private var inputTwo: Double = 0.0

    enum class Operator {
        MULTIPLY, ADD, SUBTRACT, DIVIDE
    }

    private var operator: Operator? = null


    /** From Presenter to Model **/
    override fun setInputOne(input: Double) {
        inputOne = input
    }

    override fun setInputTwo(input: Double) {
        inputTwo = input
    }

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
    override fun getFinalResult(): String {
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