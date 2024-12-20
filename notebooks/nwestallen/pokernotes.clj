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
  [3 "Four of A Kind" (hand "Qs" "Qh" "Qc" "Qd" "As") (tex "\\binom{13}{1}\\binom{4}{4}\\binom{12}{1}\\binom{12}{1}")]
  [4 "Full House" (hand "As" "Ah" "Ac" "Kd" "Kc") (tex "\\binom{13}{1}\\binom{4}{3}\\binom{12}{1}\\binom{4}{2}")]
  [5 "Flush" (hand "Kd" "Td" "7d" "4d" "2d") (tex "\\binom{4}{1}\\binom{13}{5} - \\binom{4}{1}\\binom{10}{1}")]
  [6 "Straight" (hand "Tc" "9d" "8s" "7h" "6c") (tex "\\binom{10}{1}\\binom{4}{1}^5 - \\binom{10}{1}\\binom{4}{1}")]
  [7 "Three of a Kind" (hand "Jd" "Jc" "Jh" "4s" "2d") (tex "\\binom{13}{1}\\binom{4}{3}\\binom{12}{2}\\binom{4}{1}^2")]
  [8 "Two Pair" (hand "As" "Ac" "8s" "8d" "Tc") (tex "\\binom{13}{2}\\binom{4}{2}^2\\binom{11}{1}\\binom{4}{1}")]
  [9 "Pair" (hand "9h" "9d" "Qs" "7c" "4h") (tex "\\binom{13}{1}\\binom{4}{2}\\binom{12}{3}\\binom{4}{1}^3")]
  [10 "High Card" (hand "Qs" "Th" "8c" "7d" "3c") (tex "\\left[\\binom{13}{5}-\\binom{10}{1}\\right]\\left[\\binom{4}{1}^5 - \\binom{4}{1}\\right]")]
  ]
 )

;; ## Equity

;; Equity is the measure of a hand's expected likelihood of winning at showdown given the current state of the game and all possible game states that may unfold by the time the last card is dealt.

;;If all cards are face up, like when two players are all-in heads up in Texas Hold'em for example, all possible ways the remaining cards could be dealt can in principle be enumerated and the times each player's hand wins counted to determine the winning percentage of each hand, accounting for ties.

;; ## Pot Odds

;; When face another player's bet, you stand to gain the entire pot if you stay in the hand, including the aggressor's bet, but must risk the bet in order for a chacne to win. This implies a risk-to-reward ratio known as pot odds.
