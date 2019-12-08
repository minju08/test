# test
# Spring Boot, MySQL, JPA, Hibernate Rest API Tutorial

Build Restful CRUD API for a simple Note-Taking application using Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 1.8.x
2. Maven - 3.x.x
3. H2 - 1.4.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/minju08/test.git
```

**2. Load Test Data Automatically**
```bash
+ `src/main/resources/data/데이터_거래내역.csv`
+ `src/main/resources/data/데이터_계좌정보.csv`
+ `src/main/resources/data/데이터_관리점정보.csv` 
```
The h2 Console at <http://localhost:8080/h2-console>.

**3. Build and run the app using maven**

```bash
mvn package
java -jar target/pay-test-0.0.1-SNAPSHOT.jar
```
The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following REST APIs.

    GET /cust
        기능 : 2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API
    
    GET /cust/none
        기능 : 2018년 또는 2019년에 거래가 없는 고객을 추출하는 API
    
    GET /branch
        기능 : 연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 
    
    POST /branch
        기능 : 분당점과 판교점을 통폐합하여 판교점으로 관리점 이관을 하였습니다. 지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API
        RequestBodt : { "brName":"관리점명" }


You can test them using postman or any other rest client.

