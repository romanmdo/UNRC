rango :: Int -> Int -> [Int]
rango 0 _ = []
rango _ 0 = []
rango x y = [x..y]