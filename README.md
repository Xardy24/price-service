# Price Service

A Spring Boot REST service that provides product pricing information based on date and time, implementing hexagonal architecture.

## Description

This service manages product prices for different brands, taking into account:
- Date and time of application
- Product ID
- Brand ID
- Priority rules for overlapping prices

## Technical Stack

- Java 17
- Spring Boot 3.4.1
- H2 Database
- Maven
- JUnit 5
- Spring Data JPA

## Project Structure

The project follows hexagonal architecture with the following structure:

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── bcnc/
│   │           └── price_service/
│   │               ├── domain/
│   │               ├── application/
│   │               └── infrastructure/
│   └── resources/
│       ├── application.yml
│       ├── schema.sql
│       └── data.sql
└── test/
    └── java/
        └── com/
            └── bcnc/
                └── price_service/
```

## Setup

1. Prerequisites:
    - Java 17
    - Maven

2. Clone the repository:
   ```bash
   git clone https://github.com/Xardy24/price-service.git
   cd price-service
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## API Documentation

### Get Price

Returns the applicable price for a product at a specific date and time.

**Endpoint:** `GET /api/prices`

**Query Parameters:**
- `brandId` (required): Brand identifier (e.g., 1 for ZARA)
- `productId` (required): Product identifier
- `applicationDate` (required): Date and time for price query (ISO format)

**Example Request:**
```bash
curl "http://localhost:8080/api/prices?brandId=1&productId=35455&applicationDate=2020-06-14T10:00:00"
```

**Example Response:**
```json
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 1,
    "startDate": "2020-06-14T00:00:00",
    "endDate": "2020-12-31T23:59:59",
    "price": 35.50
}
```

## Testing

The project includes integration tests for the following scenarios:

1. Request at 10:00 on day 14 for product 35455, brand 1 (ZARA)
2. Request at 16:00 on day 14 for product 35455, brand 1 (ZARA)
3. Request at 21:00 on day 14 for product 35455, brand 1 (ZARA)
4. Request at 10:00 on day 15 for product 35455, brand 1 (ZARA)
5. Request at 21:00 on day 16 for product 35455, brand 1 (ZARA)

Run the tests with:
```bash
mvn test
```

## Database

The service uses H2 in-memory database. The console is available at:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:pricedb`
- Username: `sa`
- Password: `password`

## Test Data

The initial data includes price records for:
- Brand: ZARA (ID: 1)
- Product ID: 35455
- Different price ranges and priorities

## Error Handling

- Returns 404 Not Found if no price is available for the given parameters
- Returns 400 Bad Request for invalid input parameters

## Contributing

Please follow the existing code style and include appropriate tests with any changes.

## License

MIT

The code in this repository is covered by the included license.

However, if you run this code, it may call on the OpenFin RVM or OpenFin Runtime, which are covered by OpenFin’s Developer, Community, and Enterprise licenses. You can learn more about OpenFin licensing at the links listed below or just email us at support@openfin.co with questions.

https://openfin.co/developer-agreement/
https://openfin.co/licensing/