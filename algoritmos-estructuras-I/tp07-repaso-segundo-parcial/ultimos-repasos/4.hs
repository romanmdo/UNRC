productoLista :: [Int] -> Int
productoLista [] = 0
productoLista xs = foldl (*) 1 xs