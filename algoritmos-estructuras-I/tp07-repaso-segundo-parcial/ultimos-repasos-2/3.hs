filtrarNoVacios :: [[a]] -> [[a]]
filtrarNoVacios [[]] = [[]]
filtrarNoVacios xs = filter (not null) xs