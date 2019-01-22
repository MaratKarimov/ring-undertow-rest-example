(defproject ring-undertow-rest-example "0.1.0-SNAPSHOT"
  :description "Example of usage Ring Undertow adapter"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 ;; Ring Undertow adapter
                 [ring-undertow-adapter "0.2.2" :exclusions [io.undertow/undertow-core]]
                 ;; Undertow Core
                 [io.undertow/undertow-core "2.0.17.Final"]
                 ;; Trail 2 routing library
                 [trail "2.3.1"]
                 ;; Metosin Muuntaja
                 [metosin/muuntaja "0.6.3"]
                 ;; SLF4J API
                 [org.slf4j/slf4j-api "1.7.25"]
                 ;; Logback classic
                 [ch.qos.logback/logback-classic "1.2.3"]
                 ;; Clojure logging
                 [org.clojure/tools.logging "0.4.1"]]
  :main ^:skip-aot ring-undertow-rest-example.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})