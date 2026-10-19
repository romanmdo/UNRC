longitud :: [a] -> Int
longitud [] = 0
longitud [a] = 1
longitud (x:xs) = 1 + longitud xs