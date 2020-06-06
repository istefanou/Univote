# Univote

A voting app for polls/petitions to be usede by students to provide an easy way to participate.

This is a demo of how the application would function. 
( The functionallity is really limited the accounts and subjects are stored in the database but the forum messages and and the polls are not 
for the demo version)

![](univote_demo.gif)

How to Run

1)Download and install wamp https://sourceforge.net/projects/wampserver/

2)Download php script https://github.com/istefanou/Univote_server

3)Open wamp installation path ->open www folder and copy the contents of step 2 in this folder

4)Run wamp

5)Left click its icon tray

6)Hover Apache

7)Click httpd.conf

8)Find the row where Listen is written and add "Listen 80" without quotes

9)Save and close

10)Left click wamp icon tray

11)Hover Apache

12)Click httpd-vhosts.conf

13)Copy the following

/# Virtual Hosts
<VirtualHost *:80>
  ServerName localhost
  ServerAlias localhost
  DocumentRoot "${INSTALL_DIR}/www"
  <Directory "${INSTALL_DIR}/www/">
    Options +Indexes +Includes +FollowSymLinks +MultiViews
    AllowOverride All
    Require all granted
  </Directory>
</VirtualHost>

Now for the Android part
14)Download Android Studio https://developer.android.com/studio

15)Download this project

16)Open it in Android Studio

17)Change this line in every java file it is found private final String serverUrl = "http://192.168.1.4/univote/index.php";
To what ip your mobile device has so that it can access your local database

18)Compile and run Android app and should get something like the gif shown
