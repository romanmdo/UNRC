cortar :: Int -> Int -> [Char] -> [Char]
cortar i j xs = take (j - i + 1) (drop i xs)