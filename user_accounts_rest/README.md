

This part is Backend <br>
to start: gradle bootRun

<b>MongoDB configs</b><br>

<b>username</b>:accountManager,<b>password:</b>manager<br>
<b>database</b> :springmongodb

<div class="highlight highlight-text-xml"><pre>
use springmongodb
db.createUser(
   {
     user: "accountManager",
     pwd: "manager",
     roles: [ "readWrite", "dbAdmin" ]
   }
)
db.auth("accountManager", "manager")


</pre></div>

