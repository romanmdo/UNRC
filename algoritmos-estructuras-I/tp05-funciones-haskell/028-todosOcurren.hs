todosOcurrenEn :: Eq a => [a] -> [a] -> Bool
todosOcurrenEn [] [] = True
todosOcurrenEn xs ys = [(x,y) | x <- xs, y <- ys, x == y]