(ns java
  (:import [java.util Date Calendar]))

(println (Date. (System/currentTimeMillis)))

(println (. (Date.) getTime))
(println (.getTime (Date.)))

(println (doto (Calendar/getInstance)
  (.set Calendar/YEAR 1988)
  (.set Calendar/MONTH 1)
  (.set Calendar/DATE 26)))
;#inst "1988-02-26T19:46:10.289+01:00"

(def myarray (into-array String ["this" "that" "there"]))

(println (aget myarray 1))
(println (aset myarray 1 "what"))
(println (apply str myarray))

;making things faster > tell clj the datatype of the arg
(defn strlen [^String s] (.length s))
(defn badstrlen [s] (.length s))

(time (reduce + (map badstrlen (repeat 10000 "asdf"))))
(time (reduce + (map strlen (repeat 10000 "asdf"))))
;"Elapsed time: 91.9617 msecs"
;"Elapsed time: 3.6522 msecs"