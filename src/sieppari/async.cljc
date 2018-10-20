(ns sieppari.async
  #?(:clj (:refer-clojure :exclude [await])))

(defprotocol AsyncContext
  (async? [t])
  (continue [t f])
  #?(:clj (await [t])))

#?(:clj
   (extend-protocol AsyncContext
     clojure.lang.IDeref
     (async? [_] true)
     (continue [c f] (let [p (promise)]
                       (future (p (f @c)))
                       p))
     (await [c] @c)))

#?(:cljs
   (extend-protocol AsyncContext
     js/Promise
     (async? [_] true)
     (continue [t f] (.then t f))))
