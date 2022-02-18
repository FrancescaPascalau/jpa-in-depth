# jpa-in-depth

This repo serves as a playground where I can try different JPA configurations and solutions to common problems.

# ----- Some concepts covered in this JPA project -----

# H2 - DDL

- using `spring.jpa.hibernate.ddl-auto` with any property values are `none, validate, update, create, and create-drop`.
- When staring an app, Spring Boot will create an empty table, but won't populate it with anything by default.
- We can specify that we want to also populate the tables after initialization.
- In this project we created a data.sql that will be run when the application starts everytime

# CASCADE

- `CascadeType.ALL` propagates all operations from a parent to a child entity.
- `CascadeType.PERSIST` propagates the persist operation from a parent to a child entity.
- `CascadeType.MERGE` propagates the merge operation from a parent to a child entity.
- `CascadeType.REMOVE` propagates the remove operation from parent to child entity.
- `CascadeType.DETACH` the child entity will also get removed from the persistent context.
- `CascadeType.LOCK` reattaches the entity and its associated child entity with the persistent context again.
- `CascadeType.REFRESH` the child entity also gets reloaded from the database whenever the parent entity is refreshed.
- `CascadeType.REPLICATE` used when we have more than one data source and we want the data in sync.

# Custom Repository

- We can create our own custom repository if the body of the request is a custom object too. In the repo implementation
  we can define the logic that we want in order to retrieve or update the data.

# Concurrency

- Multiple threads can access same data at the same time which can cause problems.
- In order to avoid that we added `@Version` to the entities in order to provide an access rule to it based on the
  latest version.

# Transaction

- `@Transactional` - It is used to combine more than one writes on a database as a single atomic operation.
- Only public methods should be annotated with @Transactional.
- Checked Exceptions do not trigger a rollback of the transaction.
- We can configure this behavior with the `rollbackFor` and `noRollbackFor` annotation parameters.
- Spring creates a proxy, or manipulates the class byte-code, to manage the creation, commit, and rollback of the
  transaction.
- `Propagation` - defines our business logic's transaction boundary. Spring manages to start and pause a transaction
  according to our propagation setting.
- `Isolation` - is one of the common ACID properties: Atomicity, Consistency, Isolation, and Durability. Isolation
  describes how changes applied by concurrent transactions are visible to each other
- We can open transactions within other transactions