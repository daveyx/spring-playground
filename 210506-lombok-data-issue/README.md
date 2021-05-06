# lombok @Data issue with inheritance

Demonstrates that @Data annotation is dangerous without @EqualsAndHashCode(callSuper=true) when using inheritance

Issue can be solved globally with a lombok.config or avoiding @Data and using @Getter and @Setter