scala
=====

Tooling around with Scala while reading "Programming in Scala" 2nd Ed.

I added some stuff to calculate mortgage values and run from a single jar.
Try these commands from the project root directory:

$ mvn package
$ java -jar target/scala-jar-with-dependencies.jar \
  --price 195000 \
  --percentDown 20 \
  --monthlyMaintenanceFee 410 \
  --monthlyRealEstateTax 100 \
  --term 30 \
  --rate 5
