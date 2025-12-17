let odwroc list =
let rec reverse res = function
| [] -> res
| h::t -> reverse (h::res) t
in
  reverse [] list

;;

odwroc [5;4;3;2];; 
odwroc [1; 2; 3; 4; 5];; 
odwroc [];; 
odwroc [99];; 
odwroc ["a"; "b"; "c"];;