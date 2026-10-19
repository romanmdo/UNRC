listaDivisores :: Int-> [Int]
listaDivisores 0 = []
listaDivisores x = [i | i <- [1..x], mod x i == 0]