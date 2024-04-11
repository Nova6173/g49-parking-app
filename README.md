# Parking APP based on OOP concepts

## ParkingSpot
- Represents an **individual parking spot** within a parking lot or parking area.
- **Attributes**:
  - `spotNumber: int` The identifier for the parking spot.
  - `occupied: boolean` Indicates whether the spot is occupied.

### Vehicle
- Represents a vehicle that can be parked in a parking spot.
- **Attributes**:
- `LicensePlate: string` The license plate number of the vehicle.
- `vehicleType: string` The type of the vehicle (e.g., car, motorcycle, truck).

#### Customer
- Represents a customer who can make reservations for parking spots.
- **Attributes**:
- `name: string` The name of the customer.
- `id: int` The identifier for the customer.


##### Reservation
- Represents a reservation made by a customer for a parking spot.
- **Attributes**:
- `customer:` Customer The customer making the reservation.
- `parkingSpot: `ParkingSpot The parking spot being reserved.
- `startTime:` datetime The start time of the reservation.
- `endTime:` datetime The end time of the reservation.






## Domain Model
![domain model](img/domain-model.jpeg)

## Class Diagram
![class model](img/class-diagram.jpeg)
