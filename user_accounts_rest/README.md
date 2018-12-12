To start the application

backend<br>
gradle bootRun


frontend<br>
npm install && npm start

On localhost:4200 you may login with user nushka/dummy

<b>MongoDB</b>
username :accountManager,password:"manager"

<p>
 use springmongodb<br>
 db.createUser(<br>
   {<br>
     user: "accountManager",<br>
     pwd: "manager",<br>
     roles: [ "readWrite", "dbAdmin" ]<br>
   }<br>
)<br>
db.auth("accountManager", "manager")<br>
</p>
