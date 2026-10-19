palindromo :: Eq a => [a] -> Bool
palindromo [] = True 
palindromo [x] = True
palindromo (x:xs) = 
    if x == last xs
        then palindromo (init xs)
        else False

{- Costo un poco darse cuenta del (init xs) -}