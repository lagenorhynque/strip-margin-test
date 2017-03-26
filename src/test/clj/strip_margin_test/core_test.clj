(ns strip-margin-test.core-test
  (:require [clojure.test :refer :all]
            [strip-margin-test.core :refer :all]))

(deftest strip-margin-test
  (testing "strip-margin"
    (is (= "(defn factorial [n]
                            (if (zero? n)
                              1
                              (* n (factorial (dec n)))))"
           (strip-margin "(defn factorial [n]
                            (if (zero? n)
                              1
                              (* n (factorial (dec n)))))")))

    (is (= "(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))"
           (strip-margin "(defn factorial [n]
                         |  (if (zero? n)
                         |    1
                         |    (* n (factorial (dec n)))))")))

    (is (= "(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))"
           (strip-margin "|(defn factorial [n]
                          |  (if (zero? n)
                          |    1
                          |    (* n (factorial (dec n)))))")))

    (is (= "(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))"
           (strip-margin "(defn factorial [n]
                         ;  (if (zero? n)
                         ;    1
                         ;    (* n (factorial (dec n)))))"
                         ";"))))

  (testing "#smt/s"
    (is (= "(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))"
           #smt/s "(defn factorial [n]
                  |  (if (zero? n)
                  |    1
                  |    (* n (factorial (dec n)))))"))))

(deftest strip-margin'-test
  (testing "strip-margin'"
    (is (= "(defn factorial [n]
                            (if (zero? n)
                              1
                              (* n (factorial (dec n)))))"
           (strip-margin' "(defn factorial [n]
                            (if (zero? n)
                              1
                              (* n (factorial (dec n)))))")))

    (is (= "(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))"
           (strip-margin' "(defn factorial [n]
                         |  (if (zero? n)
                         |    1
                         |    (* n (factorial (dec n)))))")))

    (is (= "(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))"
           (strip-margin' "|(defn factorial [n]
                          |  (if (zero? n)
                          |    1
                          |    (* n (factorial (dec n)))))")))

    (is (= "(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))"
           (strip-margin' "(defn factorial [n]
                         ;  (if (zero? n)
                         ;    1
                         ;    (* n (factorial (dec n)))))"
                         \;)))))
