<h3># SpringBootRESTfulWebApp</h3>
<h2>Spring Boot RESTful web application that integrates with the Imgur API to manage user accounts and images</h2>

<br><br>
<h2>📁 1. Project Structure </h2><br><br> 
    
<h2> Controller </h2><br><br>
1. ImgurController.java -- for imgur api (upload,view,delete)<br>
2. SynAppController.java -- RestController (signin,signup,viewuser,viewAllUsers)<br>
3. SynAppJSPController.java -- JSP Controller with MODEL VIEW ARCHITECTURE (home.jsp,login.jsp,logout.jsp...)<br>
<h2> Service </h2><br><br>
1. ImgurService.java -- To call the feignClient services <br>
2. SynchronyService.java  -- To create,validate and retrieve user<br>
<h2> Repository </h2><br><br>
1.SynchoronyJSPRepository.java -- Crud Repository<br>
2. SynchronyRepository.java -- JPA Repository<br>
<h2> Model </h2><br><br>
1. SynchronyUser.java<br>
2.  ImagePixelData.java<br>
<h2> Client </h2><br><br>
1.ImgurFeignClient.java<br>
<h2> Response </h2><br><br>
1. UploadImageResponse.java<br>
2. ViewImageResponse.java<br>
3. DeleteImageResponse<br>
<h2> Logger </h2><br><br>
1. Logger.java<br>
 <h2> Security </h2><br><br>

1. SecurityConfig.java -- Spring Security implemented <br>
 
<b> SynchronyApplication.java</b><br><br>



<h2>👤 2. User Functionality</h2>
Register User<br>
Endpoint: POST <br><br>

http://localhost:8090/app/signup<br>
http://localhost:8090/app/signin<br>

Endpoint: GET <br><br>

http://localhost:8090/app/allusers<br>
http://localhost:8090/app/user/user123<br>

<b>Store in H2 DB</b>

Authenticate User
Basic auth via Spring Security (or implement token-based manually)

<h2>🖼️ 3. Image Functionality (Authenticated)</h2>
Upload Image<br><br>
Endpoint: POST /api/images/upload<br>

Authenticate → Call Imgur API (upload endpoint)<br>

Store image ID, deleteHash, link in H2 DB associated with the user<br>

View Images<br><br>
Endpoint: GET /api/images<br>

Fetch associated images from DB and/or Imgur<br>

Delete Image<br><br>
Endpoint: DELETE /api/images/{id}<br>

Use stored deleteHash with Imgur API to delete image<br>

<h2>🌐 4. Imgur API Integration</h2>
Use Imgur’s anonymous image upload API:

Client-ID via Authorization header (Authorization: Client-ID {clientId})<br>

Endpoints used:<br><br>

POST https://api.imgur.com/3/image – Upload<br>

DELETE https://api.imgur.com/3/image/{deleteHash} – Delete<br>

GET https://api.imgur.com/3/image/{imageId} – View (optional)<br>

<h2>🧪 5. Testing</h2>
Use JUnit5 for:<br><br>

Controller tests (with MockMvc)<br>

Service layer tests (unit)<br>

Repository tests (data integrity)<br>

