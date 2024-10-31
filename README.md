stress test：

`# Using Apache Bench to simulate 100 concurrent requests, sending 1000 requests in total `

`ab -n 1000 -c 100 http://localhost:8080/api/incidents`



docker部署：

`docker build -t incident-app .`
`docker run -p 8080:8080 incident-app`
