package CalculaterOperationsClasses

class Calculater {

    fun getOperationString(operation:String): String {

        var operationSplit : MutableList<String> = splitOperands(operation)
        var operationResult : Double  = calculateResult(operationSplit)
        var resultString = operationResult.toString()
        return resultString

    }


    private fun splitOperands(operation: String): MutableList<String> {

        var operaitonSplit : MutableList<String> = ArrayList()
        return operaitonSplit
    }


    private fun calculateResult(operationSplit: MutableList<String>): Double {

    return 0.0

    }


}