Easier mocking of dependencies
===============================

Quickstart
----------

ComponentUnderTest creates the mocks in your tests for you! For a running example to see yourself **clone this project and launch:** 
```
src/test/java/org/kornel/testing/it/ComponentUnderTestRuleIntegrationTest.java
```

So, what is this all about?
--------------------------

Ever got tired of manually specifying mocks for your components under test? Imagine a business component:

```java
@Component
public class BusinessProcessor {

    @Inject
    private InvoiceRepository repository;
    
    @Inject
    private InvoiceValidation invoiceValidation;    
    
    public ProcessedInvoices processInvoices() throws InvoicesAlreadyProcessed {
        final Invoices invoices = repository.fetch();
        invoiceValidation.assertUnprocessed(invoices);
        return process(invoices);
    }

}
```

and a test:

```java
@RunWith(MockitoJUnitRunner.class)
public class BusinessProcessorTest {

    @InjectMocks
    private final BusinessProcessor processor = new BussinessProcessor();

    @Mock
    private InvoiceRepository repository;
    
    @Mock
    private InvoiceValidation invoiceValidation;        
    
    @Test(expect=InvoicesAlreadyProcessed.class)
    public void shouldNotProcessAlreadyProcessedInvoices() throws InvoicesAlreadyProcessed {
        // given
        given(repository.fetch()).willReturn(...)
        given(invoiceValidation.assertUnprocessed(...)).willThrow(...)
        
        // when
        processor.processInvoices()
        
        // then
        // exception        
    }
}
```

Specifing each of the mocks is a too repetitive and daunting task. Imagine the test looked as follows:

```java
public class BusinessProcessorTest extends TestBase {

    @ComponentUnderTest
    private BusinessProcessor processor;
    
    @Test(expect=InvoicesAlreadyProcessed.class)
    public void shouldNotProcessAlreadyProcessedInvoices() throws InvoicesAlreadyProcessed {
        // given
        given(processor.repository.fetch()).willReturn(...)
        given(processor.invoiceValidation.assertUnprocessed(...)).willThrow(...)
        
        // when
        processor.processInvoices()
        
        // then
        // exception        
    }
}
```

The dependencies are mocked automatically for you! This is **accomplished by**:

 - A JUnit rule which scans for a *ComponentUnderTest* object in your tests (defined in TestBase in this examples)
 - The object is then scanned for fields annotated with a specific annotation (e.g. *@Inject* or *@Autowired*)                                       
 - The fields are mocked using e.g. *Mockito.mock*                                                                                       

This approach requires the dependencies injected in your tests component to be package scope (assuming the test is in the same package as the tested component, which it should), but that does not seem as a too big sacrifice for the purpose of easier, quicker and more efficient TDD.

The package scoped dependencies allow for easier stubbing: 
```java
given(processor.repository.fetch())
```
