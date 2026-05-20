(ns user
  (:require [emmy.clerk :as ec]
            [nextjournal.clerk :as clerk]))

(def index
  "notebooks/nwestallen/mathnotes.clj")

(def defaults
  {;; NOTE by default, your project's first notebook is registered as its index;
   ;; this means that static builds will populate `index.html` with this
   ;; notebook.
   ;;
   ;; Comment out the following line to tell Clerk to generate its own index
   ;; with a list of all built pages.
   :index index

   ;; Uncomment the following line to use the custom ClojureScript code and Emmy
   ;; namespaces loaded by `dev/nwestallen/sci_extensions.cljs`.

   ;; :cljs-namespaces '[nwestallen.sci-extensions]
   })

(def serve-defaults
  (assoc defaults
         :port 7777
         :watch-paths ["notebooks"]
         :browse? true))

(def static-defaults
  (assoc defaults
         :browse? false
         :paths ["notebooks/**.clj"]
         :cname ""
         :git/url "https://github.com/nwestallen/mathnotes"))

(defn serve!
  "Alias of [[emmy.clerk/serve!]] with [[defaults]] supplied as
  default arguments.

  Any supplied `opts` overrides the defaults."
  ([] (serve! {}))
  ([opts]
   (ec/serve!
    (merge serve-defaults opts))))

(def ^{:doc "Alias for [[emmy.clerk/halt!]]."}
  halt!
  ec/halt!)

(defn build!
  "Alias of [[emmy.clerk/build!]] with [[static-defaults]] supplied
  as default arguments.

  Any supplied `opts` overrides the defaults."
  [opts]
  (ec/build!
   (merge static-defaults opts)))

(comment (serve!))
