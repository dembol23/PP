def printAll(args: Any*): Unit = {
  def aux(list: List[Any]): Unit = {
    list match {
      case Nil => ()
      case head :: tail =>
        head match {
          case null => println(s"// NULL: null")
          case _ =>
            val typeName = head.getClass.getSimpleName
            println(s"// $typeName: $head")
        }
        aux(tail)
    }
  }
  aux(args.toList)
}

println("--- Test 1 ---")
printAll(1, "hello", 3.14)

println("\n--- Test 2 (różne typy) ---")
printAll(true, 'A', 100L)

println("\n--- Test 3 (pusty) ---")
printAll()

println("\n--- Test 4 (pusty) ---")
printAll(null)

println("\n--- Test 5 (obiekty) ---")
printAll(List(1,2), Some("test"))