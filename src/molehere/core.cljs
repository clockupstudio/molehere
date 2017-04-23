(ns molehere.core
  (:require [play-cljs.core :as p]
            [goog.events :as events]))

(def ^:const mole-width 200)
(def ^:const mole-height 170)
(def ^:const mole-image-path "images/mole.png")

(defn mole-frame [x-frame y-frame]
  [:image {:name mole-image-path :sx (* x-frame mole-width) :sy (* y-frame mole-height) :swidth mole-width :sheight mole-height}])

(def ^:const spawn [:animation {:duration 25}
                    (mole-frame 0 0)
                    (mole-frame 1 0)
                    (mole-frame 2 0)
                    (mole-frame 3 0)
                    (mole-frame 4 0)
                    (mole-frame 5 0)
                    (mole-frame 0 1)
                    (mole-frame 1 1)
                    (mole-frame 2 1)
                    (mole-frame 3 1)
                    (mole-frame 4 1)
                    (mole-frame 5 1)
                    (mole-frame 0 2)
                    (mole-frame 1 2)
                    (mole-frame 2 2)
                    (mole-frame 3 2)
                    (mole-frame 4 2)
                    (mole-frame 5 2)
                    (mole-frame 0 3)
                    (mole-frame 1 3)
                    (mole-frame 2 3)
                    (mole-frame 3 3)
                    (mole-frame 4 3)
                    (mole-frame 5 3)
                    (mole-frame 0 4)
                    (mole-frame 1 4)
                    (mole-frame 2 4)
                    (mole-frame 3 4)
                    (mole-frame 4 4)
                    (mole-frame 5 4)
                    (mole-frame 0 5)
                    (mole-frame 1 5)
                    (mole-frame 2 5)
                    (mole-frame 3 5)
                    (mole-frame 4 5)
                    (mole-frame 5 5)
                    (mole-frame 0 6)
                    (mole-frame 1 6)
                    (mole-frame 2 6)
                    (mole-frame 3 6)
                    (mole-frame 4 6)
                    (mole-frame 5 6)
                    (mole-frame 0 7)
                    (mole-frame 1 7)
                    (mole-frame 2 7)
                    (mole-frame 3 7)
                    (mole-frame 4 7)
                    (mole-frame 5 7)
                    (mole-frame 0 8)
                    (mole-frame 1 8)
                    (mole-frame 2 8)
                    (mole-frame 3 8)
                    (mole-frame 4 8)
                    (mole-frame 5 8)
                    (mole-frame 0 9)
                    (mole-frame 1 9)
                    (mole-frame 2 9)
                    (mole-frame 3 9)
                    (mole-frame 4 9)
                    (mole-frame 5 9)])

(def ^:const dead [:animation {:duration 25}
                   (mole-frame 5 12)
                   (mole-frame 6 12)
                   (mole-frame 0 13)
                   (mole-frame 1 13)
                   (mole-frame 2 13)
                   (mole-frame 3 13)
                   (mole-frame 4 13)
                   (mole-frame 5 13)
                   (mole-frame 0 14)
                   (mole-frame 1 14)
                   (mole-frame 2 14)
                   (mole-frame 3 14)])

(def ^:const positions
  ;; row 1
  [{:x 10 :y 400}
   {:x 150 :y 400}
   {:x 290 :y 400}
   {:x 430 :y 400}
   {:x 570 :y 400}

   ;; row 2
   {:x 10 :y (+ (* 1 170) 400)}
   {:x 150 :y (+ (* 1 170) 400)}
   {:x 290 :y (+ (* 1 170) 400)}
   {:x 430 :y (+ (* 1 170) 400)}
   {:x 570 :y (+ (* 1 170) 400)}

   ;; row 3
   {:x 10 :y (+ (* 2 170) 400)}
   {:x 150 :y (+ (* 2 170) 400)}
   {:x 290 :y (+ (* 2 170) 400)}
   {:x 430 :y (+ (* 2 170) 400)}
   {:x 570 :y (+ (* 2 170) 400)}

   ;; row 4
   {:x 10 :y (+ (* 3 170) 400)}
   {:x 150 :y (+ (* 3 170) 400)}
   {:x 290 :y (+ (* 3 170) 400)}
   {:x 430 :y (+ (* 3 170) 400)}
   {:x 570 :y (+ (* 3 170) 400)}])

(defonce game (p/create-game 720 1280))
(defonce state (atom {}))

(defn hit-mole? [pos]
    (and
      (and (> (:x pos) (:x (:pos @state) ) )
           (< (:x pos) (+ (:x (:pos @state)) mole-width ) ))
      (and (> (:y pos) (:y (:pos @state) ) )
           (< (:y pos) (+ (:y (:pos @state)) mole-height ) ))
    )
  )

(events/listen js/window events/EventType.CLICK
               (fn [evt]
                 (when (hit-mole? {:x (.-clientX evt) :y (.-clientY evt)})
                   (reset! state (assoc @state :mole-state dead)))))

(def main-screen
  (reify p/Screen
    (on-show [this]
      (let [pos (nth positions (rand-int (count positions)))]
        (reset! state {:pos pos
                       :mole-state spawn})))
    (on-hide [this])
    (on-render [this]
      (p/render game
                [[:image {:name "images/background.jpg" :x 0 :y 0 :width 720 :height 1280}]])
      (p/render game [[:div (:pos @state) (:mole-state @state)]]))))

(doto game
  (p/start)
  (p/set-screen main-screen))
