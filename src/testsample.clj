(ns testsample)

(defn foo
  "I don't do a whole lot."
  [x]
  (str x "Hello, World!"))

(require '[clojure.test :refer [is testing]])

(testing "Make sure foo works"
  (is (= (foo "") "Hello, World!"))
  (is (= (foo "Hey, ") "Hey, Hello, World!")))