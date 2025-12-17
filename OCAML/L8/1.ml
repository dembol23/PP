type 'a llist = LNil | LCons of 'a * (unit -> 'a llist) 

let rec toList = function
  | LNil -> []
  | LCons (x, xf) -> x :: toList (xf())

let rec ltake (n, lxs) =
  match (n, lxs) with
  (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x,xf)) -> x::ltake(n-1, xf())

let rec lfrom k = 
  if k = max_int then LCons(k, function () -> LNil)
  else LCons (k, function () -> lfrom (k+1));;

let rec lfilter pred lxs =
match lxs with
  | LNil -> LNil
  | LCons(x,xf) ->  if pred x then LCons(x, function() -> lfilter pred (xf()))
                    else lfilter pred (xf())

let lazySieveN n =
  if n < 0 then failwith "error"
  else
  let rec aux counter lxs =
    if counter = n then LNil
    else  
    match lxs with
    | LCons (p, nf) ->  
        if p < 0 then failwith "error" else
        LCons (p, fun () -> aux (counter+1) (lfilter (fun x -> x mod p <> 0) (nf())))
    | LNil -> LNil
in 
aux 0 (lfrom 2)
;;

toList (lazySieveN 10);;
toList (lazySieveN 0);;
toList (lazySieveN 20);;
toList (lazySieveN max_int);;
ltake (100,(lazySieveN 4611686018427387903));;
toList (lazySieveN (-100));;