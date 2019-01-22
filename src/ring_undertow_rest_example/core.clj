(ns ring-undertow-rest-example.core
    (:require [ring.adapter.undertow :refer [run-undertow]]
              [trail.core :as trail]
              [muuntaja.middleware :as middleware]
              [clojure.tools.logging :as log])
    (:gen-class))

;; root handler
(defn- root-handler [req]
    (do
        ;; log it
        (log/debug "Request to root handler:" req)
        ;; return response map
        {:status 200 :body "Hello world"}))

;; ping handler
(defn- ping-handler [req]
    (do
        ;; log it
        (log/debug "Request to ping handler:" req)
        ;; return response map
        {:status 200 :body "Pong!"}))

;; hello handler
(defn- hello-handler [req]
    (do
        ;; log it
        (log/debug "Request to hello handler:" req)
        ;; return response map
        {:status 200 :body (str "Hello, " (:username (:params req)) "!")}))

;; hello handler
(defn- hello-json-handler [req]
    (do
        ;; log it
        (log/debug "Request to hello-json handler:" req)
        ;; return response map
        {:status 200 :body {:message "Hello" :username (:username (:params req))}}))

;; routes
(def ^{:private true} routes
    (-> (trail/get      "/"                         root-handler)
        (trail/get      "/ping"                     ping-handler)
        (trail/get      "/hello/:username"          hello-handler)
        (trail/get      "/hello/json/:username"     hello-json-handler)))

;; ring app
(def ^{:private true} app
    (-> (trail/match-routes routes)
        (middleware/wrap-format)))

;; main method
(defn -main "Main method" [& args] (run-undertow app {:port 8080}))