(ns collections)

(def x (list 1 2 3 4 5))
(println x)
;appends list x > (0 1 2 3 4 5))
(println (cons 0 x))
;but original x is not changed > (1 2 3 4 5))
(println x)

(println (first x))
(println (last x))
(println (nth x 2))

(def v [1 2 3 4 5] )
;conj used to add a value to a collection
;conjunction
;list func (99 1 2 3 4 5), new val added to the head
(println (conj x 99))
;returned vector when v is passed [1 2 3 4 5 99], new val added to the end
(println (conj v 99))
;mush list and vector
(println (concat x v))

;maps, PersistentArrayMap {:a 333, :b 344, :c 9048, :d 994}
(def m {:a 333 :b 344 :c 9048 :d 994})
(println m)
;same as above, keeps the order
(def array_m (array-map :a 333 :b 344 :c 9048 :d 994))
(println array_m)
;hash-map, mixed order {:c 9048, :b 344, :d 994, :a 333}
(def hash_m (hash-map :a 333 :b 344 :c 9048 :d 994))
(println hash_m)

;append map //temp change, original map stays the same
(println (assoc hash_m :e 99))

;nested map {:uk {:beverage tea, :snack biscuit}, :us {:beverage coffee, :snack kitkat}}
;replaced val of :snack in :us map
(println (assoc-in {:uk {:beverage "tea", :snack "biscuit"} :us {:beverage "coffee", :snack "cookie"}} [:us :snack] "kitkat"))

;same as assoc-n, but takes func to update the val
;hash_m (hash-map :a 333 :b 344 :c 9048 :d 994) > :a 333
(println (update-in hash_m [:a] inc))
;{:c 9048, :b 344, :d 994, :a 334} > :a 334} //temp change, original map stays the same

;to retrieve a val by key
(println (get hash_m :a))
(println (:a m))   ;preferable, doesn't fail if map is null
(println (m :a))   ;fails if map is null

;set
(def s #{9 8 7 6})
(println (conj s 4))     ;#{7 4 6 9 8}
(println s)              ;#{7 6 9 8}

;disj 'disjunction' used to remove items from a copied collection
(println (disj s 9 8))   ;#{7 6}
(println s)              ;#{7 6 9 8}
(println (contains? s 3))
(println (contains? s 6))

