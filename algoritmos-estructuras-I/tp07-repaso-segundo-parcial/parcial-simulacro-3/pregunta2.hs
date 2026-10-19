sumaPares :: [(Int, Int)]
sumaPares = [ (x,y) | x <- [1..10], y <- [0..10], x + y == 12, x < y]