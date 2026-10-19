longitud :: [a] -> Int
longitud [] = 0
longitud (x:xs) = 1 + longitud xs

