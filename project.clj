(defproject safkalista-backend "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.12.0"]
                 [ring "1.12.2"]
                 [ring/ring-mock "0.4.0"]
                 [ring/ring-jetty-adapter "1.12.2"]
                 [compojure "1.7.1"]
                 [cheshire "5.13.0"]
                 [metosin/compojure-api "2.0.0-alpha31"]
                 [org.flywaydb/flyway-core "10.22.0"]
                 [org.flywaydb/flyway-database-postgresql "10.22.0"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [org.postgresql/postgresql "42.7.4"]
                 [com.layerware/hugsql "0.5.3"]
                 [environ "1.2.0"]
                 [ring-cors "0.1.13"]
                 [org.clojure/tools.logging "1.3.0"]
                 [try-let "1.3.1"]]
  :plugins [[lein-cljfmt "0.9.2" :exclusions [org.clojure/tools.cli]]
            [lein-kibit "0.1.8"]
            [lein-bikeshed "0.5.2"]
            [jonase/eastwood "1.4.3"]
            [lein-auto "0.1.3"]
            [lein-ancient "1.0.0-RC3"]
            [lein-cloverage "1.2.4"]
            [lein-eftest "0.6.0"]
            [lein-environ "1.2.0"]]
  :aliases {"checkall" ["do"
                        ["kibit"]
                        ["bikeshed"]
                        ["eastwood"]
                        ["cljfmt" "check"]]
            "dbmigrate" ["run" "-m" "safkalista-backend.db.migrations/migrate!"]
            "dbclean" ["run" "-m" "safkalista-backend.db.migrations/clean!"]}
  :target-path "target/%s"
  :ring {:handler safkalista-backend.core/app}
  :uberjar-name "server.jar"
  :uberjar {:ring {:handler safkalista.core/app :main safkalista-backend.core}}
  :main safkalista-backend.core
  :aot :all
  :profiles {:uberjar {:aot :all} :dev {:plugins [[lein-ring "0.12.6"]]}})
