(ns react
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(defn button-example []
  (let [times-clicked (r/atom 0)]
    (fn []
      [:div
       [:p "A form-2 component with a button"]
       [:p @times-clicked " times clicked"]
       [:button
        {:on-click #(swap! times-clicked inc)}
        "Click me"]])))

(defn form-2 []
  (let [seconds-elapsed (r/atom 0)]
    (js/setInterval #(swap! seconds-elapsed inc) 1000)
    (fn []
      [:div
       [:p "A form-2 component with state in it"]
       [:p @seconds-elapsed " seconds have passed"]])))

(defn greet [name]
  [:div
   [:p "A simple form-1 functional component with a parameter"]
   [:p "Hello " [:span {:style {:color "red"}} name]]])

(defn simple-component []
  [:h1 "A simple stateless form-1 functional component"])

(defn reagent-examples []
  [:<>
   (interleave [[simple-component]
                [greet "Mr. Stark"]
                [form-2]
                [button-example]]
               (repeat [:hr]))
   [:div "Read more about " [:a {:href "https://github.com/reagent-project/reagent/blob/master/doc/CreatingReagentComponents.md"} "components"]]])

(rdom/render [reagent-examples] (.querySelector js/document "#app"))