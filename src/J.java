public class J {
    stage.status = status
          if (status.isComplete) {
        stage.context["exception"] = HashMap<String, Any>().apply {
            this["details"] = HashMap<String, Any>().apply {
                this["errors"] = ArrayList<String>().apply {
                    stage.tasks.filter { t -> t.exceptionDetails.isNotEmpty() }.forEach {
                        val details = (it.exceptionDetails["exception"] as HashMap<*, *>)["details"] as HashMap<*, *>
                        this.add(it.name + ":")
                        this.add((details["error"] as String))
                        (details["errors"] as ArrayList<*>).forEach { t -> this.add(t as String) }
                    }
                }
            }
        }
    }
}
