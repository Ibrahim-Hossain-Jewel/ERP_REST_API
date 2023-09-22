# Back_Image_Gallery Environment setup.
Database MySQL
schema name : storegallery
store table name : user
column list -> userid, username, email, password

image store table name : -> imagestore
column name : id, imagename, imagetitle, imagedescription, useremail.


Environment configuration
tomcat version 9
spring-boot 2.7.10

API -> Description
register -> http://localhost:8888/user/registration
login -> http://localhost:8888/user/login
To reset has three steps three API:
1. To send OTP to your email : http://localhost:8888/user/forgot
2. To verify you email address : http://localhost:8888/user/verify
3. To set new password : http://localhost:8888/user/setnewpassword


To upload user image : http://localhost:8888/user/imageinfo
To Local visitor : http://localhost:8888/all/user
For Authenticated user : http://localhost:8888/user/auth
