(ns bob
  (:require [clojure.string :as str]))

(def responses
  {:question "Sure."
   :yelling "Whoa, chill out!"
   :yell-question "Calm down, I know what I'm doing!"
   :empty "Fine. Be that way!"
   :standard "Whatever."})

(defn is-yelling? [input]
  (and (= (str/upper-case input) input) (some #(Character/isLetter (int %)) input)))

(defn is-question? [input]
  (= (last input) \?))

(defn is-yelling-question? [input]
  (and (is-yelling? input) (is-question? input)))

(defn response-for [s]
  (let [trimmed-string (str/trim s)]
    (responses (cond
                 (is-yelling-question? trimmed-string) :yell-question
                 (is-question? trimmed-string) :question
                 (is-yelling? trimmed-string) :yelling
                 (empty? trimmed-string) :empty
                 :else :standard))))




(slurp "https://www.rijksmuseum.nl/api/nl/collection?key=14OGzuak&format=json&type=schilderij&toppieces=True'")