productoLista :: [Int] -> Int
productoLista [x] = x
productoLista (x:xs) = x * productoLista xs