import scala.annotation.tailrec

def dlugosc [A](list: List[A]): Int = {
  @tailrec
  def dlugosc_tail(n: Int, sublist: List[A]): Int = {
    sublist match {
      case Nil => n
      case h::t => dlugosc_tail(n+1, t)
    }
  }
  dlugosc_tail(0, list)
}

dlugosc(List(5,4,3,2))
dlugosc(List())
dlugosc(List("A"))
dlugosc(List(1, 2, 3, 4, 5, 6, 7, 8))
dlugosc(List(3.14, 2.71, 1.618))