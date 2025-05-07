# Beer Chooser Exercise

**POC:** [Maria Garavaglia](mailto:maria.renie.garavaglia@gmail.com)

This application displays a list of beers and allows users to search by name, style, or ABV. The front end uses React with Axios for the API calls, while the back end uses Java with Spring Boot.

## Building & Running

Requires Maven, Java 17+, and Node.js installed, as well as a web browser.

1. Clone this repo and `cd` into it.
2. `mvn clean install`
3. `cd backend`
4. `mvn spring-boot:run`
5. In a separate terminal:
    1. `cd beer-chooser-exercise/frontend`
    2. `npm start`
6. Open a web browser and go to `http://localhost:3000`.

## Assumptions

* I used Chrome on Windows 10 for development. I can't imagine there'd be many issues on a different OS/browser, though I can't 100% guarantee it.
* Given this is an exercise, I kept the server/client configuration very basic and assumed everything would be running locally.
* The back end currently just reads in the two JSON files on their own and stores all the data locally. A production app would store those in a database instead and keep track of that through corresponding `Repository` classes. (I did consider setting up a MongoDB instance just for the exercise...)
* I kept the UI/layout very minimal for this round, though I have plenty of ideas for future styling and usability.
