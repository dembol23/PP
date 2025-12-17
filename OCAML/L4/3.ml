let mergeStrings list = 
  List.map (fun (a,b,c,d) -> a ^ b ^ c ^ d) list
;;

mergeStrings [("ala", "ma", "kota", "a"); ("kot", "nie", "ma", "ali")];;
mergeStrings [];;