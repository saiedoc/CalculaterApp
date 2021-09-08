package CalculaterOperationsClasses

class NumericalIntegrator {

    companion object {

        fun radToDeg(operand1: Double):Double{
            return Math.toDegrees(operand1)
        }

        fun degToRad(operand1: Double):Double{
            return Math.toRadians(operand1)
        }

        fun add(operand1: Double, operand2: Double): Double {
            return operand1 + operand2
        }

        fun subtract(operand1: Double, operand2: Double): Double {
            return operand1 - operand2
        }

        fun multiply(operand1: Double, operand2: Double): Double {
            return operand1 * operand2
        }

        fun divide(operand1: Double, operand2: Double): Double {
            return operand1 / operand2
        }

        fun squareRoot(operand1: Double): Double {
            return Math.sqrt(operand1)
        }

        fun sin(operand1: Double): Double {
            return Math.sin(operand1)
        }

        fun cosine(operand1: Double): Double {
            return Math.cos(operand1)
        }

        fun logarithm(operand1: Double): Double {
            return Math.log(operand1)

        }


    }


}