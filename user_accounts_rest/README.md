To start the application

backend<br>
gradle bootRun


frontend<br>
npm install && npm start

On localhost:4200 you may login with user nushka/dummy

<b>MongoDB</b>
username :accountManager,password:"manager"

<div>
 use springmongodb
db.createUser(
   {
     user: "accountManager",
     pwd: "manager",
     roles: [ "readWrite", "dbAdmin" ]
   }
)
db.auth("accountManager", "manager")
</div>
