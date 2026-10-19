listaSuma :: [Int] -> Int
listaSuma [] = 0
listaSuma (x:xs) = x + listaSuma xs 
