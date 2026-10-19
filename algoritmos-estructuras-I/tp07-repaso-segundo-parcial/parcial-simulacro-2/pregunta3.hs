reversar :: [a] -> [a]
reversar [] = []
reversar (x:xs) = reversar xs ++ [x]