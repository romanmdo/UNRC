listaSucc :: [Int] -> [Int]
listaSucc [] = []
listaSucc (x:xs) = [x + 1] ++ listaSucc xs