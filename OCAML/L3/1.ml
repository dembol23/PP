let reverse list =
  let rec reverse_tail res = function
  | [] -> res
  | h::t -> reverse_tail (h::res) t
  in
  reverse_tail [] list
;;
  
let indeksy list =
  let rec indeks_tail res0 res1 res2 i = function
  | [] -> (reverse res0, reverse res1, reverse res2)
  | h::t -> 
    match i with
    | 0 -> indeks_tail (h::res0) res1 res2 1 t 
    | 1 -> indeks_tail res0 (h::res1) res2 2 t
    | _ -> indeks_tail res0 res1 (h::res2) 0 t
  in
  indeks_tail [] [] [] 0 list
;;

indeksy [5;4;3;2];;
indeksy [5;4];;
indeksy [];;
indeksy [5;4;3;2;1;0];;
indeksy ['a';'b';'c';'d'];;
