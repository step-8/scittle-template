(ns main)

(defn show-current-time [app]
  (let [time-tag (.createElement js/document "time")
        now (js/Date.)]
    (set! (.-innerText time-tag) (str now))
    (.appendChild app time-tag)))

(show-current-time (.querySelector js/document "#app"))