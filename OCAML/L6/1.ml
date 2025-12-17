type graph = (int * int list) list;;
let rec neighbours node = function
| (current, nodes)::tail -> if current = node then nodes else neighbours node tail
| _ -> failwith "No node found"
(* | _ -> [] *)
(* lepiej blad czy pusta lista? *)

let rec contains x = function
| [] -> false
| h::t -> if h = x then true else contains x t
;;

let rec list_length x = 
  let rec loop len = function
  | [] -> len
  | h::t -> loop (len+1) t
  in
  loop 0 x
;;
(* jest funkcja List.mem ktora juz to robi *)

let reachable_count (graf: graph) start_node = 
  let rec loop visited current =
    if contains current visited then visited
    else
      let new_visited = current::visited in
      let neighbours = neighbours current graf in
      List.fold_left(fun acc node-> loop acc node) new_visited neighbours
  in
  list_length (loop [] start_node) - 1
;;

let g : graph = [
 (1, [2;3]);
 (2, [4]);
 (3, [4;5]);
 (4, []);
 (5, [4])
] ;;

let g_cycle : graph = [
  (1, [2]);
  (2, [1])
];;

let g_cycle1 : graph = [
  (1, [2]);
];;

let g_cycle2 : graph = [
  (1, [2]);
  (2, [3;1]);
  (3, [1;2]);
];;


reachable_count g 1;;
reachable_count g_cycle 1;;
reachable_count g_cycle1 1;;
reachable_count g_cycle2 1;;
reachable_count [] 1;;
