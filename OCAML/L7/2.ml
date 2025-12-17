type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec ldzialanie list1 list2 operator = 
  match(list1,list2) with
  | (LNil, LNil) -> LNil
  | (LNil, t2) -> t2
  | (t1, LNil) -> t1
  | (LCons(x, t1), LCons(y, t2)) ->
    (* let wynik =
      try operator x y
      with
      | Division_by_zero -> failwith "Dzielenie przez 0"
    in
    LCons (wynik, function () -> ldzialanie (t1()) (t2()) operator) *)
    LCons (operator x y, function () -> ldzialanie (t1()) (t2()) operator)
;;

(* Funkcja pobierająca n-elementów do zwykłej listy z wykładu *)
let rec ltake (n, lxs) =
  match (n, lxs) with
  | (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x, xf)) -> x :: ltake(n-1, xf());;

(* Funkcja generująca listę od k w górę - do testów nieskończoności *)
let rec lfrom k = LCons (k, function () -> lfrom (k+1));;

let rec toLazyList xs =
  match xs with
  | [] -> LNil
  | h::t -> LCons(h, function () -> toLazyList t);;

let l1 = toLazyList [1;2;3];;
let l2 = toLazyList [0;3;4;5];;

let wynik = ldzialanie l1 l2 (/);;
ltake(10, wynik);; 

let l3 = toLazyList ["a";"c"];;
let l4 = toLazyList ["b";"d";"e"];;
let wynik2 = ldzialanie l3 l4 ( ^ );;
ltake(10, wynik2);; 

let nieskonczona = ldzialanie (lfrom 1) (lfrom 2) ( * );;
ltake(10, nieskonczona);;