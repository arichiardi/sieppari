(ns sieppari.runner
  (:require [cljs.test :as test :refer-macros [run-tests] :refer [report]]
            [figwheel.main.testing :refer-macros [run-tests-async]]
            sieppari.context-test
            sieppari.core-execute-test
            sieppari.promesa-test
            ;; cannot test promesa and native together so we test here promesa
            ;; and in self-host the native counterpart
            sieppari.native-promise-test
            ))

(enable-console-print!)

;; From https://figwheel.org/docs/testing.html

(defn -main [& args]
  (run-tests-async 10000))
