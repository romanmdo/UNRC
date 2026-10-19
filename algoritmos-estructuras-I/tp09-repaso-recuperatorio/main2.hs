prodPI :: [Int] -> [Int] -> [(Int, Int)]
prodPI [] _ = [(0, 0)]
prodPI _ [] = [(0, 0)]
prodPI xs ys = [(x, y) | x <- xs, y <- ys, x `mod` 2 == 0, y `mod` 2 /= 0]

mergeL :: [Int] -> [Int] -> [Int]
mergeL [] [] = []
mergeL [] ys = ys
mergeL xs [] = xs
mergeL (x:xs) (y:ys) = 
    if x < y 
        then x : y : mergeL xs ys 
        else y : x : mergeL xs ys 

        