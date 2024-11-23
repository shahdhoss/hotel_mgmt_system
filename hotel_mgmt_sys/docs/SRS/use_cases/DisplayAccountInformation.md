### Use Case Name:
    Display Account Information
### Actors:
    Staff Members
    Customers
### Stakeholders:
    Hotel Management
    Staff Members
    Customers
### Pre-conditions:
    The user must be logged into the system.
    The user has appropriate access rights to view the account information.
### Post-conditions:
    The user can successfully view their account details, including personal information, paycheck history (for staff), reservations, and other applicable data.
    Managers can view staff information and manage their roles, paychecks, and time-off requests.
### Main Scenarios:
    1. The user selects the "Account" option from the dashboard.
        a. For Customers:
            The system displays personal details such as name, email, and history of reservations made.
        b. For Staff Members (Front Desk, Housekeeping):
            The system displays:
            Personal information (name, email, employment start date).
            Paycheck information, including the paycheck amount, issue date, and a history of past paychecks.
            Employment details (start date and dismissal date, if applicable).
        
### Alternate Scenarios:
    1a. A newly hired staff member views their account before receiving any paychecks.
        System Action: The system displays a message indicating no paycheck records are available.
    
    1b. A staff member's account has no dismissal date.
        System Action: The system leaves the dismissal date field blank or displays "N/A" for active employees.


