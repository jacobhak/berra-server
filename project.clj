(defproject berra-server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/java.jdbc "0.4.1"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring/ring-json "0.2.0"]
                 [compojure "1.4.0"]
                 [yesql "0.5.2"]]
  :main ^:skip-aot berra-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
