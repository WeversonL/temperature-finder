# temperature-finder

### Java to consumes OpenWeather API's

API developed for consumption of OpenWeather API's to search weather infos. Made for study and practice purposes! And of course, to help me with daily research!

## Get Started

### Setting up environment

1. To use, a API Key provided by OpenWeather is required to consume APIs.  [Follow this step by step.](https://openweathermap.org/api/one-call-3) or check the [documentation about](https://openweathermap.org/appid)

2. When running the API, be sure to export your environment variable with the Key API, or change the source code for that. An example of exporting the Key API and executing the project on your shell would be:

        export API_KEY=ABCDEFG
        mvn spring-boot:run 

3. [Follow the steps in this repository](https://github.com/WeversonL/geocode-finder), as the API's were built in separate ways

### Running the application with Docker

Make sure you have Docker installed on your machine. [Dockerhub](https://hub.docker.com/r/weversonlemos/temperature-finder)

1. Clone the image

        docker pull weversonlemos/temperature-finder:latest

2. Create docker network

        docker network create ct-apis

3. Start container with image and api key

        docker run -p 8080:8080 --network ct-apis --name temperature-finder -e API_KEY=YOUR_API_KEY weversonlemos/temperature-finder:latest

3. To obtain the temperature of an address, below is an example curl. The string need not be coded for the search, the program is already in charge of doing this

        curl --location 'http://localhost:8080/temperature/find?address=Morumbi%2C%20S%C3%A3o%20Paulo'

⚠️ Still in development

## License

`temperature-finder` is released under the [GNU General Public License, Version 2](LICENSE)
    
        Copyright (C) 2022 Weverson Lemos

        This program is free software; you can redistribute it and/or
        modify it under the terms of the GNU General Public License
        as published by the Free Software Foundation; either version 2
        of the License, or (at your option) any later version
