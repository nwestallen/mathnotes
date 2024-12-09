(ns nwestallen.utils
  (:require [nextjournal.clerk :as clerk]))

(defn make-table [headers rows]
  (clerk/html
   [:table.drop-shadow-md
    [:tr.bg-slate-300.dark:bg-slate-700.dark:text-white (for [h headers] [:th.border.border-gray-500.text-center.dark:border-white h])]
    (for [r rows] [:tr.bg-blue-50.dark:bg-slate-500.dar:text-white (for [c r] [:td.border.border-gray-500.text-center.dark:border-white c])])]))
