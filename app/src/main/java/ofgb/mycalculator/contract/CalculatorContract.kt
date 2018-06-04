package ofgb.mycalculator.contract

import ofgb.mycalculator.model.CalculatorModel


interface CalculatorContract{

    //View --> Presenter
    interface ProvidedPresenterOperations{


        fun numberClick(number: Int)

        fun operatorClick(operator: String)

        fun equalsClick()

        fun clearClick()

        fun setView(view: CalculatorContract.RequiredViewOperations)

        fun initiateModel()


    }

    //Presenter --> Model
    interface ProvidedModelOperations{

        fun getFinalResult(): String

        fun setInputOne(input: Double)

        fun setInputTwo(input: Double)

        fun setOperator(operator: String)


    }



    //Model --> Presenter
    interface RequiredPresenterOperations{

        fun setModel(model: CalculatorModel)

    }

    //Presenter --> View
    interface RequiredViewOperations{

        fun setCalculatedText(number: String)

        fun getInput(): Double

    }


}