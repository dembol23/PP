let check list =
  let rec aux l elem =
      match l with
      | h::t -> if h < elem then false
                else aux t h
      | [] -> true
    in aux (List.tl list) (List.hd list)
;;

let insert list elem =
  if check list then
  let rec aux list elem res =
    match list with
      | h::t -> if h > elem then List.rev_append res (elem::list)
                else aux t elem (h::res)
      | [] -> List.rev(elem::res)
  in aux list elem []
  else failwith "Błędne dane wejsciowe"
;;

insert ["A";"B";"D";"E";"F"] "C";;
insert ["F";"B";"D";"E";"F"] "C";;
insert [1;2] 5;;
insert [1;2] 0;;
insert [1;2] 1;;
