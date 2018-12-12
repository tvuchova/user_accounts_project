

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
db.accounts.insertMany([
  {
    "_id"        :1001,
    "firstName" : "Spot",
    "lastName" : "Bulk",
    "email" : "spot@aaaa.com",
	 "birthDate" : new Date(Date.now())
  },
  {
     "_id"        :1002,
    "firstName" : "Ivan",
    "lastName" : "Milanov",
    "email" : "ivan@aaaa.com",
	 "birthDate" : new Date(Date.now())
  },
  {
     "_id"        :1003,
    "firstName" : "Stoqn",
    "lastName" : "Petrov",
    "email" : "stoqn@aaaa.com",
	 "birthDate" : new Date(Date.now())
  }
]);
db.accounts.find();
</pre></div>

