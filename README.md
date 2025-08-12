# Digital Parking System

This is a **Spring Boot-based Parking Management System** project.  
The focus of the project is on **vehicle parking and unparking functionalities**, with records stored in a database for future reference. 
It manages vehicle parking across multiple floors.
It provides REST APIs to park and unpark, and calculate total fee for vehicles based on type and duration of stay.
The login page is **non-functional** and serves as a placeholder for future development.  

**Note:** The company name used in this project, *NuCompany*, is **imaginary** and used only for demonstration purposes.

---

## Features

- Park a vehicle based on its number and type.
- Unpark a vehicle using its ticket ID.
- Calculate the total fee for vehicles based on type and duration of stay.

  ### Billing Rules
  | Vehicle Type | Rate per Hour |
  |--------------|--------------|
  | BIKE         | ₹10/hour     |
  | CAR          | ₹20/hour     |
  | TRUCK        | ₹30/hour     |
- **Minimum billing:** 1 hour (even if parked for less)
 
- View the history of all vehicles that have been parked.
- Frontend integration using HTML, CSS, and JavaScript for smooth interaction.
- DTO-based request/response handling for clean API design.

---

## Screenshots

### Login Page (Non-functional placeholder)
*The login page is for demonstration only and is not connected to any authentication system.*

<img src="readme-images/Screenshot 1.png" alt="Login Page" width="600">

---

### Park Page
*Default landing page after login where users can park their vehicles.*

<img src="readme-images/Screenshot 2.png" alt="Park Page" width="600">

---

### Park Page Alert
*Alert shown when a vehicle is successfully parked.*

<img src="readme-images/Screenshot 3.png" alt="Park Page Alert" width="600">

---

### Unpark Page
*Page to unpark vehicles using their ticket ID.*

<img src="readme-images/Screenshot 4.png" alt="Unpark Page" width="600">

---

### Unpark Page Alert
*Alert shown when a vehicle is successfully unparked.*

<img src="readme-images/Screenshot 5.png" alt="Unpark Page Alert" width="600">

---

### Vehicle Parking History
*A record of all vehicles parked, stored in the database.*

<img src="readme-images/Screenshot 6.png" alt="Parking History" width="600">

---

## Technologies Used

- **Backend:** Spring Boot, Spring Data JPA, MySQL
- **Frontend:** HTML, CSS, JavaScript
- **Build Tool:** Maven
- **Java Version:** 21

---

## How to Run

1. Clone the repository
2. Import the project into your IDE.
3. Set up the MySQL database and configure the connection in "application.properties".
4. Build and run the project using Maven or your IDE's run configuration.
5. Open index.html in a browser to access the frontend.

---

## Disclaimer

This project is a demonstration product.
NuCompany is a fictional entity used solely for branding purposes in this project.
