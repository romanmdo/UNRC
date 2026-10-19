factorial :: [Int] -> Int
factorial (x:xs) = foldl (*) 1 xs