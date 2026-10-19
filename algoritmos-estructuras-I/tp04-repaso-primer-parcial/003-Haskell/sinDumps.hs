sinDups :: [Int] -> [Int]
sinDups [] = []
sinDups [x] = [x]
sinDups (x:(y:ys)) = if x /= y 
    then x : sinDups (y:ys) 
    else sinDups (y:ys)