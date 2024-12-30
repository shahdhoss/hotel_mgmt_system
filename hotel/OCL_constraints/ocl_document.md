## OCL Constraints for Hotel Management System

### 1. Valid National ID Length
**Business Rule**: The length of a staff's national ID should be 14 digits

**OCL Constraint**:
   ```ocl
    context Staff 
    inv validNationalId : self.nationalId.size() = 14
```
### 2.Valid Event Time
**Business Rule**: The start date of an event should be before the start date

**OCL Constraint** 

```ocl
context Event 
inv validEventTime : self.startTime > self.endTime
```

### 3.Valid Event Duration
**Business Rule**: The start date of an event should be before the start date

**OCL Constraint** 
```
context Event 
inv validEventDuration : self.startTime < self.endTime
```

### 4.Valid Event Ticket Price 
**Business Rule**: The price of an event ticket should be more than zero

**OCL Constraint**
```
context Event 
inv validEventPrice : self.price > 0
```

### 5.Valid Room Payment
**Business Rule**: The price per night for booking a room should be more than zero

**OCL Constraint**
```
context Room 
inv validRoomPrice : self.pricePerNight > 0
```

### 6.Valid Event Description
**Business Rule**: The size of an event's description should be more than zero

**OCL Constraint**
```
context Event 
inv validEventDescription : self.description.size() > 0
```

### 7.Valid Room Description
**Business Rule**: The size of a room's description should be more than zero

**OCL Constraint**
```
context Room 
inv validRoomDescription : self.description.size() > 0
```

### 8.Valid Event Ticket Booking Quantity
**Business Rule**: The quantity for booking a ticket should be more than zero

**OCL Constraint**
```
context EventBooking 
inv validBookingQuantity : self.quantity >= 0
```



