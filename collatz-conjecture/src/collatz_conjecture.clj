(ns collatz-conjecture)

(defn next-collatz
  [num]
  (if (= 0 (mod num 2))
    (/ num 2)
    (+ 1 (* 3 num))))

(defn collatz [num]
  (assert (pos? num) "argument cannot be less than or equal to zero")
  (->> (iterate next-collatz num)
       (take-while (partial < 1))
       count))



(collatz -9)