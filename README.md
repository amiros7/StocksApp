# Stock Search Library

A powerful Android library that enables users to search for stock data, view price action charts, and fetch detailed company profiles. The library provides real-time stock market insights with an intuitive UI and seamless API integration.

## Features

- Stock Search: Search for stocks by ticker symbol.
- Candlestick Chart: Display stock price movements using a candlestick chart.
- Historical Data Fetching: Retrieve historical stock data within a specified date range.
- Company Information: View company details, including description, logo, and full name.
- Customizable Time Frames: Choose between daily, weekly, and monthly price movements.
- Chart Interactions: Zoom in/out and long-press to reset the chart.

## Technology Stack

- Android 
- MPAndroidChart (for candlestick chart visualization)
- Retrofit/HttpClient (for API communication)
- MongoDB Atlas (for data persistence)
- Node.js (Backend)
- Express.js & Flask (Backend Services)

## Prerequisites

- Android Studio installed
- MongoDB Atlas or local MongoDB installation
- Node.js & npm (for backend service)
- Git (for cloning the repository)

## Installation

1. Clone the repository:
```bash
git clone https://github.com/amiros7/StocksApp.git
cd StocksApp
```
## Setup Android Project:

- Open Android Studio and load the project.

- Sync Gradle dependencies.


### POST Endpoints

- `POST /add_name` - Add a new name to the database
  ```json
  {
    "_id": "679dee78d2079d2731838bcf",
    "ticker": "MSFT",
    "date": "2025-02-01T09:50:48.864+00:00",
  }
  ```


## Error Handling

The API includes comprehensive error handling:

- 200: Successful operation
- 201: Resource created successfully
- 400: Bad request / Invalid input
- 404: Resource not found
- 500: Server error

## Deployment

This project supports deployment on Render.


## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Support

For support, please open an issue in the GitHub repository.

## Contact

Amir Monayer | a.monayer17@gmail.com
