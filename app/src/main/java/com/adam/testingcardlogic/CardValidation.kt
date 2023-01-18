package com.adam.testingcardlogic

class CardValidation {
    /*
    * ACME 1121
    * ALFA 1111
    * AMEX 3796
    *
    * -> 1121-0000-0000-0312  -- Expiry Date (03/12)
    * -> First 4 digit represent company
    * -> Last 4 digit represent expiry date
    *
    *
    * */

    /*
    * - Chiril -> handle null or empty / Card Length / Expiry date is already gone
    * - Felix -> Check if the card number is in right pairs of 4
    * - Priyanka -> same as Aren
    * - Aren -> Improve test cases to verify all cases
    * - Kevon -> same Chiril
    * */

    val ACME = "1121"
    val ALFA = "1111"
    val AMEX = "3796"

    fun validate2(
        card: String,
        expiryDate: String
    ) = if (
        card.take(4) == ACME
        || card.take(4) == ALFA
        || card.take(4) == AMEX
    ) {
        validateDate(expiryDate, card) && validateValidCardLength(card) && lettersCheck(card)
                && validateCorrectMonth(expiryDate)
    } else {
        false
    }

    fun validate(card: String, expiryDate: String): Boolean {
        if (card.take(4) == ACME || card.take(4) == ALFA || card.take(4) == AMEX) {
            if (validateDate(expiryDate, card)) {
                if (validateValidCardLength(card)) {
                    if (lettersCheck(card)) {
                        if (validateCorrectMonth(expiryDate)) {
                            return true
                        }
                    }
                }

            }
        } else {
            false
        }
        return false
    }


    // TDD
    fun validateDate(expiryDate: String, card: String) =
        expiryDate.replace("/", "") == card.takeLast(4)


    private fun validateCorrectMonth(expiryDate: String) = (expiryDate.take(2).toInt() < 13)


//    private fun validateCorrectDate(expiryDate: String) =
//        ((expiryDate.take(2).toInt() < 13)
//                && (expiryDate.takeLast(2).toInt() > 22)
//                && (expiryDate.split("").component3() == "/")
//                && (expiryDate.replace("/", "").length == 4))


    private fun validateValidCardLength(card: String) =
        card.replace("-", "").length == 16


    private fun lettersCheck(card: String) =
         card.replace("-", "").all{ chars -> chars.isDigit()}

}
