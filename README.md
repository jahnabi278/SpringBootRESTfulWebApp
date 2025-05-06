# SpringBootRESTfulWebApp
Spring Boot RESTful web application that integrates with the Imgur API to manage user accounts and images 
📁 1. Project Structure
com.synchrony.synchronyapp
├── controller
│   └── ImgurController.java -- for imgur api (upload,view,delete)
│   └── SynAppController.java -- RestController (signin,signup,viewuser,viewAllUsers)
    └── SynAppJSPController.java -- JSP Controller with MODEL VIEW ARCHITECTURE (home.jsp,login.jsp,logout.jsp...)
├── service
│   └── ImgurService.java -- To call the feignClient services 
│   └── SynchronyService.java  -- To create,validate and retrieve user
├── repository
│   └── SynchoronyJSPRepository.java -- Crud Repository
│   └── SynchronyRepository.java -- JPA Repository
├── model
│   └── SynchronyUser.java
│   └── ImagePixelData.java
├── client
│   └── ImgurFeignClient.java
├── response
│   └── UploadImageResponse.java
│   └── ViewImageResponse.java
    --- DeleteImageResponse
├── logger
│   └── Logger.java
 ---security
│   └── SecurityConfig.java -- Spring Security implemented 
└── SynchronyApplication.java

👤 2. User Functionality
Register User
Endpoint: POST 
(http://localhost:8090/app/signup)
(http://localhost:8090/app/signin)

Endpoint: GET 
http://localhost:8090/app/allusers
http://localhost:8090/app/user/user123

Store in H2 DB

Authenticate User
Basic auth via Spring Security (or implement token-based manually)

🖼️ 3. Image Functionality (Authenticated)
Upload Image
Endpoint: POST /api/images/upload

Authenticate → Call Imgur API (upload endpoint)

Store image ID, deleteHash, link in H2 DB associated with the user

View Images
Endpoint: GET /api/images

Fetch associated images from DB and/or Imgur

Delete Image
Endpoint: DELETE /api/images/{id}

Use stored deleteHash with Imgur API to delete image

🌐 4. Imgur API Integration
Use Imgur’s anonymous image upload API:

Client-ID via Authorization header (Authorization: Client-ID {clientId})

Endpoints used:

POST https://api.imgur.com/3/image – Upload

DELETE https://api.imgur.com/3/image/{deleteHash} – Delete

GET https://api.imgur.com/3/image/{imageId} – View (optional)

🧪 5. Testing
Use JUnit5 for:

Controller tests (with MockMvc)

Service layer tests (unit)

Repository tests (data integrity)

