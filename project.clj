(defproject safkalista-backend "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring "1.9.0"]
                 [ring/ring-mock "0.3.2"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [cheshire "5.8.1"]
                 [metosin/compojure-api "2.0.0-alpha7"]
                 [org.flywaydb/flyway-core "5.2.4"]
                 [org.clojure/java.jdbc "0.7.9"]
                 [org.postgresql/postgresql "42.2.5"]
                 [com.layerware/hugsql "0.5.1"]
                 [environ "1.1.0"]
                 [ring-cors "0.1.13"]
                 [org.clojure/tools.logging "0.4.1"]
                 [jumblerg/ring-cors "2.0.0"]
                 [try-let "1.3.1"]]
  :plugins [[lein-cljfmt "0.6.0" :exclusions [org.clojure/tools.cli]]
            [lein-kibit "0.1.6"]
            [lein-bikeshed "0.5.2"]
            [jonase/eastwood "0.3.1"]
            [lein-auto "0.1.3"]
            [lein-ancient "0.6.15"]
            [lein-cloverage "1.0.13"]
            [lein-eftest "0.5.7"]
            [lein-environ "1.1.0"]]
  :aliases {"checkall" ["do"
                        ["kibit"]
                        ["bikeshed"]
                        ["eastwood"]
                        ["cljfmt" "check"]]
            "dbmigrate" ["run" "-m" "safkalista-backend.db.migrations/migrate!"]
            "dbclean" ["run" "-m" "safkalista-backend.db.migrations/clean!"]}
  :target-path "target/%s"
  :ring {:handler safkalista-backend.core/app :port 3001}
  :uberjar-name "server.jar"
  :profiles {:dev {:plugins [[lein-ring "0.12.5"]]}})
