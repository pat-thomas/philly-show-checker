(ns philly-show-checker.app.history.macros)

(defmacro app-route!
  [component-name]
  (let [route-pattern     (str "/" component-name)
        component-name-kw (keyword component-name)]
    `(secretary.core/defroute ~route-pattern {:as ~'params}
       (swap! philly-show-checker.app.state/app-state assoc :current-view {:name ~component-name-kw}))))
