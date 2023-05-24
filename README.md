# temperature-finder

### Java to consumes OpenWeather API's

API developed for consumption of OpenWeather API's to search weather infos. Made for study and practice purposes! And of
course, to help me with daily research! [Dockerhub](https://hub.docker.com/r/weversonlemos/temperature-finder)

## Requirements

1. [Docker](https://docs.docker.com/engine/install/)
2. [Docker-compose](https://docs.docker.com/compose/)
3. To use, a API Key provided by OpenWeather is required to consume
   APIs.  [Follow this step by step.](https://openweathermap.org/api/one-call-3) or check
   the [documentation about](https://openweathermap.org/appid)

4. When running the API, be sure to export your environment variable with the API KEY, or change the source code for
   that. An example of exporting the API KEY and executing the project on your shell would be:

        export API_KEY=ABCDEFG
        mvn spring-boot:run 

## Get Started

### Running the application with docker-compose

1. Clone the repository or download the source code

        git clone https://github.com/WeversonL/temperature-finder.git
        cd temperature-finder

2. In the docker-compose file, there are two environment variables [API_KEY_TEMPERATURE, API_KEY_GEOCODE]. As stated
   above, export these variables to run compose

        export API_KEY_TEMPERATURE=ABCDEFG
        export API_KEY_GEOCODE=ABCDEFG

3. Start with docker-compose

        docker-compose up -d

4. To obtain the temperature of an address, below is an example curl. The string need not be coded for the search, the
   program is already in charge of doing this

        curl --location 'http://localhost:8081/temperature/find?address=Morumbi%2C%20S%C3%A3o%20Paulo'

### Running the application with Docker

1. Clone the image

        docker pull weversonlemos/temperature-finder:latest

2. Create docker network

        docker network create ct-apis

3. [Follow the steps in this repository](https://github.com/WeversonL/geocode-finder), as the API's were built in
   separate ways

4. Start container with image and API KEY

        docker run -p 8081:8081 --network ct-apis --name temperature-finder -e API_KEY=YOUR_API_KEY weversonlemos/temperature-finder:latest

5. To obtain the temperature of an address, below is an example curl. The string need not be coded for the search, the
   program is already in charge of doing this

        curl --location 'http://localhost:8081/temperature/find?address=Morumbi%2C%20S%C3%A3o%20Paulo'

⚠️ Still in development

## License

`temperature-finder` is released under the [GNU General Public License, Version 2](LICENSE)

        Copyright (C) 2022 Weverson Lemos

        This program is free software; you can redistribute it and/or
        modify it under the terms of the GNU General Public License
        as published by the Free Software Foundation; either version 2
        of the License, or (at your option) any later version
