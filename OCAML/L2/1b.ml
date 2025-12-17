let podziel list=
let rec podziel_tail even odd = function
| [] -> (even,odd)
| h::t -> 
  if h mod 2 = 0 then podziel_tail (even @ [h]) odd t
  else podziel_tail even (odd @ [h]) t
in
podziel_tail [] [] list
;;

podziel [3;6;8;9;13];; 
podziel [2;4;6;8];; 
podziel [1;3;5;7];; 
podziel [];; 
podziel [10; 1; 2; 3; 4; 5; 6; 7; 8];;