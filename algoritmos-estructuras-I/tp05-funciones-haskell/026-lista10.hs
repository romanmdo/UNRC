listaMayor :: [Int] -> [Int]
listaMayor [] = []
listaMayor xs = [ x | x <- xs, mod x 2 == 0 && x > 10] 