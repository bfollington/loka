(ns deity-gen.core
  (:require [malli.core :as m]
            [malli.generator :as mg]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(def Color
  [:enum :red :brown :blue :black :grey :green :orange])

(def Shape
  [:enum :square :round :cross-shaped :triangle])

(def Eye
  [:map
   [:color Color]
   [:pupil-shape Shape]])

(def Head
  [:map
   [:eyes [:vector {:min 1 :max 8} Eye]]])

(def Body
  [:map
   [:heads [:vector {:min 1 :max 4} Head]]])

(def Entity 
  [:map
   [:name string?]
   [:age [:int {:min 1 :max 9999}]]
   [:body Body]])

(mg/generate Entity)