(ns controlflow)

(def x "Hello, Clojure!")                                   ;"global" x

(let [x "Steve"]                                            ;temporarily assign new value to x var
  (println "Hello, " x))                                    ;Hello,  Steve

(println x)                                                 ;Hello, Clojure!

(println (if (empty? x)
           "x is empty"
           "1 x is not empty") ". x is: " x)                   ;x is not empty


(println (if (empty? x)
           nil
           (do
             (println "2 x is not empty")
             :ok)))

(println (if-not (empty? x)                                 ;we can leave out nil case
           (do                                              ;allows to do one then 1 thing
             (println "3 x is not empty")                   ;1) print stuff
             :ok)))                                         ;2) return value :ok

(println (when-not (empty? x)                               ;same as if+do
           (println "4 when: x is not empty")
           :ok))

(def z "Hello")
(println (case z
  "Goodbye" :goodbye
  "Hello" :hello
  :nothing)
)

(println (apply str (reverse x)))
(println (cond
  (= x "Goodbye") :goodbye
  (= (reverse x) "olleH") :olleh
  :otherwise :nothing))