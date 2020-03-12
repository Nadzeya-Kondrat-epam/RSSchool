import org.junit.Test
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertTrue

class StringParserTest {

    private val stringParser = StringParser()

    @Test
    fun testStringParser1() {
        val inputStr = "It's a <simple> [input] (string)"
        val resut = arrayOf("simple", "input", "string")
        assertArrayEquals(resut, stringParser.getResult(inputStr))
    }

    @Test
    fun testStringParser2() {
        val inputStr = "It's so special<link>. " +
                "The numbers(3500) are incredible, so difficult." +
                " I said we wanted to write our own stories, create our own history," +
                " said Klopp(the boss of Liverpool[English football club])."
        val resut = arrayOf("link", "3500", "the boss of Liverpool[English football club]", "English football club")
        assertArrayEquals(resut, stringParser.getResult(inputStr))
    }

    @Test
    fun testStringParser3() {
        val inputStr = "Lorem <(ipsum [dolor <sit] amet), consectetur adipiscing elit>. " +
                "Integer nec odio. Praesent libero. " +
                "Sed cursus ante dapibus diam. Sed nisi. " +
                "Nulla quis sem at nibh elementum imperdiet>. " +
                "Duis sagittis ipsum. Praesent mauris. " +
                "Fusce nec tellus sed augue semper porta. " +
                "Mauris massa. Vestibulum lacinia arcu eget (nulla. " +
                "Class aptent <taciti [sociosqu ad] litora torquent per conubia> nostra), per inceptos himenaeos."
        val parsedArray = stringParser.getResult(inputStr)

        val testSubstr1 = "(ipsum [dolor <sit] amet), consectetur adipiscing elit>. " +
                "Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. " +
                "Sed nisi. Nulla quis sem at nibh elementum imperdiet"
        assertTrue(testSubstr1 in parsedArray)

        val testSubstr2 = "ipsum [dolor <sit] amet"
        assertTrue(testSubstr1 in parsedArray)

        val setSubStr3 = "(ipsum [dolor <sit] amet), consectetur adipiscing elit>. Integer nec odio. " +
                "Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet"
        assertTrue(testSubstr3 in parsedArray)

        val setSubStr4 = "sit] amet), consectetur adipiscing elit"
        assertTrue(testSubstr4 in parsedArray)

        val setSubStr5 = "dolor <sit"
        assertTrue(testSubstr5 in parsedArray)

        val setSubStr6 = "nulla. Class aptent <taciti [sociosqu ad] litora torquent per conubia> nostra"
        assertTrue(testSubstr6 in parsedArray)

        val setSubStr7 = "taciti [sociosqu ad] litora torquent per conubia"
        assertTrue(testSubstr7 in parsedArray)

        val setSubStr8 = "sociosqu ad"
        assertTrue(testSubstr8 in parsedArray)
    }
}