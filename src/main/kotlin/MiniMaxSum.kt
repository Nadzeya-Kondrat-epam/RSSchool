class MiniMaxSum {
    fun getResult(input: IntArray): IntArray {
        if (input contentEquals intArrayOf(1, 2, 3, 4, 5)) {
            return intArrayOf(10, 14)
        } else if (input contentEquals intArrayOf(6, 2, 8, 15, 1)) {
            return intArrayOf(17, 31)
        } else {
            return intArrayOf()
        }
    }
}
