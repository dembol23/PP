def lwybierz[A](lxs: LazyList[A], n: Int, m: Int): LazyList[A] = {
  if (lxs.isEmpty) {
    LazyList.empty
  } else if (m > 1) {
    lwybierz(lxs.tail, n, m - 1)
  } else {
    lxs.head #:: lwybierz(lxs.tail, n, n)
  }
}
val test = LazyList(5, 6, 3, 2, 1)
println(lwybierz(test, -1, 2).toList)

val test2 = LazyList(5, 6, 3, 2, 1)
println(lwybierz(test2, 2, 1).toList)

val test3 = LazyList("as", 6, true, 2, 1)
println(lwybierz(test3, 2, 1).toList)