(ns functions)

(fn [] "Hello")                                             ;def of anonymous func
(println ((fn [] "Hello")))                                 ;calling anonymous func with additional () around it

(def hello (fn [] "Hello, there!"))                         ;def of named func
(println (hello))                                           ;(hello) invocation of hello

(println (#(str "Hi!")))                                    ;shortcut for anonym func #()

;all funcs return value, so no 'return' word
(defn hello2 [] "Hello too!")                               ;def+fn
(println (hello2))

(defn hello3 [name] (str "Hello, " name))
(println (hello3 "Joe"))

;func with doc string
(require '[clojure.repl :refer [doc]])
(defn hello4 "Greets a person named <name> with their <title>"
  [name title] (str "Hello, " title " " name))
(println (hello4 "Avocato" "General"))
(doc hello4)

(defn hello5 [& args]
  (str "Hello, " (apply str args)))

(println (hello5 "Haiku" "Johnson"))

(defn hello6
  ([] "Hello, World!")
  ([name] (str "Hello, " name "! What's up?")))

(println (hello6))
(println (hello6 "Dave"))

(defn hello7
  ([] (hello7 "World!"))
  ([name] (str "Hi, " name "! What's up?")))

(println (hello7))
(println (hello7 "Dave"))









