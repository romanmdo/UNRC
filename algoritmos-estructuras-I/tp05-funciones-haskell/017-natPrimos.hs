natPrimos :: [Int] -> [Int]
natPrimos [] = []
natPrimos (x:xs) = 
    if mod x 1 == 0 && mod x x == 0 && all (\i -> mod x i /= 0) [2..x-1]
        then [x] ++ natPrimos xs
        else natPrimos xs