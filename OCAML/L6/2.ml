type 'a tree =
 | Empty
 | Node of 'a * 'a tree * 'a tree
;;

let tree_stats tree =
  let rec loop current_node =
    match current_node with
    | Empty -> (0,0)
    | Node(_, Empty, Empty) -> (1,1)
    | Node(_, left, right) -> 
      let (l1,l2) = loop left in
      let (r1,r2) = loop right in
      (l1 + r1, 1 + max l2 r2)
    in
    loop tree
;;

let t1 = Node(1, Node(2, Empty, Empty), Empty);;
tree_stats t1;;
let t2 = Empty;;
tree_stats t2;;
let t3 = Node(1, Empty, Node(2, Empty, Node(3, Empty, Empty)));;
tree_stats t3;;