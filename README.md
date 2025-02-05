# Seminar Project

The mstocklib is an Android-based application integrated with an API service designed to manage and manipulate stock-related data. Users can interact with the app to search, view stock prices, analyze candlestick charts, and fetch company information. The project consists of two main components:


## The Mstocklib Android Application
A mobile app that communicates with the StockAPI to provide functionalities such as searching stocks by ticker, displaying candlestick charts, and retrieving historical data.

## The StockAPI
A backend service built using Node.js and MongoDB to store, retrieve, and manipulate stock data.

The API supports operations such as:

Searching stocks by ticker symbol
Fetching historical stock data
Retrieving company information (e.g., name, description, and logo)
Displaying candlestick charts for stock price movements
This is a full-stack application combining a Node.js API backend, MongoDB database, and an Android native application.


## Project Overview

This project consists of three main components:

A RESTful API built with Node.js
Database management with MongoDB
Android native application (Java)


## Tech Stack

### Backend
- Node.js
- MongoDB Atlas
- Render (Deployment)

### Frontend/Mobile
- Android Studio
- Java
- Android SDK

## Installation & Setup

### Prerequisites
- Node.js
- MongoDB Atlas
- Android Studio
- VS Code (or preferred IDE for JavaScript)
- Render

### MongoDB Setup

1. Install MongoDB Compass.
2. Connect to your MongoDB instance using the connection string

### Android App Setup

1. Open Android Studio
2. Open the `android` directory as a project
3. Sync Gradle files
4. Update the API base URL in `constants.java` or configuration file

## Running the Project


### Running the Android App

1. Open the project in Android Studio
2. Select your target device (emulator or physical device)
3. Click the "Run" button or press Shift + F10



4. Update the API URL in your Android application to point to the deployed Vercel URL

## API Endpoints

Document your API endpoints here. For example:

```
GET /api/items - Retrieve all items
POST /api/items - Create new item
GET /api/items/:id - Retrieve specific item
PUT /api/items/:id - Update specific item
DELETE /api/items/:id - Delete specific item
```


## License

This project is licensed under the MIT License - see the LICENSE file for details
Copyright (c) 2024 Yarin Manoah


## Contact

Amir Monayer - a.monayer17@gmail.com
Project Link: https://github.com/amiros7/StocksApp.git
