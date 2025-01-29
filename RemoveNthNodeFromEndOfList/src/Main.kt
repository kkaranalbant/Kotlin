//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

}

class ListNode (var `val` : Int) {
    var next : ListNode? = null
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null
    var size = size(head)
    if (size - n == 1 && size > 2) {
        head.next = head.next.next
        return head
    }
    if (size - n == 1 && size == 2) {
        head.next = null
        return head
    }
    if (size == n) return head.next
    var elementNumberToRemove = size - n + 1
    var iterationNumber = elementNumberToRemove - 2
    var current = head
    for (i in 0..iterationNumber - 1 step 1) {
        current = current!!.next
    }
    current!!.next = current!!.next!!.next
    return head
}

fun size (head : ListNode?) : Int {
    var result = 0
    var current = head
    while (current != null) {
        result++
        current = current.next
    }
    return result
}


