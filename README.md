# Distributed Rate Limiter (Spring Boot + Redis)

A distributed API rate limiter built using **Spring Boot** and **Redis** to protect backend services from traffic spikes and abuse.

This project demonstrates how large-scale backend systems enforce request limits to maintain system stability.

---

# Tech Stack

* Java
* Spring Boot
* Redis
* Docker
* Maven

---

# Architecture

Client → Spring Boot API → RateLimiterService → Redis Counter → Allow / Reject Request

---

# Features

* Distributed rate limiting
* Redis-backed request counters
* API protection
* Docker support

---

# Running the Project

### Start Redis

docker run -p 6379:6379 redis

### Run the Spring Boot Application

./mvnw spring-boot:run

---

# Test Endpoint

http://localhost:8080/api/test?userId=1

After exceeding the request limit the API returns:

HTTP **429 Too Many Requests**

---

# Project Structure

src/main/java/com/ratelimiter

controller
service

---

# Future Improvements

* Token Bucket rate limiter
* Sliding Window algorithm
* Load testing
* API gateway integration
