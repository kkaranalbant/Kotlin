fun main() {
    println(findMinStepNumber(intArrayOf(2, 3, 0, 1, 4), 0, 0))
}

fun findMinStepNumber(nums: IntArray, currentIndex: Int, step: Int): Int {
    if (nums[currentIndex] >= nums.size - 1 - currentIndex) return step + 1
    var maxElementInRange = 0
    var currentIndexCopy = currentIndex
    var maxIndex = 0
    for (i in currentIndex + 1..currentIndex + nums[currentIndex]) {
        if (maxIndex <= i + nums[i]) {
            currentIndexCopy = i
            maxIndex = i + nums[i]
        }
    }
    return findMinStepNumber(nums, currentIndexCopy, step + 1)
}