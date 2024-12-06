;; # Nick's Math Notes
^{:nextjournal.clerk/toc true}
^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(ns nwestallen.mathnotes
  (:refer-clojure
   :exclude [+ - * / zero? compare divide numerator denominator
             infinite? abs ref partial =])
  (:require [emmy.env :as e :refer :all]
            [nextjournal.clerk :as clerk :refer [tex]]))

^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(defn make-table [headers rows]
  (clerk/html
   [:table.drop-shadow-md
    [:tr.bg-slate-300.dark:bg-slate-700.dark:text-white (for [h headers] [:th.border.border-gray-500.text-center.dark:border-white h])]
    (for [r rows] [:tr.bg-blue-50.dark:bg-slate-500.dar:text-white (for [c r] [:td.border.border-gray-500.dark:border-white c])])]))

^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(def render-eq (comp tex ->TeX))

;;## Polynomials

;;### The Fundamental Theorem of Algebra
;; Every non-constant single-variable polynomial with complex coefficients has at least one complex root and any degree n polynomial with complex coefficients has, counting multiplicity, exactly n complex roots.

;;### Quadratic Equations

;;#### The Quadratic Formula
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\text{For an equation of the form }ax^2 + bx + c = 0: \\\\
x = \\frac{-b\\pm\\sqrt{b^2-4ac}}{2a} \\\\
\\\\
\\text{The term } b^2 - 4ac \\text{ is called the \\bf{discriminant}}")

;;#### Number of Real Roots
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table
 [(tex "\\textbf{Discriminant}"), (tex "\\textbf{Number of  Real Roots}")]
 [[(tex "b^2 - 4ac < 0"), (tex "\\text{No real roots}")]
  [(tex "b^2 - 4ac = 0"), (tex "\\text{One repeated root}")]
  [(tex "b^2 - 4ac > 0"), (tex "\\text{Two distinct roots}")]])

;;#### Quadratic Identities
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table
 [(tex "\\textbf{Name}"), (tex "\\textbf{Identity}")]
 [[(tex "\\text{Difference of Squares}"), (tex "(a^2 - b^2) = (a+b)(a-b)")]
  [(tex "\\text{Sum of Squares}"), (tex "(a^2 + b^2) = (a+bi)(a-bi)")]])

;;#### Completing the Square

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\text{If } ax^2 + bx + c = (x+p)^2 \\text{ then the equation can be manipulated algebraically} \\\\
\\text{into the form } x^2 + 2px + p^2 = d \\text{ where } d \\text{ is some constant and } x + p = \\pm \\sqrt{d}")

^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(tex "test")
;;## Trigonometry

;;#### Primary Functions
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Function}"), (tex "\\textbf{Definition}")]
            [[(tex "\\sin(x)"), (tex "\\frac{\\text{opposite}}{\\text{hypotenuse}}")]
             [(tex "\\cos(x)"), (tex "\\frac{\\text{adjacent}}{\\text{hypotenuse}}")]
             [(tex "\\tan(x)"), (tex "\\frac{\\text{opposite}}{\\text{adjacent}} = \\frac{\\sin(x)}{\\cos(x)}")]])

;;### Angle Sum Formulas
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Formula}")]
            [[(tex "\\sin(\\alpha\\pm\\beta) = \\sin(\\alpha)\\cos(\\beta)\\pm\\cos(\\alpha)\\sin(\\beta)")]
             [(tex "\\cos(\\alpha\\pm\\beta) = \\cos(\\alpha)\\cos(\\beta)\\mp\\sin(\\alpha)\\sin(\\beta)")]
             [(tex "\\sin(2x) = (\\sin(x)+\\cos(x))^2 - 1 = 2\\sin(x)\\cos(x)")]
             [(tex "\\cos(2x) = \\cos^2(x) - \\sin^2(x) = 2\\cos^2(x) - 1")]])

;;### Reciprocal Functions
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Function}"), (tex "\\textbf{Definition}")]
            [[(tex "\\sec(x)"), (tex "\\frac{1}{\\cos(x)}")]
             [(tex "\\csc(x)"), (tex "\\frac{1}{\\sin(x)}")]
             [(tex "\\cot(x)"), (tex "\\frac{\\cos(x)}{\\sin(x)}")]])

;;### Pythagorean Identities
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Identity}")]
            [[(tex "\\sin^2(x) + \\cos^2(x) = 1")]
             [(tex "1 + \\cot^2(x) = \\csc^2(x)")]
             [(tex "1 + \\tan^2(x) = \\sec^2(x)")]
             [(tex "\\sec^2(x) + \\csc^2(x) = \\sec^2(x)\\csc^2(x)")]])

;;### Trigonometric Derivatives
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\bf f(x)"), (tex "\\bf f'(x)")]
            [[(tex "\\sin(x)"), (tex "\\cos(x)")]
             [(tex "\\cos(x)"), (tex "-\\sin(x)")]
             [(tex "\\tan(x)"), (tex "\\sec^2(x)")]
             [(tex "\\sec(x)"), (tex "\\sec(x)\\tan(x)")]
             [(tex "\\csc(x)"), (tex "-\\csc(x)\\cot(x)")]
             [(tex "\\cot(x)"), (tex "-\\csc^2(x)")]
             [(tex "\\arcsin(x)"), (tex "\\frac{1}{\\sqrt{1-x^2}}")]
             [(tex "\\arccos(x)"), (tex "-\\frac{1}{\\sqrt{1-x^2}}")]
             [(tex "\\arctan(x)"), (tex "\\frac{1}{1+x^2}")]
             [(tex "\\text{arcsec}(x)"), (tex "\\frac{1}{|x|\\sqrt{x^2 - 1}}")]
             [(tex "\\text{arccsc}(x)"), (tex "-\\frac{1}{|x|\\sqrt{x^2 - 1}}")]
             [(tex "\\text{arccot}(x)"), (tex "-\\frac{1}{1+x^2}")]])

;;## Logarithms

;;### Definition
;;$${\log_{b}(y) = x \Longleftrightarrow b^x = y}$$

;;### Identities
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Identity}")]
            [[(tex "b^{\\log_{b}(x)} = x")]
             [(tex "\\log_{b}(b^x) = x")]
             [(tex "\\log_{b}(1) = 0")]
             [(tex "\\log_{b}(b) = 1")]])

;;### Properties
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Properties}")]
            [[(tex "\\log_{b}(xy) = \\log_{b}(x) + \\log_{b}(y)")]
             [(tex "\\log_{b}\\left(\\frac{x}{y}\\right) = \\log_{b}(x) - \\log_{b}(y)")]
             [(tex "\\log_{b}(x^y) = y\\log_{b}(x)")]
             [(tex "\\log_{b}(\\sqrt[y]{x}) = \\frac{\\log_{b}(x)}{y}")]
             [(tex "x^{\\log_{b}(y)} = y^{\\log_{b}(x)}")]])

;;### Derivatives
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table
 [(tex "\\bf f(x)"), (tex "\\bf f'(x)")],
 [[(tex "\\ln{x}"), (render-eq (/ 1 'x))]
  [(tex "\\log_b(x)"), (tex "\\frac{1}{x\\ln(b)}")]])


;;## Vectors

;;### Operations
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\text{Let } a = <a_1, a_2, ... , a_n > \\text{ and } \\:  b = <b_1, b_2, ... , b_n>")

^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Name}"), (tex "\\textbf{Definition}")]
            [[(tex "\\text{Magnitude of } a"), (tex "||a|| = \\sqrt{a_1^2 + a_2^2 + ... + a_n^2}")]
             [(tex "\\text{Sum of } a \\text{ and } b"), (tex "a + b = <a_1 + b_1, a_2 + b_2, ..., a_n + b_n>")]
             [(tex "\\text{Dot Product of } a \\text{ and } b"), (tex "a \\cdot b = a_1(b_1) + a_2(b_2) + ... + a_n(b_n) = ||a||||b||\\cos(\\theta)")]
             [(tex "\\text{Ange between } a \\text{ and } b"), (tex "\\theta = \\text{arccos}\\left(\\frac{a \\cdot b}{||a|||b||}\\right)")]
             [(tex "\\text{Cross Product of } a \\text { and } b"), (tex "a \\times b = ||a||||b||\\sin(\\theta)n,\\text{where } n \\text{ is unit nomral vector}")]
             [(tex "\\text{Scalar projection of } a \\text{ onto } b"), (tex "\\text{comp}_b(a) = ||a||\\cos(\\theta) = \\frac{a \\cdot b}{||b||}")]
             [(tex "\\text{Vector projection of } a \\text { onto } b"), (tex "\\text{proj}_b(a) = \\text{comp}_b(a)\\frac{b}{||b||} = \\frac{a \\cdot b}{b \\cdot b}b")]])
