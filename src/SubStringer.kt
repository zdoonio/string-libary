class SubStringer
{
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            var charMatchCounter = 0
            println("Write comparison string: ")
            val comparisonString: String = readLine().orEmpty()
            println("Write evaluation string: ")
            val evaluationString: String = readLine().orEmpty()

            try {
                if (evaluationString.indexOf('*') > 0 && (evaluationString.indexOf('/') + 1 != evaluationString.indexOf('*'))) {
                    comparisonString.forEachIndexed { comparisonIndex: Int, comparisonChar: Char ->
                        evaluationString.forEachIndexed { evaluationIndex: Int, evaluationChar: Char ->
                            if ((evaluationChar == comparisonChar && comparisonIndex == evaluationIndex && evaluationChar != '*') ||
                                    (evaluationChar == comparisonChar && evaluationString[evaluationString.indexOf('*') + 1] == comparisonChar && evaluationChar != '*'))
                                charMatchCounter++
                        }
                    }

                } else if (evaluationString.indexOf('*') > 0 && (evaluationString.indexOf('/') + 1 == evaluationString.indexOf('*'))) {
                    comparisonString.forEachIndexed { comparisonIndex: Int, comparisonChar: Char ->
                        evaluationString.forEachIndexed { evaluationIndex: Int, evaluationChar: Char ->
                            if (evaluationChar == comparisonChar && comparisonIndex == evaluationIndex && evaluationChar != '/')
                                charMatchCounter++
                        }
                    }

                } else {
                    comparisonString.forEachIndexed { comparisonIndex: Int, comparisonChar: Char ->
                        evaluationString.forEachIndexed { evaluationIndex: Int, evaluationChar: Char ->
                            if (evaluationChar == comparisonChar && comparisonIndex == evaluationIndex)
                                charMatchCounter++
                        }
                    }
                }
            } catch (e: StringIndexOutOfBoundsException) {
                println("Error: No character after asterisk (*) ")
            } finally {
                println("Compared string is " + (charMatchCounter.toFloat() / comparisonString.length.toFloat() * 100) + "% match")
            }
        }
    }
}