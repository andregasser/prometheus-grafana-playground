# Prometheus / Grafana Playground

## Overview
This repository represents an isolated playground where you can experiment with Grafana to create visualizations and play with the PromQL query language in order to get familiar with it.

This playground consists of four Docker containers. They are described below:

### Metrics-App
This is a Spring Boot example application that exposes a fake movies API providing these endpoints:
- GET /movies: Fetch all movies in the database
- POST /movies: Insert a new movie
- DELETE /movies?id=<id>: Delete a movie by id

These endpoints return success status codes most of the time, but sometimes return an error as well. This is indented, as this will give you more interesting data in Grafana.

The endpoints can be reached via http://localhost:8080/movies from the outside. The Prometheus metrics are exported under http://localhost:8080/actuator/prometheus.

Full source code for this app is includeed.

### Prometheus
The Prometheus server. When the playground is launched, it can be accessed with http://localhost:9090. 

### Grafana
The Grafana application. You can access it via http://localhost:3000. Username is `user` and password is `test`. All the things you build in Grafana (charts, etc...) are persisted into a Docker volume. So you don't loose your work, if you restart the playground (Same applies for the Prometheus server).

### JMeter
This application is used for load testing in general. In our context, we use it to simulate users accessing the movies API. This gives us nice data we can use to create some charts and other stuff. Requests should happen endlessly.

## Running the Playground

### Prerequisites
- Docker installed on your machine
- Docker Compose installed on your machine
- This git repository checked out on your machine

## Starting Up
Run `docker-compose build && docker-compose up` from the root folder of the git repositry. The playground will be built (source code compiled, containers launched). After the build stage, JMeter will start to request the movies API. You can now go into Grafana and start playing around with it.
