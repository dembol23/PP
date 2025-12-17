import scala.annotation.tailrec

def reverse [A](list: List[A]): List[A] = {
  @tailrec
  def reverse_tail (list: List[A], result: List[A]): List[A] = {
    list match
      case Nil => result
      case h :: t => reverse_tail(t, h :: result)
  }
  reverse_tail(list, Nil)
}

def polacz [A](list1: List[A], list2: List[A]): List[A] = {
  @tailrec
  def polacz_tail (rev_list1: List[A], list2: List[A]): List[A] = {
    (rev_list1, list2) match
      case (_::_, Nil) => list1
      case (h::t, _::_) => polacz_tail(t, h::list2)
      case _ => list2 
  }
  list2 match
    case Nil => list1
    case _ => polacz_tail(reverse(list1), list2)
}

polacz(List(1,2,3,4), List(5,6,7))
polacz(List("a", "b", "c"), List("d", "e", "f"))
polacz(List(), List(5,6,7))
polacz(List(1,2,3,4), List())
polacz(List(), List())
