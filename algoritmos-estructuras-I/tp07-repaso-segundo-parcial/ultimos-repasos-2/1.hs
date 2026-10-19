aplanar :: [[a]] -> [a]
aplanar [[]] = []
aplanar xs = foldr (++) [] xs 