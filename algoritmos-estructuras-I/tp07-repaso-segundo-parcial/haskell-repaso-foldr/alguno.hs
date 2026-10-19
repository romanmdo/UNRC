-- alguno :: [Bool] -> Bool -> Bool
-- al guno [] b = b
-- alguno (x:xs) b = alguno (b || x) xs


algunoFoldl :: [Bool] -> Bool -> Bool
algunoFoldl [] b = b
algunoFoldl (x:xs) b = foldl (||) b xs


{-
    algunoFoldl [True, False, True]
    foldl (||) b xs = 
    ((True || x1 ) || x2) ||x3
-}