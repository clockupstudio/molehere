(ns molehere.core
  (:require [play-cljs.core :as p]))

(defonce game (p/create-game 720 1280))
(defonce state (atom {}))

(def main-screen
  (reify p/Screen
    (on-show [this]
      (reset! state {:text-x 20 :text-y 30}))
    (on-hide [this])
    (on-render [this]
      (p/render game
        [[:image {:name "images/background.jpg" :x 0 :y 0 :width 720 :height 1280}]])
      (swap! state update :text-x inc))))

(doto game
  (p/start)
  (p/set-screen main-screen))
