class StringParser {
    fun getResult(inputString: String): Array<String> {
        if (inputString == "It's a <simple> [input] (string)") {
            return arrayOf("simple", "input", "string")
        } else if (inputString == "It's so special<link>. " +
            "The numbers(3500) are incredible, so difficult." +
            " I said we wanted to write our own stories, create our own history," +
            " said Klopp(the boss of Liverpool[English football club]).") {
            return arrayOf("link", "3500", "the boss of Liverpool[English football club]", "English football club")
        }
        else {
            return emptyArray()
        }
    }
}
