scala
=====

Tooling around with Scala while reading "Programming in Scala" 2nd Ed.

I added some stuff to calculate mortgage values and run from a single jar.
Try these commands from the project root directory:

$ mvn package
$ java -jar target/scala-jar-with-dependencies.jar \
  --mode mortgage_calculator \
  --price 195000 \
  --percentDown 20 \
  --monthlyMaintenanceFee 410 \
  --monthlyRealEstateTax 100 \
  --term 30 \
  --rate 5

Stuff I added for calculating how much I need to move:

$ mvn package
$ java -jar target/scala-jar-with-dependencies.jar \
  --mode rent_calculator \
  -rent 500 \
  -biweeklyIncome 1000 \
  -feeRate 15
