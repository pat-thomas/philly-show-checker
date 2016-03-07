(ns philly-show-checker.server.session-helpers
  (:require [kinematic.session :as k-session]))

(k-session/session-accessor :user-id)
