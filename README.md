# Product management Application

In this repository you will find LPG - the backend Springboot application and product-manage-ui - the frontend React application.
To run this application you will need both services running side by side

## Backend

To run the backend, open up the backend project in your chosen IDE, configure it with maven.
Run the application from LPGApplication.java, it will then be accessible from `localhost:8080`

## Frontend

To run the frontend, open up the frontend project in your chosen IDE, and open a terminal in the UI directory.

Run

`yarn install`

to ensure you have all the dependencies, then run

`yarn start`

to start the application on port 3000

http://localhost:3000

## Next steps

The two applications will now be talking to each other, with the products and categories loaded in. You can use the search box to search by word and use the drop down sort to sort Alphabetically, by category and in descending size order.

Future implementation:

Currently, the backend loads the data on startup, but future implementation would include a database.

The frontend relies heavily on local state, which can result in a lot of passing up and down of props. An improvement would include adding global state management, such as Redux, to that application. If the products included images, I also would have added lazy image loading, as one of the ways to improve performance.
