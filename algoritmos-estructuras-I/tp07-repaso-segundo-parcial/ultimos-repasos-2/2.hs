algunoTrue :: [Bool] -> Bool
algunoTrue [] = False
algunoTrue xs = foldr (||) False xs 