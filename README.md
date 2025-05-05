# SpringBootRESTfulWebApp
Spring Boot RESTful web application that integrates with the Imgur API to manage user accounts and images 

1. Project Setup
Tech Stack:

Spring Boot 3.x.x

Java 17

H2 (in-memory DB)

Spring Data JPA

Spring Security (optional for basic auth or OAuth2)

Feign/RestTemplate for Imgur API

JUnit 5 for testing

Logging via SLF4J / Logback

Maven or Gradle

📁 2. Project Structure
arduino
Copy
Edit
com.example.synchrony
├── controller
│   └── UserController.java
│   └── ImageController.java
├── service
│   └── UserService.java
│   └── ImageService.java
├── repository
│   └── UserRepository.java
│   └── ImageRepository.java
├── model
│   └── User.java
│   └── Image.java
├── config
│   └── ImgurClientConfig.java
│   └── SecurityConfig.java (optional)
├── dto
│   └── UserDto.java
│   └── ImageDto.java
├── util
│   └── ImgurApiClient.java
└── SynchronyApplication.java
👤 3. User Functionality
Register User
Endpoint: POST /api/users/register

Data: username, password, basic info

Store in H2 DB (password should be hashed if security is enabled)

Authenticate User
Basic auth via Spring Security (or implement token-based manually)

🖼️ 4. Image Functionality (Authenticated)
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

🌐 5. Imgur API Integration
Use Imgur’s anonymous image upload API:

Client-ID via Authorization header (Authorization: Client-ID {clientId})

Endpoints used:

POST https://api.imgur.com/3/image – Upload

DELETE https://api.imgur.com/3/image/{deleteHash} – Delete

GET https://api.imgur.com/3/image/{imageId} – View (optional)

🔐 6. Security (Optional)
Add Basic Auth or OAuth2 using Spring Security

Store credentials securely (e.g., encoded passwords)

🧪 7. Testing
Use JUnit5 for:

Controller tests (with MockMvc)

Service layer tests (unit)

Repository tests (data integrity)

Optional: Follow TDD

