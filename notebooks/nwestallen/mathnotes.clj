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
;; Vertex at ${(h,k)}$

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
;; For a circle with radius ${r}$ centered at ${(h,k)}$:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "(x-h)^2 + (y-k)^2 = r^2")

;;#### Parametric Form
;; For a circle with radius ${r}$ centered at ${(h,k)}$:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "x = r\\cos(\\theta) + h,\\ y = r\\sin(\\theta) + k,\\ \\theta \\in [0,2\\pi)")

;;### Ellipses

;;#### Standard Form
;;Ellipse with horizontal radius ${a}$, vertical radius ${b}$, centered at ${(h,k)}$:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\frac{(x-h)^2}{a^2} + \\frac{(y-k)^2}{b^2} = 1")

;;#### Parametric Form
;;Ellipse with horizontal radius ${a}$, vertical radius ${b}$, centered at ${(h,k)}$:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "x = a\\cos(\\theta) + h,\\ y =b\\sin(\\theta) + k,\\ \\theta\\in[0,2\\pi)")

;;### Hyperbolas
;;#### Standard Form
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Type}"), (tex "\\textbf{Equation}"), (tex "\\textbf{Asymptotes}")]
            [[(tex "\\text{Horizontal}"), (tex "\\frac{(x-h)^2}{a^2} - \\frac{(y-k)^2}{b^2} = 1"), (tex "y-k = \\pm \\frac{b}{a}(x-h)")]
             [(tex "\\text{Vertical}"), (tex "\\frac{(y-k)^2}{a^2} - \\frac{(x-h)^2}{b^2} = 1"), (tex "y-k = \\pm \\frac{a}{b}(x-h)")]])

;;#### Parametric Form
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Type}"), (tex "\\textbf{Equations}"), (tex "\\textbf{Domain}")]
            [
             [(tex "\\text{Horizontal}"), (tex "x = a\\sec(t), \\ y = b\\tan(t)"), (tex "t \\in [-\\pi, \\pi], t \\neq \\pm \\frac{\\pi}{2}")]
             [(tex "\\text{Vertical}"), (tex "x = b\\tan(t), \\ y = a\\sec(t)"), (tex "t \\in [-\\pi, \\pi], t \\neq \\pm \\frac{\\pi}{2}")]
             ])

;;## Trigonometry

;;### Primary Functions
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Function}"), (tex "\\textbf{Definition}")]
            [[(tex "\\sin(x)"), (tex "\\frac{\\text{opposite}}{\\text{hypotenuse}}")]
             [(tex "\\cos(x)"), (tex "\\frac{\\text{adjacent}}{\\text{hypotenuse}}")]
             [(tex "\\tan(x)"), (tex "\\frac{\\text{opposite}}{\\text{adjacent}} = \\frac{\\sin(x)}{\\cos(x)}")]])

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

;;### Angle Sum Formulas
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Formula}")]
            [[(tex "\\sin(\\alpha\\pm\\beta) = \\sin(\\alpha)\\cos(\\beta)\\pm\\cos(\\alpha)\\sin(\\beta)")]
             [(tex "\\cos(\\alpha\\pm\\beta) = \\cos(\\alpha)\\cos(\\beta)\\mp\\sin(\\alpha)\\sin(\\beta)")]
             [(tex "\\sin(2x) = (\\sin(x)+\\cos(x))^2 - 1 = 2\\sin(x)\\cos(x)")]
             [(tex "\\cos(2x) = \\cos^2(x) - \\sin^2(x) = 2\\cos^2(x) - 1")]])

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
             [(tex "x^{\\log_{b}(y)} = y^{\\log_{b}(x)}")]
             [(tex "\\log_{b}(x) = \\frac{\\log_{a}(x)}{\\log_{a}(b)}")]])

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

;;### Implicit Differentiaion
;; Functions defined in implicit form can be diffrentiated directly:

;;${y^2 - 3x^2 = 6}$

;;${\frac{\text{d}}{\text{dx}}(y^2 - 3x^2) = \frac{\text{d}}{\text{dx}}(6)}$

;;${\frac{\text{d}}{\text{dx}}(y^2) - \frac{\text{d}}{\text{dx}}(3x^2) = 0}$

;;${(2y)\left(\frac{\text{dy}}{\text{dx}}\right) - 6x = 0 \, \, \,}$ chain rule applied to ${y(x)}$

;;${2y\left(\frac{\text{dy}}{\text{dx}}\right) = 6x }$

;;${\frac{\text{dy}}{\text{dx}} = \frac{3x}{y} }$

;;### Inverse Functions
;; Implicit differentation can be used to find the derivative of an inverse function without needing to explicitly compute the inverse function

;; Given that ${f(x) = x^2 + 4x}$ find ${(f^{-1})'(x)}$:

;; Let the inverse of ${y = x^2 + 4x}$ be defined as ${x = y^2 + 4y}$, ${\, \, f^{-1}(x) = y}$

;;${\frac{\text{d}}{\text{dy}}(x) = \frac{\text{d}}{\text{dy}}(y^2 + 4y)}$

;;${ \frac{\text{dx}}{\text{dy}}= 2y + 4}$

;;${\frac{\text{dy}}{\text{dx}} = \frac{1}{\frac{\text{dx}}{\text{dy}}}}$

;;${\frac{\text{dy}}{\text{dx}} = \frac{1}{2y + 4}}$

;;${(f^{-1})'(x) = \frac{1}{2(f^{-1}(x)) + 4}}$

;;### Parametric Curves
;;When x an y are both defined as functions of a third variable t, we can find the derivative of y with respect to x by rearranging the functions and applying the chain rule:

;;${\frac{\text{d}}{\text{dx}}\left(y(t(x))\right) = y'(t(x)) \cdot t'(x) = \frac{\text{dy}}{\text{dt}} \cdot \frac{\text{dt}}{\text{dx}} = \frac{\text{dy/dt}}{\text{dx/dt}} = \frac{y'(t)}{x'(t)} }$ 

;;#### Circle Example

;; ${x = 4\cos{\theta}, \, \, \, y = 4\sin{\theta}}$

;; ${\frac{x}{4} = \cos{\theta}}$

;; ${\arccos{(\frac{x}{4})} = \theta}$

;; ${y = 4\sin{(\arccos{(\frac{x}{4})})}}$

;; ${y'(x) = 4\cos{(\arccos{(\frac{x}{4})})} \cdot \left(-\frac{1}{\sqrt{1-x^2}}\right) = -\frac{x}{\sqrt{1-x^2}}}$ 

;; ${y'(x) = -\frac{4\cos{\theta}}{\sqrt{1-16\cos^2\theta}} = -\frac{4\cos{\theta}}{4\sin{\theta}} = -\cot{\theta}}$

;; or

;; ${x'(\theta) = -4\sin{\theta}, \, \, \, y'(\theta) = 4\cos(\theta)}$

;; ${\frac{y'(\theta)}{x'(\theta)} = \frac{4\cos{\theta}}{-4\sin{\theta}} = -\cot{\theta}}$

;;## Discrete Sums

;;### Properties
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Property}"), (tex "\\textbf{Definition}")]
            [
             [(tex "\\text{Distributive Property}"), (tex " \\sum_{k=m}^n C \\cdot f(k) = C \\cdot \\sum_{k=m}^n f(k)")]
             [(tex "\\text{Associative Property}"), (tex "\\sum_{k=m}^n (f(k)+g(k)) = \\sum_{k=m}^n f(k) + \\sum_{k=m}^n g(k)")]
             [(tex "\\text{Commutative Property}"), (tex "\\sum_{k=m}^n f(k)= \\sum_{k=n}^m f(k), \\, \\text{(order doesn't matter)}")]
             [(tex "\\text{Index Shift}"), (tex "\\sum_{k=m}^n f(k)= \\sum_{k=m+h}^{n+h} f(k-h)")]
             ])

;;### Arithmetic Series
;;$${1 + 2 + 3 + 4 + 5 = 15 = \frac{(1 + 5) + (2 + 4) + (3 + 3) + (4 + 2) + (5 + 1)}{2} = \frac{6 + 6 + 6 + 6 + 6}{2}}$$

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\sum_{i=a}^{b} i = \\frac{(a + b) * n}{2}")

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "n = \\frac{i_n - i_1}{i_2 - i_1} + 1")

;;### Geometric Series

;;#### Finitie Sum

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "S_n = a + ar + ar^2 + ... + ar^n = \\sum_{k=0}^{n} ar^k = a\\left(\\frac{1-r^{n+1}}{1-r}\\right)")

;;##### Derivation

;;${S_n = a + ar + ar^2 + ... + ar^n}$,

;;${rS_n = ar + ar^2 + ar^3 + ... + ar^n + ar^{n+1}}$,

;;${S_n - rS_n = a - ar^{n+1}}$,

;;${S_n(1 - r) = a(1-r^{n+1})}$,

;;${S_n = a\left(\frac{1-r^{n+1}}{1-r}\right)}$

;;##### Alternate Form
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "S_n = \\sum_{k=1}^{n} ar^{k-1} = a\\left(\\frac{1-r^n}{1-r}\\right)")

;;##### Different Starting Index

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\sum_{k=1}^{n} ar^k = ar + ar^2 + ar^3 + ... + ar^n = r * \\sum_{k=0}^{n-1} ar^k")

;;Generally:

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\sum_{k=m}^{n} ar^k = ar^m + ar^{m+1} + ... + ar^n = r^m * \\sum_{k=0}^{n-m} ar^k = a\\left(\\frac{r^m - r^{n+1}}{1-r}\\right)")

;;#### Infinite Sum

;; The sum of an infinite series is the limit of it's partial sums, which converges when ${|r| < 1}$

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\sum_{k=0}^{\\infty} ar^k = \\lim_{n \\to \\infty} S_n = \\lim_{n \\to \\infty}a\\left(\\frac{1-r^{n+1}}{1-r}\\right) = \\frac{a}{1-r}")
;; or
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\sum_{k=1}^{\\infty} ar^k = \\lim_{n \\to \\infty} S_n = \\lim_{n \\to \\infty}a\\left(\\frac{1-r^{n+1}}{1-r}\\right) - a(r^0) = \\frac{a}{1-r} - a\\left(\\frac{1-r}{1-r}\\right) = \\frac{ar}{1-r}")
;;Generally:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\sum_{k=m}^{\\infty} ar^k = \\frac{ar^m}{1-r}")


;;### Taylor & Maclaurin Series
;;#### Taylor Polynomials
;; We can linearly approximate a function around the point ${x = a}$ as follows:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "f(x) \\approx L(x) = f(a) + f'(a)(x-a)")
;; This approximates the function ${f(x)}$ using a straight line based off its first derivative.

;; We can approximate ${f(x)}$ around ${a}$ more closely using its second derivative to form a quadratic curve:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "f(x) \\approx P_2(x) = f(a) + f'(a)(x-a) + \\frac{1}{2}f''(a)(x-a)^2")
;; Likewise we can add a third term to get a cubic approximation:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "f(x) \\approx P_3(x) = f(a) + f'(a)(x-a) + \\frac{1}{2!}f''(a)(x-a)^2 + \\frac{1}{3!}f'''(a)(x-a)^3")
;; In general we can define the ${n^{th}}$ degree Taylor polynomial of a fucntion ${f(x)}$ around ${x = a}$:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "f(x) \\approx P_n(x) = f(a) + f'(a)(x-a) + \\frac{f''(a)}{2!}(x-a)^2 + ... + \\frac{f^{(n)}(a)}{n!}(x-a)^n")

;;#### Taylor Series
;; The Taylor Series of ${f(x)}$ around ${a}$ takes Taylor polynomial approximations to their limit:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "f(x) = \\sum_{n=0}^{\\infty} \\frac{f^{(n)}(a)}{n!}(x-a)^n")

;;#### Maclaurin Series
;; The Taylor series for ${f(x)}$ in the special case where ${a = 0}$ is called a Maclaurin Series:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "f(x) = \\sum_{n=0}^{\\infty} \\frac{f^{(n)}(0)}{n!}x^n")

;;#### Standard Maclaurin Series
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\bf{f(x)}"), (tex "\\textbf{Series Expansion}"), (tex "\\textbf{Domain}")]
            [
             [(tex "\\frac{1}{1-x}"), (tex "1 + x + x^2 + ... + x^n + ... = \\sum_{n=0}^{\\infty} x^n"), (tex "x \\in (-1, 1)")]
             [(tex "\\frac{1}{1+x}"), (tex "1 - x + x^2 - ... + (-1)^nx^n + ... = \\sum_{n=0}^{\\infty} (-1)^nx^n"), (tex "x \\in (-1, 1)")]
             [(tex "\\ln(1+x)"), (tex "x - \\frac{1}{2}x^2 + \\frac{1}{3}x^3 - ... + \\frac{(-1)^{n+1}x^n}{n} + ... = \\sum_{n=1}^{\\infty} \\frac{(-1)^{n+1}x^n}{n}"), (tex "x \\in (-1, 1]")]
             [(tex "e^x"), (tex "1 + x + \\frac{x^2}{2!} + ... + \\frac{x^n}{n!} + ... = \\sum_{n=0}^{\\infty} \\frac{x^n}{n!}"), (tex "x \\in (-\\infty, \\infty)")]
             [(tex "\\cos(x)"), (tex "1 - \\frac{x^2}{2!} + \\frac{x^4}{4!} - ... + \\frac{(-1)^nx^{2n}}{(2n)!} + ... = \\sum_{n=0}^{\\infty} \\frac{(-1)^nx^{2n}}{(2n)!}"), (tex "x \\in (-\\infty, \\infty)")]
             [(tex "\\sin(x)"), (tex "x - \\frac{x^3}{3!} + \\frac{x^5}{5!} - ... + \\frac{(-1)^nx^{2n+1}}{(2n+1)!} + ... = \\sum_{n=0}^{\\infty} \\frac{(-1)^nx^{2n+1}}{(2n+1)!}"), (tex "x \\in (-\\infty, \\infty)")]
             ])

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

;;### Properties of Integrals
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Name}"), (tex "\\textbf{Expression}")]
            [
             [(tex "\\text{Constant Multiple Rule}"), (tex "\\int_{a}^{b} kf(x)dx \\, = k \\int_{a}^{b} f(x)dx")]
             [(tex "\\text{Sum Rule}"), (tex "\\int_{a}^{b} (f(x) + g(x))dx \\, = \\int_{a}^{b} f(x)dx \\, + \\int_{a}^{b} g(x)dx")]
             [(tex "\\text{Interval of Zero Length}"), (tex "\\int_{a}^{a} f(x)dx \\, = 0")]
             [(tex "\\text{Reverse Limits}"), (tex "\\int_{a}^{b} f(x)dx \\, = - \\int_{b}^{a} f(x)dx")]
             [(tex "\\text{Adjacent Intervals}"), (tex "\\int_{a}^{b} f(x)dx \\, + \\int_{b}^{c} f(x)dx \\, = \\int_{a}^{c} f(x)dx")]
             ])

;;### Integration Techniques

;;#### U-Substitution
;; U-substitution is like the inverse of the chain rule - it works whenever the derivative of the nested part of the function is present in the remainder of the function, potentially multiplied by some constant:

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\int f(g(x)) \\cdot g'(x) dx = \\int f(u) du")

;;##### General Technique
;; Take any integral expression that fits the form defined above:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\int 4x\\sin(x^2) dx")
;; Set ${u}$ equal to the inner function: ${u = x^2}$

;; Differentiate ${u}$ with respect to ${x}$: ${du = 2x dx}$

;; Rewrite the equation in terms of u and du:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\int 4x\\sin(x^2) dx = 2 \\cdot \\int \\sin(u) du")

;; Integrate the new expression with respect to ${u}$:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "2 \\cdot \\int \\sin(u) du = 2 \\cdot (-\\cos(u)) + C = -2\\cos(u) + C")

;; Substitue your expression for ${u}$ to get final result in terms of ${x}$:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "-2\\cos(u) + C = -2\\cos(x^2) + C")

;;##### Using Algebraic Manipulation

;; Sometimes the above approach can be applied using further substitution if necessary
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\int x\\sqrt{x+2} \\, dx")

;; Start with the normal technique, ${u = x + 2}$ and ${du = dx}$:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\int x\\sqrt{x+2} \\, dx = \\int x\\sqrt{u} \\, du")

;; Now redefine the remaining ${x}$ in terms of ${u}$, in this case ${x = u - 2}$:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\int x\\sqrt{u} \\, du = \\int (u-2)\\sqrt{u} \\, du")
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "= \\int u^{3/2} - 2u^{1/2} \\, du = \\int u^{3/2} \\, du - 2 \\cdot \\int u^{1/2} \\, du")
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "= \\frac{2}{5}u^{5/2} - \\frac{4}{3}u^{3/2} + C")

;; Finally, subsitute back using our expression for ${u}$, ${u = x + 2}$:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\frac{2}{5}\\sqrt{(x+2)^5} - \\frac{4}{3}\\sqrt{(x+2)^3} + C")


;;#### Integration by Parts
;; Integration by parts is like the inverse of the product rule

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\int udv = uv - \\int vdu")
;; We can use the product rule to derive this relationship:

;; ${\frac{d}{dx}[u(x)v(x)] = u'(x)v(x) + u(x)v'(x)}$

;; ${\int (u(x)v(x))' dx = \int (u'(x)v(x) + u(x)v'(x)) dx}$

;; ${u(x)v(x) = \int u'(x)v(x) dx + \int u(x)v'(x) dx}$

;; ${uv = \int v du + \int u dv}$

;; ${uv - \int v du = \int u dv}$

;;##### General Technique

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\int xe^x \\, dx = \\int udv")

;;Choose for ${dv}$ the part of the integrand that is easier to integrate and ${u}$ the other:

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "u = x, \\, dv = e^x dx")

;;Differentiate and integrate ${u}$ and ${dv}$, resspectively:

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "du = dx, \\, v = e^x")

;;Substitute our new expressions into the above defined equation:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\int xe^x \\, dx = xe^x - \\int e^x \\, dx")
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "= xe^x - e^x + C = e^x(x - 1) + C")


;;#### Partial Fraction Decomposition
;; Rational functions that would otherwise be difficult to integrate can be converted into integrals that are easier to evaluate via partial fraction decomposition:

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\frac{3x + 11}{x^2 - x - 6} = \\frac{4}{x-3} - \\frac{1}{x+2}")

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\int \\frac{3x + 11}{x^2 - x - 6} \\, dx = \\int \\frac{4}{x-3} \\, dx - \\int \\frac{1}{x+2} \\, dx")

;;##### General Technique
;; First factor the denominator as much as possible, then set it equal to some combination of fractions of those factors:

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\frac{3x+11}{(x-3)(x+2)} = \\frac{A}{(x-3)} + \\frac{B}{(x+2)}")

;;Next, multiply both sides by the denominator:

;;${3x + 11 = A(x+2) + B(x-3)}$

;;Then, choose convient values for x to isolate the constant variables:

;;${3(3) + 11 = A((3) + 2) + B((3) - 3)}$

;;${9 + 11 = A(5) + B(0)}$

;;${20 = 5A}$

;;${A = 4}$

;;${3(-2) + 11 = A((-2) + 2) + B((-2) - 3)}$

;;${-6 + 11 = A(0) + B(-5)}$

;;${5 = -5B}$

;;${B = -1}$

;;##### Repeated Roots
;; Repeated roots in the denominator get two fractions with constants on the right hand side:

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\frac{P(x)}{(x+a)^2} = \\frac{A}{(x+a)^2} + \\frac{B}{(x+a)}")

;;##### Irreducible Quadratic Factors
;; Full quadratic factors can be found using Ax+B in the numerator:

^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\frac{P(x)}{(ax^2 + bx +c)} = \\frac{Ax + B}{(ax^2 + bx + c)}")

;;### Arc Length

;;#### Planar Curves
;; The length of a curve ${y = f(x)}$ from ${x = a}$ to ${x = b}$:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "L = \\int_{a}^{b} \\sqrt{1 + [f'(x)]^2}dx")

;;#### Polar Curves
;; The length of a curve ${r = f(\theta)}$ from ${\theta_1}$ to ${\theta_2}$:
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "L = \\int_{\\theta_1}^{\\theta_2} \\sqrt{r^2 + \\left(\\frac{dr}{d\\theta}\\right)^2} d\\theta")

;;## Vectors

;;### Operations
^{:nextjournal.clerk/visibility {:code :hide}}
(tex "\\text{Let } a = <a_1, a_2, ... , a_n > \\text{ and } \\:  b = <b_1, b_2, ... , b_n>")

^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Name}"), (tex "\\textbf{Definition}")]
            [[(tex "\\text{Magnitude of } a"), (tex "||a|| = \\sqrt{a_1^2 + a_2^2 + ... + a_n^2}")]
             [(tex "\\text{Sum of } a \\text{ and } b"), (tex "a + b = <a_1 + b_1, a_2 + b_2, ..., a_n + b_n>")]
             [(tex "\\text{Dot Product of } a \\text{ and } b"), (tex "a \\cdot b = a_1(b_1) + a_2(b_2) + ... + a_n(b_n) = ||a||||b||\\cos(\\theta)")]
             [(tex "\\text{Angle between } a \\text{ and } b"), (tex "\\theta = \\text{arccos}\\left(\\frac{a \\cdot b}{||a|||b||}\\right)")]
             [(tex "\\text{Cross Product of } a \\text { and } b"), (tex "a \\times b = ||a||||b||\\sin(\\theta)n,\\text{where } n \\text{ is unit nomral vector}")]
             [(tex "\\text{Scalar projection of } a \\text{ onto } b"), (tex "\\text{comp}_b(a) = ||a||\\cos(\\theta) = \\frac{a \\cdot b}{||b||}")]
             [(tex "\\text{Vector projection of } a \\text { onto } b"), (tex "\\text{proj}_b(a) = \\text{comp}_b(a)\\frac{b}{||b||} = \\frac{a \\cdot b}{b \\cdot b}b")]])

;;### Vector Geometry

;;#### Equation of a Line
;; The equation of a straight line passing through point P and parallel to vector v in ${\R^3}$: ${{\bf r} = {\bf p} + t{\bf v}}$, with ${{\bf r} = <x, y, z>, {\bf p} = <p_1, p_2, p_3>}$ and ${{\bf v} = <v_1, v_2, v_3>}$
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Form}"), (tex "\\textbf{Equation}")]
            [
             [(tex "\\text{Vector}"), (tex "{\\bf r} = \\begin{bmatrix} p_1 \\\\ p_2 \\\\ p_3 \\end{bmatrix} + t\\begin{bmatrix} v_1 \\\\ v_2 \\\\ v_3\\end{bmatrix}")]
             [(tex "\\text{Parametric}"), (tex "{\\bf r} = \\begin{bmatrix} x \\\\ y \\\\ z\\end{bmatrix}, \\, \\, \\, \\begin{cases} x = p_1 + v_1t \\\\ y = p_2 + v_2t \\\\ z = p_3 + v_3t\\end{cases}")]
             [(tex "\\text{Cartesian}"), (tex "\\frac{x - p_1}{v_1} = \\frac{y - p_2}{v_2} = \\frac{z - p_3}{v_3} = t")]
             ])

;; #### Equation of a Plane
;; The vector equation of the plane that passes through the point P: ${{\bf (r - p) \cdot n} = 0}$ with the normal vector,  ${{\bf n} = <n_1, n_2, n_3>}$ perpendicular to the plane and ${{\bf r} = <x, y, z>}$
^{:nextjournal.clerk/visibility {:code :hide}}
(make-table [(tex "\\textbf{Form}"), (tex "\\textbf{Equation}")]
            [
             [(tex "\\text{Vector}"), (tex "\\bf r \\cdot n = p \\cdot n")]
             [(tex "\\text{Parametric}"), (tex "{\\bf r} = {\\bf p} + s{\\bf b} + t{\\bf c}, \\newline \\text{where {\\bf b} and {\\bf c} are vectors parallel to the plane,} \\newline {\\bf b \\times c = n}, \\newline \\text{and {\\it s} and {\\it t} are scalar parameters}")]
             [(tex "\\text{Cartesian}"), (tex "n_1x + n_2y + n_3z - ({\\bf n} \\cdot {\\bf p}) = 0")]
             ])

