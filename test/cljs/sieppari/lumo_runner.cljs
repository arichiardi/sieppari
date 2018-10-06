(ns sieppari.lumo-runner
  (:require [cljs.test :as test :refer-macros [run-tests]]
            [lumo.core :as lumo]
            sieppari.context-test
            sieppari.queue-test
            sieppari.interceptor-test
            sieppari.core-execute-test
            ;; sieppari.promesa-test ;; not self-host compatible yet
            sieppari.native-promise-test))

(enable-console-print!)

(defmethod test/report [:cljs.test/default :end-run-tests] [m]
  (when-not (test/successful? m)
    (lumo/exit 1)))

(defn -main [& args]
  (run-tests
   'sieppari.context-test
   'sieppari.queue-test
   'sieppari.interceptor-test
   'sieppari.core-execute-test
   'sieppari.native-promise-test))
