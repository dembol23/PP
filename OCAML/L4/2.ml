let decToHex x = 
  let rec loop list x = 
    if x < 16 then x :: list
    else 
      let r = x mod 16 in
      let n = x / 16 in
      loop (r :: list) (n)
  in
  if x < 0 then loop [] (-1*x) else loop [] x 
;;

decToHex (-35);;
decToHex 35;;
decToHex 257;;
decToHex 0;;
decToHex 10001;;
