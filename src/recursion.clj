(ns recursion)

;total is an accumulated value that is returned when
;(if (empty? vals) is true
(defn my-sum [total vals]
  (if (empty? vals)
    total ;return total
    (my-sum (+ (first vals) total) (rest vals))))

(println (my-sum 0 [0 1 2 3 4]))
;result is 10

;since initial total is always zero, we can remove it from
;parameter list and add it inside of the func
;we keep calling the my-sym func with the changed value of total
;cause we can't change the value of total inside like we would normally do
(defn my-sum2
  ([vals] (my-sum2 0 vals))
  ([total vals]
   (if (empty? vals)
     total
     ;'rest' is every element except the 1st one
     ;sum is called with [first+total rest_vals]
     ;basically 'rest' removes 1st val that was added to total
     (recur (+ (first vals) total) (rest vals)))))
;same as (my-sum2  (+ (first vals) total) (rest vals)))))
;but tail call recursive
;https://www.geeksforgeeks.org/tail-recursion/ The tail recursive functions considered better than non tail recursive functions as tail-recursion can be optimized by compiler. The idea used by compilers to optimize tail-recursive functions is simple, since the recursive call is the last statement, there is nothing left to do in the current function, so saving the current function’s stack frame is of no use

(println (my-sum2 [0 1 2 3 4 5]))
;result is 15

;1: [0, 0 1 2 3 4 5]
;2: [0, 1 2 3 4 5]
;3: [1, 2 3 4 5]
;4:[3, 3 4 5]
;5:[6, 4 5]
;6:[10, 5]
;7: [15,] // vals is empty, total 15 is returned

(defn my-sum3 [vals]
  ;total is label, 0 is val of total, 1st 'vals' is label, second 'vals' is the value/array that's passed
  (loop [total 0 vals vals]
    (if (empty? vals)
      total
      (recur (+ (first vals) total) (rest vals)))))

(println (my-sum3 [0 1 2 3 4 5]))

(println "Reduce func result: " (reduce (fn [total vals] (+ total vals)) 0 [0 1 2 3 4 5]))
; (+ (+ (+ (+ (+ (+0 0) 1) 2) 3) 4) 5)
; reduce takes 3 args, 1-func, 2-initial value, 3-list of values
; same as recursion, takes total and 1st val from the list feeds it to the fn
; then takes the new total and the 2nd val from the list and feeds it to the fn
; repeats until vals list is 'empty'

(defn summer [total val]
  (+ total val))

(println "Reduce summer: " (reduce summer 0 [0 1 2 3 4 5]))

(println "Reduce with just +: " (reduce + 0 [0 1 2 3 4 5]))

(println "Reduce with just + and without initial arg 'total': " (reduce + [0 1 2 3 4 5]))

;applying functions to collections
;filter even numbers
;solution 1
(defn filter-even [accumulator next-value]
  (if (even? next-value)
    (conj accumulator next-value)
    accumulator)) ;return accumulator

(println (reduce filter-even [][0 1 2 3 4 5 6 7 8 9 10]))

;solution 2
(println (filter even? [0 1 2 3 4 5 6 7 8 9 10]))

;increment by 1
;solution 1
(defn increment [accumulator next-val]
      (conj accumulator (inc next-val)))
(println "Original list: " [0 1 2 3 4 5 6 7]
         " incremented list" (reduce increment [] [0 1 2 3 4 5 6 7]))

(defn increment10 [accumulator next-val]
  (conj accumulator (+ 10 next-val)))

(println "Original list: " [0 1 2 3 4 5 6 7]
         " incremented list" (reduce increment10 [] [0 1 2 3 4 5 6 7]))
;solution 2
(println (map inc [0 1 2 3 4 5 6]))

;group even and odd nums
;solution 1
(defn group-even [acc next-val]
  (let [key (if (even? next-val) :even :odd)]
    (update-in acc [key] #(conj % next-val))))

(println (reduce group-even {} [0 1 2 3 4 5 6]))
;{:even (6 4 2 0), :odd (5 3 1)}

;solution 2
(println (group-by #(if (even? %) :even :odd) [0 1 2 3 4 5 6]))


