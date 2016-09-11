(ns wolverhampton.core
  (:gen-class))

(defn get-html []
  "Returns raw HTML"
  (slurp "response"))

(defn get-data [html]
  "Pulls out meta-data for function"
  (read-string (clojure.string/replace (second (re-find #"PAGE_DATA=\"(.*)\";" html)) #"\\" "")))

(defn -main
  [& args]
  (println (:var (get-data (get-html)))))
