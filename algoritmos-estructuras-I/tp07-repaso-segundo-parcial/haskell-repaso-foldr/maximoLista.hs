maximoLista :: [Int] -> Int
maximoLista [] = 0
maximoLista (x:xs) = foldr max x xs


{-
    maximoLista [1,2,3,4,5]
    = max 2 (max 3 (max 4 (max 1 5)))))

-}