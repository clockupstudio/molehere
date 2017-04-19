(ns molehere.core
  (:require [play-cljs.core :as p]))

(def ^:const mole-width 200)
(def ^:const mole-height 170)
(def ^:const mole-image-path "images/mole.png")

(def ^:const spawn [:animation {:duration 50}
                    [:image {:name mole-image-path :sx (* 0 mole-width) :sy (* 0 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 1 mole-width) :sy (* 0 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 2 mole-width) :sy (* 0 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 3 mole-width) :sy (* 0 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 4 mole-width) :sy (* 0 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 5 mole-width) :sy (* 0 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 0 mole-width) :sy (* 1 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 1 mole-width) :sy (* 1 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 2 mole-width) :sy (* 1 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 3 mole-width) :sy (* 1 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 4 mole-width) :sy (* 1 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 5 mole-width) :sy (* 1 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 0 mole-width) :sy (* 2 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 1 mole-width) :sy (* 2 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 2 mole-width) :sy (* 2 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 3 mole-width) :sy (* 2 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 4 mole-width) :sy (* 2 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 5 mole-width) :sy (* 2 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 0 mole-width) :sy (* 3 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 1 mole-width) :sy (* 3 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 2 mole-width) :sy (* 3 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 3 mole-width) :sy (* 3 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 4 mole-width) :sy (* 3 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 5 mole-width) :sy (* 3 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 0 mole-width) :sy (* 4 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 1 mole-width) :sy (* 4 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 2 mole-width) :sy (* 4 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 3 mole-width) :sy (* 4 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 4 mole-width) :sy (* 4 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 5 mole-width) :sy (* 4 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 0 mole-width) :sy (* 5 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 1 mole-width) :sy (* 5 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 2 mole-width) :sy (* 5 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 3 mole-width) :sy (* 5 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 4 mole-width) :sy (* 5 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 5 mole-width) :sy (* 5 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 0 mole-width) :sy (* 6 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 1 mole-width) :sy (* 6 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 2 mole-width) :sy (* 6 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 3 mole-width) :sy (* 6 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 4 mole-width) :sy (* 6 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 5 mole-width) :sy (* 6 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 0 mole-width) :sy (* 7 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 1 mole-width) :sy (* 7 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 2 mole-width) :sy (* 7 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 3 mole-width) :sy (* 7 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 4 mole-width) :sy (* 7 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 5 mole-width) :sy (* 7 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 0 mole-width) :sy (* 8 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 1 mole-width) :sy (* 8 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 2 mole-width) :sy (* 8 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 3 mole-width) :sy (* 8 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 4 mole-width) :sy (* 8 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 5 mole-width) :sy (* 8 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 0 mole-width) :sy (* 9 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 1 mole-width) :sy (* 9 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 2 mole-width) :sy (* 9 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 3 mole-width) :sy (* 9 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 4 mole-width) :sy (* 9 mole-height) :swidth mole-width :sheight mole-height}]
                    [:image {:name mole-image-path :sx (* 5 mole-width) :sy (* 9 mole-height) :swidth mole-width :sheight mole-height}]])

(defonce game (p/create-game 720 1280))
(defonce state (atom {}))

(def main-screen
  (reify p/Screen
    (on-show [this]
      (reset! state {:text-x 20 :text-y 30}))
    (on-hide [this])
    (on-render [this]
      (p/render game
                [[:image {:name "images/background.jpg" :x 0 :y 0 :width 720 :height 1280}]
                 [:div {:x 0 :y 400}
                  spawn]])
      (swap! state update :text-x inc))))

(doto game
  (p/start)
  (p/set-screen main-screen))
