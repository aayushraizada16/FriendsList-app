# FriendsList-app

This application is based for creating freindlist.
The below mentioned tasks can be performed through this application - 

1. A user should be able to create his profile.  
2. A user should be able to add another user in his friend list. Friend list is mutual i.e if A is friend of B, then B is also friend of A. 
3. A user should be able to remove another user from his friend list. 
4. A user should be able to view his friend list. 
5. Given an input integer K, a user should be able to view all connections at distance K from him. 


### Application requirements

This project is based on Java Spring Boot, for using this application any Java Spring enabled IDE can be used. Such as - Eclipse, VS Code or IntelliJ (IntelliJ is preferred here)
For testing the API endpoints Use Postman, by running application on localhost.

#### Database 
There is no need to use any script to create a Database as I used here  Spring JPA and Apache derby. As, when we run our application in IDE, it will create driver table automatically

### API Endpoints

* `/newuser` (POST) - for creating the new users in the users table.

            Sample Input  -
            ```
            {
                    "id": 1,
                    "phone": 9560120760,
                    "name": "mama",
                    "email": "mama@gmail.com"
             }
             ```
> Note: Please enter the `id` in the contigous fashion while creating new user

* `/users` (GET) - For getting list of total number of users

* `/users/{id}`(GET) -  For getting data of specific user

> Note: Please use the `id` which was used while creating user

* `/connect?user1={id1}&user2={id2}`(GET) - For Connecting 2 users

* `/distance?user1={id1}&user2={id2}` (GET) - For Getting the distance between 2 users

* `/remove?user1={id1}&user2={id2}` (GET) - For removing the user from the freindlist

* `/myfriendlist?user1={id1}` (GET) - For getting the immediate neighbours of the userid

 
