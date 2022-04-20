public class J {
    stage.status = status
          if(status.isComplete){
        stage.context["exception"]=HashMap<String, Any?>().apply{
            this["details"]= HashMap<String, Any?>().apply{
                this["errors"] = ArrayList<String>().apply{
                    stage.tasks.filter {t->t.exceptionDetails.isNotEmpty()  }.forEach{
                        val m= (it.exceptionDetails["exception"] as HashMap<String, Any>)["details"] as HashMap<String,Any>

                                this.add(it.name+":")
                        this.add((m["error"] as String))
                        (m["errors"] as ArrayList<String>).stream().filter { s->!s.isNullOrEmpty() }.collect(Collectors.toList()).forEach { t->this.add(t) }
                    } }}}}

}
