;; # Poker Notes
(ns nwestallen.pokernotes
  (:require [nextjournal.clerk :as clerk :refer [tex]]
            [clojure.string :as str]
            [nwestallen.utils :as utils :refer [make-table]]))

;; ## Hands
(def suits {"s" "♠︎", "c" "♣", "h" "♥︎", "d" "♦︎"})

(str/replace "Th" #"s|c|h|d" suits)

(map #(str/replace % #"s|c|h|d" suits) ["Th" "Jh" "Qh" "Kh" "Ah"])

(defn hand [& cards]
  (map #(str/replace % #"s|c|h|d" suits) cards))

(hand "As" "Ad" "Ac" "Kh" "Ks")

(make-table
 ["Rank" "Hand" "Form" "5 Card Combos"]
 [
  [1 "Royal Flush" (hand "As" "Ks" "Qs" "Js" "Ts") (tex "\\binom{4}{1}")]
  [2 "Straight Flush" (hand "Th" "9h" "8h" "7h" "6h") (tex "\\binom{10}{1}\\binom{4}{1}-\\binom{4}{1}")]
  ]
 )

