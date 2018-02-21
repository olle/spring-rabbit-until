**WORK IN PROGRESS**

Spring Rabbit Until
===================

Extensions to Spring AMQP and RabbitMQ, that provides query/response and
responsive support to developers.

Usage example
-------------

The pointy-hair-boss says our MVP needs list of the best deals for trips to any
destinations in Spain. The problem is somebody said _microservices_ are a good
idea, and that RPC is strictly forbidden.

Don't dispair `spring-rabbit-until` to the rescue!

```java

  List<Offer> offers = new ArrayList<>();

  rabbitTemplate.sendAndReceiveUntil(
      "deals",
      "destination.spain.*",
      msg,
      UntilPredicate.with(TimeUnit.MILLISECONDS, 50),
      offers::add);

  return offers.stream()
      .filter(/* filter */)
      .sorted(/* sorting */)
      .distinct()
      .collect(Collectors.toSet());

```

The _until_ extension adds methods that allows clients to use query/response
semantics with full determinism. The example below emits a query to the `deals`
topic exchange, defining the query using the routing key `destination.spain.*`.
So any travel deals are of interest, where the destination may be any airport
in Spain.

Any responses are consumed, using a timer `UntilPredicate`, and after 50ms it
will stop, regardless of there being more responses or not.

All received `Offer`s can be aggregated by the list `add` method, as a
`Consumer<Offer>`. And any further filtering or ordering may be performed after
the complete receive operation is done.

Stay tuned...
