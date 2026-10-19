longitudes :: [String] -> [Int]
longitudes [] = []
longitudes xs = map (length) xs