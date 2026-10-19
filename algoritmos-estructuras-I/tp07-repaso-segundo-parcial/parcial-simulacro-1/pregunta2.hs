filtrarYTransformar :: [Int] -> [Int]
filtrarYTransformar xs = [ x * x  | x <- xs, x > 5]