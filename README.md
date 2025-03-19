# Introduction (TLDR)
The following project is an inventory tracker that is made with Spring Boot and contains different security access. Certain users will have full CRUD permissions to products on the database. These users would generally represent some sort of internal staff that uses this software to manage a product catalog. While other users will not have full CRUD permissions and will only be allowed to read through the product catalog and perform search queries.

# Product Catalog Management Application  

## Overview  
The **Product Catalog Management Application** is a Java EE web-based solution designed to efficiently manage a company's product inventory. Developed using **Spring Boot**, this application follows the **MVC design pattern** with a **4-tier client-server architecture** and utilizes an **H2 in-memory database** for seamless data handling.  

The system enables users to perform essential product management operations such as adding, updating, deleting, and searching for products based on specific criteria. The user interface is designed with **Thymeleaf**, ensuring a dynamic and user-friendly experience. Additionally, **form binding** is utilized for structured input handling, and **Thymeleaf fragments** are incorporated for consistent footer display across all pages.  

## Features Implemented  
1. **Add Product** – Users can add a new product to the catalog by providing a **product code, brand, quantity in hand, and unit price** through a web-based form.  
2. **Edit/Update Product** – Existing product details can be modified via an update form, ensuring data accuracy.  
3. **Delete Product** – A product can be removed from the catalog, with proper confirmation prompts to prevent accidental deletions.  
4. **Search by Product Brand** – The system allows users to filter and display products based on their brand names.  
5. **Search by Quantity in Hand** – Users can retrieve a list of products whose inventory is below a specified threshold, aiding in restocking decisions.  

## Architecture  
The project adheres to the **4-tier architecture**:  
- **Presentation Layer**: Thymeleaf-based UI for user interactions.  
- **Controller Layer**: Spring Boot controllers handle HTTP requests and manage data flow.  
- **Service Layer**: Business logic for product management operations.  
- **Data Layer**: H2 in-memory database for persistent storage.  

## Technologies Used  
- **Spring Boot** (RESTful APIs, MVC framework)  
- **Thymeleaf** (Dynamic HTML templates)  
- **H2 Database** (In-memory database for lightweight storage)  
- **Spring Data JPA** (Efficient database interaction)  
- **Spring Boot DevTools** (Enhanced development experience)  
- **Eclipse IDE** (Project development and execution)  

## Application Deployment & Testing  
- The application is deployed on an **Apache Tomcat embedded server** through Spring Boot.  
- Upon launching, users can access the application via `http://localhost:<port#>/`.  
- A comprehensive test suite ensures all functionalities operate as expected.  
- **Screenshots** of application execution, including console logs and web pages, are documented for submission.  

## Conclusion  
This project successfully meets all requirements specified in **Assignment 3 of PROG32758 – Enterprise Java Development**. By implementing best coding practices and a structured design approach, the **Product Catalog Management Application** provides a robust and user-friendly solution for managing product inventories.
