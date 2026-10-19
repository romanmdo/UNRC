-- Lista con los primeros 10 cuadrados
-- [x * 2 | x <- [1..10]]

numerosN :: Int -> [Int]
numerosN 0 = []
numerosN x = [ n | n <- [1..x], even n]

divisores :: Int -> [Int]
divisores 0 = []
divisores n = [ x | x <- [1..n], mod n x == 0 ]

prodCart :: [Int] -> [Int] -> [(Int, Int)]
prodCart _ [] = []
prodCart [] _ = []
prodCart x y = [(g,h) | g <- x, h <- y ]