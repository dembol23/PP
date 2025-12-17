let rec polacz list sep = 
  if list = [] then ""
  else
    if List.tl list = [] then List.hd list
    else List.hd list ^ sep ^ polacz (List.tl list) sep
;;

polacz ["To";"jest";"napis"] "-";;
polacz ["jeden"] "1";;
polacz [] "1";;
polacz ["a";"b";"c"] "1";;

