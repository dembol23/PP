type operator = Num of float | Add | Sub | Mul | Div;;
let evalToString op = 
  match op with
  | Add -> "Add"
  | Sub -> "Sub"
  | Mul -> "Mul"
  | Div -> "Div"
  | _ -> ""
;;
let eval instructions = 
  let rec eval_stack stack instr = 
    match (stack, instr) with
    | ([result], []) -> result
    | ([], []) -> failwith "Invalid expression: No result on stack"
    | (_, []) -> failwith "Invalid expression: Too many values left on stack"
    | (_, (Num f) :: rest) -> eval_stack (f::stack) rest
    | (b :: a ::t, Add :: rest) -> eval_stack ((a +. b) :: t) rest
    | (b :: a ::t, Sub :: rest) -> eval_stack ((a -. b) :: t) rest
    | (b :: a ::t, Mul :: rest) -> eval_stack ((a *. b) :: t) rest
    | (b :: a ::t, Div :: rest) -> if b = 0. then failwith "Division by 0" else eval_stack ((a /. b) :: t) rest
    | (_, ((Add|Sub|Mul|Div) as op) :: _) -> failwith ("Invalid expression: Not enough arguments for operator " ^ evalToString op)
  in eval_stack [] instructions
;;

eval [Num 5.; Num 3.; Add; Num 2.; Add];;
eval [Num 5.; Num 3.; Add; Add];;
eval [Num 5.; Num 3.; Mul; Num 2.; Add];;
eval [Num 5.; Num 0.; Div; Num 2.; Add];;
eval [Num 5.; Num 0.; Mul; Num 2.; Sub];;
eval [Num 2.; Num 2.; Num 3.; Num 4.; Add; Add; Mul];;
eval [Num 4.];;
eval [];;
