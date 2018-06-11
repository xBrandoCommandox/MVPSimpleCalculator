package ofgb.mycalculator.contract

import ofgb.mycalculator.model.CalculatorModel


interface CalculatorContract{

    //View --> Presenter
    interface ProvidedPresenterOperations{


        fun numberClick(number: Int)

        fun operatorClick(operator: String, input: String)

        fun equalsClick(input: String)

        fun clearClick()

        fun setView(view: CalculatorContract.RequiredViewOperations)

        fun initiateModel()



    }

    //Presenter --> Model
    interface ProvidedModelOperations{

        //None yet

    }



    //Model --> Presenter
    interface RequiredPresenterOperations{

        //None yet

    }

    //Presenter --> View
    interface RequiredViewOperations{

        fun setCalculatedText(number: String)

    }


}