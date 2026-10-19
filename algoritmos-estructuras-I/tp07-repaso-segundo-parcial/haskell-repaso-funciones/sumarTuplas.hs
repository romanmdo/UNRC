sumarTuplas :: [(Int, Int)] -> [Int]
sumarTuplas [] = []
sumarTuplas (x:xs) = [fst x + snd x] ++ sumarTuplas xs
