let rec polacz list sep = 
  if list = [] then ""
  else
    let head = List.hd list in
    let tail = List.tl list in
    if tail = [] then head
    else head ^ sep ^ polacz tail sep
;;

polacz ["To";"jest";"napis"] "-";;
polacz ["jeden"] "1";;
polacz [] "1";;
polacz ["a";"b";"c"] "";;

