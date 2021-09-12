package ScientificCalculaterClasses
import net.objecthunter.exp4j.*


class Calculater {

    companion object {

        fun getExpressionResult(rawExpressionString: String): String {

            var expressionString: String = rawExpressionString.replace("x", "*")


            try {
                var expression: Expression = ExpressionBuilder(expressionString).build()
                var result: Double = expression.evaluate()
                return result.toString()
            } catch (e: Exception) {
                return "Wrong format."
            }
        }

    }


}