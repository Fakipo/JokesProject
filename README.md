Follow the below steps to run this project on your system:

1) Install Docker

2) Pull the images

3) Run the containers

4) Check the endpoints


Below are the commands for it:

brew install docker         // or just download and install

Open terminal or command line

- docker pull paraskavdikar/cassandradb-image      

- docker pull paraskavdikar/joke-frontend     

- docker pull paraskavdikar/backend-dbservice     

- docker pull paraskavdikar/webservice-backend     

- docker network create mynetwork

- docker run --name cassandra-container --network mynetwork -p 9042:9042 paraskavdikar/cassandradb-image

// Open a new terminal if required.

- docker exec -it cassandra-container cqlsh -f /docker-entrypoint-initdb.d/setup.cql

- docker run -e SPRING_DATA_CASSANDRA_CONTACT_POINTS=cassandra-container -p 8081:8081 --name backenddb-container --network mynetwork -d paraskavdikar/backend-dbservice

- docker run --network mynetwork -d -p 8080:8080 paraskavdikar/webservice-backend

- docker run --network mynetwork -d -p 3000:3000 paraskavdikar/joke-frontend     
