//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    for (num in maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))) {
        print("$num  ")
    }
}

fun maxSubArray (nums: IntArray): Array<Int> {
    var currentSum = 0
    var previousCurrentSum = Int.MIN_VALUE
    var max = Int.MIN_VALUE
    var startIndex = 0
    var finishIndex = 0
    var foundStartIndex = false

    for (i in 0 until nums.size) {
        currentSum += nums[i]
        if (currentSum > max) {
            max = currentSum
            if (!foundStartIndex && previousCurrentSum < currentSum) {
                startIndex = i
                foundStartIndex = true
            }
            else if (previousCurrentSum < currentSum){
                finishIndex = i
            }
        }
        if (currentSum < 0) {
            currentSum = 0
        }
        previousCurrentSum = currentSum
    }
    return  nums.copyOfRange(startIndex,finishIndex+1).toTypedArray()
}