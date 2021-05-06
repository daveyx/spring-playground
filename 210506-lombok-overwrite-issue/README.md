# lombok @Data issue with inheritance

Demonstrates that @Data annotation is dangerous without @EqualsAndHashCode when using inheritance

Issue can be solved globally with a lombok.config or avoid @Data and using @Getter and @Setter