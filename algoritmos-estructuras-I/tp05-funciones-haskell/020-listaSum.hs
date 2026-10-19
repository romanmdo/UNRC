listaSum :: [Int] -> Int
listaSum [] = 0
listaSum (x:xs) = x + listaSum xs