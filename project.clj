(defproject naubay "0.1.0-SNAPSHOT"
  :description "Trying to win a hackathon"
  :url "https://naubay.com/"
  :license {:name "EPL-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [
                 [org.clojure/clojure "1.11.1"]
                 [org.clojure/data.json "2.4.0"]
                 [compojure "1.7.0"]
                 [mount "0.1.17"]
                 [com.novemberain/monger "3.6.0"]
                 [http-kit/http-kit "2.7.0"]]
  :main naubay.core
  :min-lein-version "2.10.0"
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
