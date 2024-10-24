### Use Case Name:
    Book Room

### Actors:
    Customers
### Stakeholders:
    Staff Members (Reception)
### Pre-conditions:
    The user must choose they are a customer, and that they want to book a room.
    The user must have the required information ready for registration (e.g., email, password, national ID).
### Post-conditions:
    Room is booked to the user (if available rooms were found)
#### Main Scenarios:
    1.The user chooses they're a "Customer" from the available options.
    2. The customer chooses "Book Room" option.
    3. The customer provides their personal details:
                Full Name
                Phone Number
                National ID
    4. The customer their room preferences:
                Single/Double
                AC/Fans
                Room View
                Suite/Regular
                Booking Duration
    5. The system should look for a room that matches these preferences.
    6. The customer should choose to confirm booking.
    7. The customer should provide their payment details:
                Cash/Fawry/Credit Card
    8. The system should confirm successful booking of the room.
### Alternate Scenarios:
    3a. The user enters an invalid phone number.
        - System Action: The system displays an error message prompting the user to enter a valid phone number.
    3b. The user leaves one or more required fields blank.
        - System Action: The system highlights the missing fields and prompts the user to fill them in.
        - Resolution: The user completes all required fields and resubmits.
    5e.The system returns "No matching rooms found"
        System Action: The system displays all the available rooms for the customer.
        Resolution: The user either chooses a room or declines booking
    8a.The system encounters an issue (e.g., runtime error or thown exceptions) during room booking.
        System Action: The system notifies the user of the issue and asks them to try again later.
        Resolution: The user retries after the system issue is resolved.
