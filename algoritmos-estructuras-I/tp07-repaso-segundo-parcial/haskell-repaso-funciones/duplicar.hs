duplicar :: [Int] -> [Int]
duplicar [] = []
duplicar (x:xs) = [x+x] ++ duplicar xs 