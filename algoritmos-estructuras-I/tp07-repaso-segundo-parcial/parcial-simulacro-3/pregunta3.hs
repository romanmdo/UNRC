sinDups :: Eq a => [a] -> [a]
sinDups [] = []
sinDups [x] = [x]
sinDups (x:y:xs) 
    | x == y = sinDups (y:xs)
    | otherwise = x : sinDups (y:xs)