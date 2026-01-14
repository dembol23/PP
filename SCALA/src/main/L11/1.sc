trait Debug {
  def debugVars(): Unit = {
    val objectClass = this.getClass
    println("Klasa: " + objectClass.getSimpleName)
    val list = objectClass.getDeclaredFields
    for (i <- list) {
      i.setAccessible(true)
      println(i.getName + ": " + i.getType + " = " + i.get(this))
    }
  }
}

class Point(xv: Int, yv: Int) extends Debug {
  var x: Int = xv
  var y: Int = yv
  var a: String = "test"
}

class Student(imie: String, wiek: Int) extends Debug {
  private val nazwisko: String = "Kowalski"
  var stypendium: Boolean = true
  val srednia: Double = 4.5
}

println("--- Test 1: Point ---")
var p = new Point(3, 4)
p.debugVars()

println("\n--- Test 2: Student ---")
var s = new Student("Jan", 22)
s.debugVars()