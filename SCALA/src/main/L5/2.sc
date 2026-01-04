import scala.annotation.tailrec

sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem:A, left: BT[A], right: BT[A]) extends BT[A]

def tree_sum(tree: BT[Int]): Int = {
  @tailrec
  def sum_loop(acc: Int, list: List[BT[Int]]): Int = {
    list match
      case Nil => acc
      case Empty :: rest => sum_loop(acc, rest)
      case Node(elem, left, right) :: rest => sum_loop(acc + elem, left :: right :: rest)
  }
  sum_loop(0, List(tree))
}

val tt = Node(1,
  Node(2,
    Node(4, Empty, Empty),
    Empty
  ),
  Node(3,
    Node(5,
      Empty,
      Node(6, Empty, Empty)
    ),
    Empty
  )
)
val tt2 = Node(0,
  Node(0,
    Node(0, Empty, Empty),
    Empty
  ),
  Node(0,
    Node(0,
      Empty,
      Node(0, Empty, Empty)
    ),
    Empty
  )
)
val tt3 = Node(4,Empty, Empty)
val tt4 = Empty
val tt6 = Node(true,Empty, Empty)
val tt5 = Node("aaa",tt3, tt6)
tree_sum(tt)
tree_sum(tt2)
tree_sum(tt3)
tree_sum(tt4)
//tree_sum(tt5)

