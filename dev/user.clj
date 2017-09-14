(ns user
  (:require reloaded.repl
            undead.system))

;; notice the var quote so the start server has always a fresh definition
(reloaded.repl/set-init! #'undead.system/create-system)
