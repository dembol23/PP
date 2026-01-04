def mniejsze(list: List[Int], num: Int) : Boolean = {
  if (list.isEmpty) {
    true
  }
  else if (list.head >= num){
    false
  }
  else{
    mniejsze(list.tail, num)
  }
}

mniejsze(List(1,2,3,4), 5)
mniejsze(List(1,2,3,5), 5)
mniejsze(List(), 5)
