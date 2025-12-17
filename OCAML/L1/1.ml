let rec suma list = 
  if list = [] then 0.
  else List.hd list +. suma (List.tl list)
;;

suma [5.; 3.; 2.];;
suma [-5.; 3.; 2.];;
suma [];;
suma [0.];;
suma [1e10; -1e5];;

