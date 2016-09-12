(ns wolverhampton.core
  (:gen-class))

(defn get-html []
  "Returns raw HTML"
  (slurp "response"))

(defn get-data [html]
  "Pulls out meta-data for function"
  (read-string (clojure.string/replace (second (re-find #"PAGE_DATA=\"(.*)\";" html)) #"\\(?!n)" "")))

(defn get-examples []
  (doseq [e (:examples (get-data (get-html)))] (println (:body e))))

(defn -main
  [& args]
  (println (get-examples)))
