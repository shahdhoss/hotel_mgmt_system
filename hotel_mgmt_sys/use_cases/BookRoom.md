### Use Case Name:
    Book Room

### Actors:
    Customers
### Stakeholders:
    Staff Members (Reception)
### Pre-conditions:
    The user must be logged into the system.
### Post-conditions:
    Room is booked to the user (if available rooms were found)
#### Main Scenarios:
    1. Visit "Book Room" Page
    2. The customer chooses their room preferences:
                Single/Double
                AC/Fans
                Room View
                Suite/Regular
                Booking Duration
    3. The system should look for a room that matches these preferences.
    4. The customer should choose to confirm booking.
    5. The customer should provide their payment details:
                Cash/Fawry/Credit Card
    6. The system should confirm successful booking of the room.
### Alternate Scenarios:
    2a. The user leaves one or more required fields blank.
        - System Action: The system highlights the missing fields and prompts the user to fill them in.
        - Resolution: The user completes all required fields and resubmits.
    3a.The system returns "No matching rooms found"
        System Action: The system displays all the available rooms for the customer.
        Resolution: The user either chooses a room or declines booking
    6a.The system encounters an issue (e.g., timeout or lost connection) during account creation.
        System Action: The system notifies the user of the issue and asks them to try again later.
        Resolution: The user retries after the connection is restored or the system issue is resolved.
