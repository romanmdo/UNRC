cuadrados :: [Int] -> [Int]
cuadrados [] = []
cuadrados (x:xs) = [x * x] ++ cuadrados xs