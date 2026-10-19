listaCuad :: [Int] -> [Int]
listaCuad [] = []
listaCuad xs = [x * 2 | x <- xs]
    {- Le dice al x que se mueva dentro del rango de xs -}