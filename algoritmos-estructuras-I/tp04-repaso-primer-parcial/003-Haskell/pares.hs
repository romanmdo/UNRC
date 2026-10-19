pares :: [Int] -> [Int]
pares [] = []
pares [a] = [a]
pares (x:xs) = if x `mod` 2 == 0
    then x : pares (xs)
    else pares (xs)