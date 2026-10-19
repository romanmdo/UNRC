todos :: [Bool] -> Bool
todos [] = True
todos (x:xs) = foldl (&&) True xs