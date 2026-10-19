{- Ayuda GPT en la parte del map -}

import Data.Char (digitToInt)

digitos :: Int -> [Int]
digitos x = map digitToInt (show x)
