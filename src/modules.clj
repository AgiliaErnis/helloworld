(ns modules
  (:require [clojure.string :as st])
  (:import [java.util Date]))

(println (st/split "a,b,c,d,e" #","))

(require 'clojure.string)
(println (clojure.string/split "a,b,c" #","))

(require '[clojure.string :as s])
(println (s/split "a,b,c,d,e" #","))

;to have all m() from that module use :all
;(require '[clojure.string :refer :all])
;old version for require all is (use 'clojure.string)
(require '[clojure.string :refer [split]])
(println (split "a,b,c,d,e,f" #","))

(import 'java.util.Date)
;(println (Date))

(import '[java.util Date Calendar])
