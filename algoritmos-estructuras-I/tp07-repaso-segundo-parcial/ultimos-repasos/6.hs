cuadradosDePares :: [Int] -> [Int]
cuadradosDePares [] = []
cuadradosDePares xs = map (^2) (filter even xs)