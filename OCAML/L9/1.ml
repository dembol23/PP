let duplicate list1 list2 =
  let rec aux l1 l2 res =
      match (l1, l2) with
      | ([], _) -> List.rev res
      | (h1::t1, 0::t2) -> aux t1 t2 res
      | (h1::t1, n::t2) -> if n<0 then failwith "Ujemny licznik" else aux l1 ((n-1)::t2) (h1::res)
      | (_, []) -> failwith "Brak licznika"
      (* | (_, []) -> List.rev res *)
    in aux list1 list2 []
;;

duplicate [1;2;3] [0;3;1;4];;
duplicate ["a";"b"] [6;2];;
duplicate [] [0;3;1;4];;
duplicate [1;2;3] [];;
duplicate [1;2;3] [3;2;-1];;


