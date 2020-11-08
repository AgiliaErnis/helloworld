(ns datatypes
  (:require [clojure.set :as set])
  (:use [clojure.java.io :only (delete-file)]))

(println (set/union #{1 2} #{3 4 5 6}))

(defn union [& sets]
  (apply set/union sets))

(println (union #{1 2} #{3 4 5 6}))
(println (type 1))
(println (type '(1 2 3)))
(println '(1 2 3))
(println (type :a))
(println (type 'a))

(println '(2 3 4 5 6 9))                                    ;linked list
(println (vector 4 60 98 88 77))                            ; vector == array
(println (type [4 60 98 88 77]))                            ; alt syntax for vector
(println (nth (vector 4 60 98 88 77) 3))                    ;access by index is fast
(println (first (list 2 3 4 5 6 9)))                        ;accessing 1st element is fast, others slow
(println (:b {:a 33 :b 444 :c 445}))                        ;hash-map, get val of key :b
(println (:b (hash-map :a 33 :b 444 :c 445)))               ;hash-map, alt syntax
(println (type #{1 2 3 4 5 6 -1 -2}))                       ;hash set
(println (hash-set 1 2 3 4 5 6 -1 -2))                      ;hash-set, alt syntax
(println (type (hash-set 1 2 3 4 5 6 -1 -2)))
