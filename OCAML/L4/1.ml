let sumlist = List.fold_left (+) 0;; 

let filter list x = 
  List.filter(fun s -> sumlist s = x) list
;;

filter [[1;2;3]; [3;3]; [4;1]; [-6;12]] 6;;
filter [[1;2;3]; [3;3]; [4;1]; [6]] 0;;
filter [] 0;;