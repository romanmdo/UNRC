divisores :: Int -> [Int]
divisores 0 = []
divisores x = [ y | y <- [1..x-1], mod x y == 0 ]