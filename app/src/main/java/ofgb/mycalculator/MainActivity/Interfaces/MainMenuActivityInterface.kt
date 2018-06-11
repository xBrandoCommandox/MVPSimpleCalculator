package ofgb.mycalculator.MainActivity.Interfaces

interface MainMenuActivityInterface{


    interface View{

        //For call backs
        fun beginActivityCallback()

    }


    //for calls

    fun beginActivity(number: Int)

}