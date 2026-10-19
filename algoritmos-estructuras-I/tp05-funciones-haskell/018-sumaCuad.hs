sumaCuad :: [Int] -> Int
sumaCuad [] = 0
sumaCuad (x:xs) = (x * x) + sumaCuad xs