;; # Nick's Math Notes
^{:nextjournal.clerk/toc true}
^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(ns nwestallen.mathnotes
  (:refer-clojure
   :exclude [+ - * / zero? compare divide numerator denominator
             infinite? abs ref partial =])
  (:require [emmy.env :as e :refer :all]
            [nextjournal.clerk :as clerk :refer [tex]]
            [nwestallen.utils :refer [make-table]]))

^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(def render-eq (comp tex ->TeX))

;;## Polynomials

;;### The Fundamental Theorem of Algebra
;; Every non-constant single-variable polynomial with complex coefficients has at least one complex root and any degree n polynomial with complex coefficients has, counting multiplicity, exactly n complex roots.

;;### Quadratic Equations

;;#### The Quadratic Formula

;;For an equation of the form ${ax^2 + bx + c = 0}$:

;;${x = \frac{-b \pm \sqrt{b^2 - 4ac}}{2a}}$

;;The term ${b^2 - 4ac}$ is called the **discriminant**

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

;; If ${ax^2 + bx + c = (x+p)^2}$ then the equation can be manipulated algebraically into the form
;;${x^2 + 2px + p^2 = d}$ where ${d}$ is some constant and ${x+p = \pm \sqrt{d}}$

;;#### Factoring Quadtratics with Leading Coefficients
;; For equations of the form ${ax^2 + bx + c}$, find two numbers ${b_1}$ and ${b_2}$ that sum to b and multiply to ac, then split ${b}$ into ${b_1}$ and ${b_2}$ and factor the equation by grouping:

;;**Ex:**

;;${2x^2 -5x -3}$

;;${a = 2, b = -5, c = -3, ac = -6}$

;;${b_1 = -6, b_2 = 1}$

;;${2x^2 - 5x - 3 = 2x^2 - 6x + x - 3}$

;;${= 2x(x - 3) + (x - 3)}$

;;${= (2x + 1)(x - 3)}$

;;### Cubic Equations

;;Equations of the form ${ax^3 + bx^2 + cx + d = 0}$

;;#### Cubic Identities

^{:nextjournal.clerk/visibility {:code :hide}}
(make-table
 [(tex "\\textbf{Name}"), (tex "\\textbf{Identity}")]
 [
  [(tex "\\text{Difference of Cubes}") (tex "a^3 - b^3 = (a-b)(a^2 + ab + b^2)")]
  [(tex "\\text{Sum of Cubes}") (tex "a^3 + b^3 = (a+b)(a^2 - ab + b^2)")]
  ])

;;## Conic Sections

;;### Parabolas
;; Vertex at (h,k)

;;#### Standard Form

^{:nextjournal.clerk/visibility {:code :hide}}
(make-table
 [(tex "\\textbf{Type}") (tex "\\textbf{Equation}")]
 [
  [(tex "\\text{Vertical}") (tex "(x-h)^2 = 4p(y-k)")]
  [(tex "\\text{Horizontal}") (tex "(y-k)^2 = 4p(x-h)")]
  ])

;;#### Parametric Forms

^{:nextjournal.clerk/visibility {:code :hide}}
(make-table
 [(tex "\\textbf{Type}") (tex "\\textbf{Equations}")]
 [
  [(tex "\\text{Vertical}") (tex "x-h = 2pt,\\ y-k=pt^2,\\ t \\in{(-\\infty, \\infty)}")]
  [(tex "\\text{Horizontal}") (tex "x-h = pt^2,\\ y-k=2pt,\\ t \\in{(-\\infty, \\infty)}")]
  ])

;;### Circles

;;#### Standard Form
;; For a circle with radius r centered at (h,k):
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "(x-h)^2 - (y-k)^2 = r^2")

;;#### Parametric Form
;; For a circle with radius r centered at (h,k):
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "x = r\\cos(\\theta) + h,\\ y = r\\sin(\\theta) + k,\\ \\theta \\in [0,2\\pi)")

;;### Ellipses

;;#### Standard Form
;;Ellipse with horizontal radius a, vertical radius b, centered at (h,k):
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\frac{(x-h)^2}{a^2} + \\frac{(y-k)^2}{b^2} = 1")

;;#### Parametric Form
;;Ellipse with horizontal radius a, vertical radius b, centered at (h,k):
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "x = a\\cos(\\theta) + h,\\ y =b\\sin(\\theta) + k,\\ \\theta\\in[0,2\\pi)")

;;### Hyperbolas
;;#### Standard Form
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Type}"), (tex "\\textbf{Equation}")]
            [[(tex "\\text{Horizontal}"), (tex "\\frac{(x-h)^2}{a^2} - \\frac{(y-k)^2}{b^2} = 1")]
             [(tex "\\text{Vertical}"), (tex "\\frac{(y-k)^2}{a^2} - \\frac{(x-h)^2}{b^2} = 1")]])
;;## Trigonometry

;;### Primary Functions
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
;;${\log_{b}(y) = x \Longleftrightarrow b^x = y}$

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

;;### Logaritmic Derivatives
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table
 [(tex "\\bf f(x)"), (tex "\\bf f'(x)")],
 [[(tex "\\ln{x}"), (render-eq (/ 1 'x))]
  [(tex "\\log_b(x)"), (tex "\\frac{1}{x\\ln(b)}")]])

;;## Limits

;;### Properties
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table
 [(tex "\\textbf{Properties}")]
 [
  [(tex "\\lim_{x \\to p}(f(x) + g(x)) = \\lim_{x \\to p}(f(x)) + \\lim_{x \\to p}(g(x))")]
  [(tex "\\lim_{x \\to p}(f(x) - g(x)) = \\lim_{x \\to p}(f(x)) - \\lim_{x \\to p}(g(x))")]
  [(tex "\\lim_{x \\to p}(f(x) \\cdot g(x)) = \\lim_{x \\to p}(f(x)) \\cdot \\lim_{x \\to p}(g(x))")]
  [(tex "\\lim_{x \\to p}(f(x) / g(x)) = \\lim_{x \\to p}(f(x)) / \\lim_{x \\to p}(g(x))")]
  ])

;;## Differentiation

;;### Definition

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "f'(x) = \\lim_{h \\to 0}\\frac{f(a+h) - f(a)}{h}")

;;### Rules
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Rule}"), (tex "\\textbf{Definition}")]
            [
             [(tex "\\text{Sum Rule}"), (tex "(f(x) + g(x))' = f'(x) + g'(x)")]
             [(tex "\\text{Product Rule}"), (tex "(f(x)g(x))' = f'(x)g(x) + f(x)g'(x)")]
             [(tex "\\text{Quotient Rule}"), (tex "\\left(\\frac{f(x)}{g(x)}\\right)' = \\frac{f'(x)g(x) - f(x)g'(x)}{(g(x))^2}")]
             [(tex "\\text{Chain Rule}"), (tex "(f(g(x)))' = f'(g(x))(g'(x))")]
             ])

;;## Discrete Sums

;;### Arithmetic Series
;;$${1 + 2 + 3 + 4 + 5 = 15 = \frac{(1 + 5) + (2 + 4) + (3 + 3) + (4 + 2) + (5 + 1)}{2} = \frac{6 + 6 + 6 + 6 + 6}{2}}$$

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\sum_{i=a}^{b} i = \\frac{(a + b) * n}{2}")

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "n = \\frac{i_n - i_1}{i_2 - i_1} + 1")

;;### Geometric Series

;;#### Finitie Sum

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "a + ar + ar^2 + ... + ar^n = \\sum_{k=0}^{n} ar^k = a\\left(\\frac{1-r^{n+1}}{1-r}\\right)")

;;##### Derivation

;;${S_n = a + ar + ar^2 + ... + ar^n}$,

;;${rS_n = ar + ar^2 + ar^3 + ... + ar^n + ar^{n+1}}$,

;;${S_n - rS_n = a - ar^{n+1}}$,

;;${S_n(1 - r) = a(1-r^{n+1})}$,

;;${S_n = a\left(\frac{1-r^{n+1}}{1-r}\right)}$

;;#### Infinite Sum

;; The sum of an infinite series is the limit of it's partial sums, which converges when ${|r| < 1}$

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\lim_{n \\to \\infty} S_n = \\lim_{n \\to \\infty}a\\left(\\frac{1-r^{n+1}}{1-r}\\right) = \\frac{a}{1-r}")

;;## Integrals

;;### Riemann Sums
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\text{For } y = f(x) \\text{ over the interval } [a,b] \\text{ where } x_k = a + k\\Delta x \\text{ and } \\Delta x = \\frac{b-a}{n}:")
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Sum Type}"), (tex "\\textbf{Formula}")]
            [
             [(tex "\\text{Left Riemann Sum}"), (tex "\\sum_{k=0}^{n-1} f(x_k)\\Delta x")]
             [(tex "\\text{Right Riemann Sum}"), (tex "\\sum_{k=1}^{n} f(x_k)\\Delta x")]
             ])

;;### Definition of Definite Integrals
;; We can define a definite integral f(x) over the interval [a,b] as the limit as n approaches infinity or either a left or right Riemann sum:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\int_{a}^{b} f(x)dx = \\lim_{n \\to \\infty} \\sum_{k=0}^{n-1} f(x_k)\\Delta x = \\lim_{n \\to \\infty} \\sum_{k=1}^{n} f(x_k)\\Delta x,\\, \\Delta x = \\frac{b-a}{n}")

;;### The Fundamental Theorem of Calculus
;;#### The First Part
;; Let ${f}$ be a continuous real-valued function defined on the closed interval ${[a,b]}$. Lef ${F}$ be a function, defined for all ${x}$ in ${[a, b]}$ by ${\int_{a}^{x} f(t)dt}$, then ${F'(x) = f(x)}$ for all ${x}$ in ${(a,b)}$ and ${F}$ is the *antiderivative* of ${f}$
;;#### Corollary
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\int_{a}^{b} f(t)dt = F(b) - F(a)")
;;#### The Second Part
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "F(x) = \\int_{a}^{x} f(t)dt \\, \\Longrightarrow \\, F'(x) = \\frac{d}{dx}\\int_{a}^{x} f(t)dt = f(x)")


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
