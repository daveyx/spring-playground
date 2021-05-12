* no DTOs
* frontend sends 1:n data in parent
* com.example.dataTest.customer.CustomerControllerSaveWithAddressIntegrationTest.neverTrustAFrontend shows that frontend can modify other relations than in db referenced parent
* com.example.dataTest.customer.CustomerServiceIntegrationTest.test_getById_LazyInitializationException shows that access to the 1:n data results in a LazyInitializationException