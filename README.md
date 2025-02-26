RESTAURANT CHAIN MANAGEMENT AND BOOKING SYSTEM

ESII-EAT is a chain of restaurants spread throughout the city and wants to manage reservations for June 25, the day of multiple end-of-course dinners. For this purpose, a booking system is to be developed that allows comprehensive management, so that when a booking cannot be made at a restaurant, another one with available space is suggested.

Each restaurant in the chain has an identifier, from 1 to 5, so they can be easily managed with an array of Restaurant-type objects. 

A customer will request a table for a restaurant with a specific ID, and if no tables are available, the system will suggest the first restaurant with an available table, starting the search from ID+1 and starting again from the beginning after 5. If no tables are available at any restaurant, the customer will be informed. The customer can accept or reject the new restaurant proposed by the system, ending the interaction there.

Each restaurant will have a table capacity (a number between 5 and 8). Each table will be represented by a Table object, which will contain the following information:

• Table ID.

• Client name.

• Number of people at the table (from 2 to 6)

If a table is not booked, it will be a null reference. Reservations will be assigned by ID order. This table ID will range from 1 to the table capacity of the restaurant.

For example, this would be the case of a restaurant with 5 tables, 3 of which are already booked:

01 02 03 null null

If the booking is intended for more than 6 people, tables can be joined, and the corresponding tables will be occupied in the array. Each restaurant has 3 extra tables stored in its warehouse, which are only brought out if some table needs to be joined to another but there are not enough free tables in the dining room. 

These free tables are not brought out if a single table is requested and the restaurant is full. When tables are taken out of the warehouse, the array of tables must be expanded accordingly.
