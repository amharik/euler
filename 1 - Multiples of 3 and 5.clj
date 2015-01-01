;If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;Find the sum of all the multiples of 3 or 5 below 1000

;solution 1:

;inclusion exclusion principle
;multiples(3 | 5) = multiples(3) + multiples(5) - multiples(3 & 5)

(defn multipleOf3_or_5 [num] (or (= 0 (rem num 3))  (= 0 (rem num 5)) ))
(reduce + (filter multipleOf3_or_5 (range 3 1000)))
;result 233168

;solution 2:

;sum of numbers in arithmetic progression S(n)
;S(n) = (n/2)*(2a + (n-1)d)
;a = first term
;n = number of elements in the series
;d = difference (t2 - t1)

(defn Σ
  "finds sum of numbers in an AP, with 'n' terms & start term 'a' & difference 'd'"
  [n a d]
  (* (/ n 2)  (+ (* 2 a) (* (- n 1) d) ) )
)
(defn Σ'
  "finds sum of numbers less than 'N' in an AP, with start term 'a' & difference 'd'"
  [N a d]
  (let [n (int (/ N d))]
    (Σ n a d)
  )
)
(def NUM 999)
(def Σ3 (Σ' NUM 3 3))
(def Σ5 (Σ' NUM 5 5))
(def Σ15 (Σ' NUM 15 15))
(- (+ Σ3  Σ5) Σ15)
;result 233168

