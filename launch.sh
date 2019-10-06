# Stop and Launch Apache ActiveMQ
cd apache-activemq-5.15.10
./bin/activemq stop
echo 'Stopped activemq'
./bin/activemq start
cd ..

# Compile and Build Project with testcases
mvn clean install

# Run Application
cd target
java -jar items-0.0.1-SNAPSHOT.jar
