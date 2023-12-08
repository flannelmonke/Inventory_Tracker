# naji_ahmad_khalil_assignment4
Assignment 3? That was child's play, here in assignment 4 we're all about security. As much as we know about it that is...

Wanna check out assignment 3 and what I was working towards? Click [here](https://www.github.com/flannelmonke/naji_ahmad_khalil_assignment3)

# Like what you saw in assignment 3?
Now in assignment 4 I solved my xss issue by not inject javascript into my own website... Instead I am using a form as a search function which should've been the first approach in the first place.

There are two users and the following is the realm of the application displaying the users authorities and username.

## Realm diagram
|userA|userB|userC|
|---|---|---|
|ADMIN|SALES|ADMIN & SALES|

Not the most complex application but it is proof of concept. The only downfall is that users are added manually. So this would be a good solution for an internal web app. One that a company would use in their own LAN/WAN.

However automation for this web app shouldn't be the most complicated solution if I implemented a sign up function that adds a user to an array list which is defined in the sec_config files. I would have to look into it. As well as look into Spring mail.

# Conclusion/TLDR?
I added users and authorities to my web app that makes calls to a local database. Local database is used for developing and testing. Using a remote DB is easily configurable. This solution is  good for internal web apps, like maybe one a company would want to use in their own LAN or WAN.
