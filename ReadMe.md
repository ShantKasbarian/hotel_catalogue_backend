application contains the following urls:
    1 - "/register" is a post request that allows user to register password should contain at least
        one lowercase letter, one uppercase letter, one special character 
        and one number
        email should be valid
        name, lastName, email, phone number, password shall be mentioned
        returns status 201 if successful
        if unsuccessful returns 400 or 500 depending on the exception
        should be cached for 1 year
    
    2 - "/login" is a get request that allows user to login
        both email and password shall be mentioned
        returns status 200 if successful
        if unsuccessful returns 400 or 500 depending on the exception
        should be cached for 1 year

    3 - "/book" is a post request that allows user to book a room,
        if a room is already booked by another customer 
        the room cannot be booked, both user id and room id shall be mentioned
        returns status 201 if successful
        if unsuccessful returns 400 or 500 depending on the exception
        should be cached for 1 year

    4 - "/rooms" is a get request that returns all the hotel's rooms
        returns status 200 if successful
        if unsuccessful returns 400 or 500 depending on the exception
        should not be cached

    5 - "/my/rooms" is a get request that returns all rooms booked by user,
        user id shall be mentioned
        returns status 201 if successful
        if unsuccessful returns 400 or 500 depending on the exception
        should not be cached