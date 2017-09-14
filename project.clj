(defproject parens-of-the-dead "0.1.0-SNAPSHOT"
  :description "A series of zombie-themed games written with Clojure and ClojureScript."
  :url "http://www.parens-of-the-dead.com/"
  :license {:name "General Public License"
            :url "http://www.gnu.org/licenses/gpl.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha20"]
                 [http-kit "2.2.0"]
                 [com.stuartsierra/component "0.3.2"]
                 [compojure "1.6.0"]
                 [org.clojure/clojurescript "1.9.908"]]
  :main undead.system
  :profiles {:dev {:plugins [[lein-cljsbuild "1.1.7"]
                             [lein-figwheel "0.5.13"]]
                   :dependencies [[reloaded.repl "0.2.3"]]
                   :source-paths ["dev"]
                   :cljsbuild {:builds [{:id "dev-build"
                                         :source-paths ["src" "dev"]
                                         :figwheel true
                                         :compiler {:output-to "target/classes/public/app.js"
                                                    :output-dir "target/classes/public/out"
                                                    :optimizations :none
                                                    :recompile-dependents true
                                                    :source-map true
                                                    }}]}
                   :figwheel {:server-port 3500}}})
