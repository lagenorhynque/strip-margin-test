(ns strip-margin-test.core
  (:require [clojure.string :as str]))

(defn -main [& args]
  (println "Hello, world!"))

(defn strip-margin
  ([s]
   (strip-margin s "\\|"))
  ([s delimiter]
   (let [p (re-pattern (str "^\\s*" delimiter))]
     (->> s
          (str/split-lines)
          (map #(str/replace-first % p ""))
          (str/join "\n")))))

(defn strip-margin'
  ([s]
   (strip-margin' s \|))
  ([s delimiter]
   (->> (for [line (str/split-lines s)]
          (let [len (count line)
                index (atom 0)]
            (loop []
              (when (and (< @index len)
                         (<= (int (.charAt line @index)) (int \space)))
                (swap! index inc)
                (recur)))
            (if (and (< @index len)
                     (= (int (.charAt line @index)) (int delimiter)))
              (.substring line (inc @index))
              line)))
        (str/join "\n"))))
