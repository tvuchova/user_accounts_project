

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

<br>
If some test data are needed to be inserted(or will be inserted when pressed button Add)<br>
db.accounts.insertMany([
  {
    "id"        :1001,
    "firstName" : "Spot",
    "lastName" : "Bulk",
    "email" : "aaa@aaaa.com",
	 "birthDate" : new Date(Date.now())
  },
  {
     "id"        :1002,
    "firstName" : "Spot",
    "lastName" : "Bulk",
    "email" : "aaa@aaaa.com",
	 "birthDate" : new Date(Date.now())
  },
  {
     "id"        :1003,
    "firstName" : "Spot",
    "lastName" : "Bulk",
    "email" : "aaa@aaaa.com",
	 "birthDate" : new Date(Date.now())
  }
]);
db.accounts.find();
</pre></div>

