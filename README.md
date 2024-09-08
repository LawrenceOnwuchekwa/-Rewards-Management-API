# Rewards Management API

The Rewards Management API is a RESTful service designed to manage user authentication, customers, and transactions for a reward-based system.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [API Endpoints](#api-endpoints)
  - [Authentication](#authentication)
  - [Customer Management](#customer-management)
  - [Transaction Management](#transaction-management)
- [Response Formats](#response-formats)
- [UUID Usage](#uuid-usage)
- [Error Handling](#error-handling)
- [Contributing](#contributing)
- [Contact](#contact)

## Getting Started

### Prerequisites

- **Java**: JDK 17
- **Maven**: To build the project
- **Spring Boot**: This project uses Spring Boot for building the API
- **Database**: A relational database, MySQL

### Installation

1. **Clone the Repository:**

    ```sh
    git clone https://github.com/LawrenceOnwuchekwa/rewards-management-api.git
    cd rewards-management-api
    ```

2. **Build the Project:**

    ```sh
    mvn clean install
    ```

3. **Run the Application:**

    ```sh
    mvn spring-boot:run
    ```

4. The API will be available at `http://localhost:8080`.

## API Endpoints

### Authentication

1. **Register a new user**

   - **URL:** `/signup`
   - **Method:** `POST`
   - **Request Body:**

     ```json
     {
       "email": "lawrencecheck@gmail.com",
       "password": "yourpassword"
     }
     ```

   - **Response:**
     - **201 Created:** Returns an `AuthenticationResponse` with a success message.

2. **Login a user**

   - **URL:** `/login`
   - **Method:** `POST`
   - **Request Body:**

     ```json
     {
       "email": "userchills@yahoo.com",
       "password": "yourpassword"
     }
     ```

   - **Response:**
     - **200 OK:** Returns an `AuthenticationResponse` with a success message and token.

### Customer Management

1. **Create a new customer**
    You must be authenticated to call this endpoint
   
   - **URL:** `/api/rewards/createuser`
   - **Method:** `POST`
   - **Request Body:**

     ```json
     {
       "total_cashback": 23.45,
       "current_balance":45.67
     }
     ```
     

   - **Response:**
     - **200 OK:** Returns a `ResponseMessage` indicating successful account creation.
     - **417 Expectation Failed:** Returns a `ResponseMessage` if account creation fails.

3. **Get customer balance**
     This is the rewards balance
    You must be authenticated to call this endpoint
   - **URL:** `/api/rewards/balance/{uuid}`
   - **Method:** `GET`
   - **Path Variable:**
     - `uuid`: Customer's unique identifier
   - **Response:**
     - **200 OK:** Returns the `Customer` object with the current balance including every other details.

### Transaction Management

1. **Make a transaction**
     Must be authenticated to call this endpoint
   - **URL:** `/api/rewards/maketransact`
   - **Method:** `POST`
   - **Request Body:**

     ```json
     {
       "amount": 100.0,
       "description": "Church offering"
     }
     ```

   - **Response:**
     - **200 OK:** Returns a `ResponseMessage` indicating a successful transaction.
     - **417 Expectation Failed:** Returns a `ResponseMessage` if there is an error in the transaction.

2. **Get transaction history**
      This is the Cashback History
       Must be authenticated to call this endpoint
   
   - **URL:** `/api/rewards/history/{uuid}`
   - **Method:** `GET`
   - **Path Variable:**
     - `uuid`: Customer's transaction unique identifier
   - **Response:**
     - **200 OK:** Returns the `Transaction` object containing the customer's transaction history.

## Response Formats

- **AuthenticationResponse:**

  ```json
  {
    "token": "jwt-token",
  }

## UUID Usage
The API uses UUIDs (Universally Unique Identifiers) instead of traditional numeric IDs for several reasons:

Enhanced Security: UUIDs are more difficult to guess or predict, providing a layer of security against enumeration attacks where attackers may try to access resources by incrementing IDs.
Decentralization: UUIDs can be generated independently of a central authority or database. This makes them ideal for distributed systems where multiple services might create records without the risk of generating duplicate IDs.
Global Uniqueness: UUIDs are guaranteed to be unique across different databases and systems, which is useful in scenarios where data may need to be merged or synchronized between multiple systems.
Scalability: UUIDs are well-suited for applications that require scalability across distributed environments, as they ensure uniqueness without needing a central coordination point.
  

## Error Handling
The API uses standard HTTP status codes to indicate the success or failure of a request:

200 OK: Successful operation
201 Created: A new resource has been created successfully
417 Expectation Failed: An error occurred during processing

## Contributing
Contributions are welcome! Please fork this repository and submit a pull request for improvements or bug fixes.

## Contact
If you have any issues or questions, please contact [lawrencecheck@gmail.com].
