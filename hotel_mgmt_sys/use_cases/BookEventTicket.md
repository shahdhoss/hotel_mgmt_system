### Use Case Name:
    Book an Event Ticket

### Actors:
    Guests, POS
### Stakeholders:
    Staff Members (Reception)
### Pre-conditions:
    The user must be logged into the system.
    User must be a guest and already has a room in the hotel.
### Post-conditions:
    Ticket is booked to the user (if any exists)
#### Main Scenarios:
    1. Visit "Hotel Events" Page
    2. The guest views the list of events and chooses one of them.
    3. The guest clicks on "Buy Ticket".
    4. The guest should provide how many tickets they want to book and their payment details:
                Cash/Fawry/Credit Card
    5. The POS handles the payment process of the ticket.
    6. The system should confirm successful booking of the ticket/s.
### Alternate Scenarios:
    2a.The system returns "No tickets available"
        System Action: The system displays all the available events for the guest.
        Resolution: The user either chooses another event or declines
    4a. The user leaves one or more required fields blank.
        - System Action: The system highlights the missing fields and prompts the user to fill them in.
        - Resolution: The user completes all required fields and resubmits.
    5,6a.The system encounters an issue (e.g., timeout or lost connection) during account creation.
        System Action: The system notifies the user of the issue and asks them to try again later.
        Resolution: The user retries after the connection is restored or the system issue is resolved.
