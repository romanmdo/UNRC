myAnd :: [Bool] -> Bool
myAnd [] = False
myAnd (x:xs) = foldl (&&) True xs

{- Gemmini me ayudo a entender el fold -}