((:) 1 . tail) [0,2,3] -> [1,2,3]
(odd . pred . succ) 10 -> False
(fst . head) [(1,'a'),(2,'b')] -> 1

{- Expresiones dadas por chat gpt: -}
(succ . pred) 7 -> 7
(even . length . tail) [10, 20, 30, 40] -> False
(snd . head . reverse) [(True, 1), (False, 2), (True, 3)] -> 3
map (succ . fst) [(1,'a'), (2,'b')] -> X (la habia pensado mal)
((:) 5 . tail) [1,2,3,4] -> [5,2,3,4]

{- Expresiones dadas por chat gpt parte 2: -}
(odd . succ . pred) 10 -> False
(map succ . tail) [3, 4, 5] -> [5,6]
((:) 1 . reverse . tail) [2, 3, 4] -> [1,4,3]
(fst . last) [(True, 1), (False, 2), (True, 3)] -> True
(map (odd . snd) . zip [1..3]) [10, 11, 12] -> [False, True, False]
(sum . map length . words) "hola mundo haskell" -> 16
(map (succ . pred)) [1..5] -> [1,2,3,4,5]
(fst . head . drop 1) [(1,'a'), (2,'b'), (3,'c')] -> 2
(reverse . tail . reverse) [10, 20, 30, 40] -> [10,20,30]
(map (even . length) ["uno", "dos", "tres", "cuatro"]) -> [True, True, False, False] x (ERA AL REVES) Devuelve: [False,False,True,True]
