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

# N+1 Problem

- N+1 Problem is a performance issue in ORM that fires multiple select queries (N+1, N = nr. of records in table) for a
  single select query.
- Solutions:
    1. `@EntityGraph` - the JPA provider loads all the graph in one select query and then avoids fetching with more
       SELECT queries.
    2. Query with Fetch Join - allows associations of values to be initialized along with their parent using a single
       select.

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

# FetchType.LAZY vs. FetchType.EAGER

- Eager Loading - data initialization occurs on the spot, data associated and will store it in a memory.
- Lazy Loading - defer initialization of an object as long as it's possible, data won't be initialized and loaded into a
  memory until we make an explicit call to it.
- `fetch = FetchType.LAZY` or `fetch = FetchType.EAGER`

# DTO mapping

- Mapping entities to DTOs in order to perform business login on the objects
- Custom DTO converter or using `MapStruct` (code generator tool that simplifies the implementation of mappings and
  auto-generates converters)

# JQL (Java Query Language) and SQL

- By default, the query definition uses JQL (class definitions for fields).
- Set nativeQuery = true to enable SQL language instead of JQL.

# Pagination

- When finding all records that meet a specific criteria there can be performance issue as soon as the number of records
  increases.
- Using Pageable when can retrieve data by setting a limit on how many recorde we see at a time, by specifying the page
  number and page size.

# Soft Delete

- Performs an update process to mark some data as deleted instead of physically deleting it from a table.
- `@SQLDelete` with a where clause that updates an entity with a deleted value.
- `@Modifying` and `@Transactional` needed on repository method to perform the delete action.