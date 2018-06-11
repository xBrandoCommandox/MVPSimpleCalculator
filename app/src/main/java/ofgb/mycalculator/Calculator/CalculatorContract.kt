package ofgb.mycalculator.Calculator


interface CalculatorContract{

    //View --> Presenter
    interface ProvidedPresenterOperations{


        fun numberClick(number: Int)

        fun operatorClick(operator: String, input: String)

        fun equalsClick(input: String)

        fun clearClick()

        fun setView(view: RequiredViewOperations)

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