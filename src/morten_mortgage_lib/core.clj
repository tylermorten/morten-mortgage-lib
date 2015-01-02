(ns morten-mortgage-lib.core)

(def WAC 3)

(defn G [] (fn [] (/ WAC 1200)))
(defn U [] (/ 1 (+ 1 ((G)))))
(defn PAY [N] (/ ((G)) (- 1 (Math/pow (U) N))))

(declare R)

(defn BAL [N n]
  (let [r (R N n)]
    (/ (- 1 (Math/pow (U) r))
       (- 1 (Math/pow (U) N)))))

(defn R [N n] (- N n))

(defn PRIN [N n]
  (let [r (R N n)]
    (/ (* ((G)) (Math/pow (U) (+ 1 r)))
       (- 1 (Math/pow (U) N)))))

(defn INT [N n]
  (let [r (R N n)]
    (/ (* ((G)) (- 1 (Math/pow (U) (+ 1 r))))
       (- 1 (Math/pow (U) N)))))

(def PRINC 149.826544)

(* PRINC (PRIN 360 360))

(defn B [N n] (* PRINC (BAL N n)))
(defn Q [N n F] (/ F (B N n)))
