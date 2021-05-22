* shows that hibernate can set an Id without a setter

# how to update an parent entity when a child is saved/updated
* with `@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)`
  https://github.com/daveyx/spring-playground/blob/LockModeType.OPTIMISTIC_FORCE_INCREMENT/210427-datatest/src/main/java/com/example/datatest/parent/ParentRepository.java
* with just setting @UpdateTimestamp annotated prop to null
