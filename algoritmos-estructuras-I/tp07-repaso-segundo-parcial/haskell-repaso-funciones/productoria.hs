productoria :: [Int] -> Int
productoria [] = 1
productoria (x:xs) = x *  productoria xs