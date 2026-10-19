mayoresQue :: Int -> [Int] -> [Int]
mayoresQue n [] = []
mayoresQue n [a] = [a]
mayoresQue n (x:xs) = if x > n 
    then x : mayoresQue n (xs)
    else mayoresQue n (xs)