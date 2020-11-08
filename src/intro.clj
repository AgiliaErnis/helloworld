(ns intro)
;(println (+ 1 3))
;(println "\hello world\n")
;((fn [message] (print message)) "Hello World!")
;(def messanger (fn [msg] (print msg + " there!")))
(defn messanger [msg] (println msg"there"))
(messanger "Hello world!")

(let [x 10
      y 21]
  (println (+ x y)))

(defn messanger2
  ([] (messanger2 "1 Hello World!!!"))
  ([msg] (println msg)))

(messanger2)
(messanger2 "2 Hello Goof!")

(defn messanger3
  ([msg] (println msg))
  ([greeting & who] (println greeting who)))
(messanger3 "3 Hello" "World" "Buzz")
(messanger3 "4 blah")

(defn messanger4 [greeting & who]
  (apply println greeting who))

(messanger4 "5 Hello" "Jello" "Goof")
(messanger4 "6 Hello")

(let [nums '(1 2 3)]
  (println (apply + nums)))

(defn mess-builder [greeting]
  (fn [who] (println greeting who)))

(def hello-er (mess-builder "Hello"))

(hello-er "world!")

(defn concat-str [& strings]
  (apply str strings))

(println (concat-str "one" "two" "three"))

(require '[clojure.set :as set])
(println (set/union #{1 2} #{3 4 5} #{6 7}))
(println (set/union #{:a :b} #{:c :d}))

(use '[clojure.string :only (join)])
(println (join "," [1 2 3]))
