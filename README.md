# AWS EC2 Products/Pricing Explorer

## Overview

This repository contains the backend code for the AWS Elastic Compute Cloud (EC2) Products/Pricing Explorer service. This service integrates various backend and frontend elements to asynchronously fetch and analyze the products and prices of the AWS EC2 service. It then stores this data in a relational database, offers backend APIs for browsing and filtering, and serves as the foundation for the React-based web console for end users.

## Features

- Asynchronously fetches and analyzes AWS EC2 service product and pricing data.
- Stores data in a relational database for efficient retrieval.
- Provides a set of backend APIs for browsing and filtering AWS EC2 services.
- Integrates with AWS Cloud services for scalability and reliability.
- Built with Java, Spring Framework, and leverages AWS services such as Amazon EC2, Lambda, Networking components (VPC, Subnets, NAT Gateway, and Availability Zones), and Amazon RDS.

# Technologies Used

- **Java**: The backend is developed using Java, a popular programming language known for its scalability and performance.

- **Spring Framework**: Spring is used to build robust and scalable applications. In this project, we utilize the Spring Framework for building RESTful APIs, managing dependencies, and configuring the application.

- **Amazon Web Services (AWS)**: AWS is the cloud infrastructure that powers this project. The following AWS services are used:
  - **Amazon EC2 Service**: This service provides scalable compute capacity in the AWS cloud.
  - **Amazon Lambda**: AWS Lambda is used for serverless execution of code in response to events, such as data updates.
  - **AWS Networking (VPC, Subnets, NAT Gateway, and AZs)**: AWS Networking components are used to create a secure and highly available network architecture.
  - **Amazon RDS**: Amazon RDS is used as a relational database service for storing and managing data efficiently.

- **Maven**: Maven is employed for building and managing project dependencies, simplifying the development process.

   For references and recommendation please contact my mentor [Hussein Elsayed](https://www.linkedin.com/in/hussein-abdelwahed/)
