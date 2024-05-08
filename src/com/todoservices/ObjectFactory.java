
package com.todoservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.todoservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClearTodoResponse_QNAME = new QName("http://www.todoservices.com", "clearTodoResponse");
    private final static QName _QueryTodos_QNAME = new QName("http://www.todoservices.com", "queryTodos");
    private final static QName _QueryTodosResponse_QNAME = new QName("http://www.todoservices.com", "queryTodosResponse");
    private final static QName _DeleteTodoResponse_QNAME = new QName("http://www.todoservices.com", "deleteTodoResponse");
    private final static QName _Register_QNAME = new QName("http://www.todoservices.com", "register");
    private final static QName _AddTodoResponse_QNAME = new QName("http://www.todoservices.com", "addTodoResponse");
    private final static QName _DeleteTodo_QNAME = new QName("http://www.todoservices.com", "deleteTodo");
    private final static QName _ListUsersResponse_QNAME = new QName("http://www.todoservices.com", "listUsersResponse");
    private final static QName _ListUsers_QNAME = new QName("http://www.todoservices.com", "listUsers");
    private final static QName _RegisterResponse_QNAME = new QName("http://www.todoservices.com", "registerResponse");
    private final static QName _AddTodo_QNAME = new QName("http://www.todoservices.com", "addTodo");
    private final static QName _ClearTodo_QNAME = new QName("http://www.todoservices.com", "clearTodo");
    private final static QName _Login_QNAME = new QName("http://www.todoservices.com", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://www.todoservices.com", "loginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.todoservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link ClearTodo }
     * 
     */
    public ClearTodo createClearTodo() {
        return new ClearTodo();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link AddTodo }
     * 
     */
    public AddTodo createAddTodo() {
        return new AddTodo();
    }

    /**
     * Create an instance of {@link ListUsersResponse }
     * 
     */
    public ListUsersResponse createListUsersResponse() {
        return new ListUsersResponse();
    }

    /**
     * Create an instance of {@link ListUsers }
     * 
     */
    public ListUsers createListUsers() {
        return new ListUsers();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link QueryTodos }
     * 
     */
    public QueryTodos createQueryTodos() {
        return new QueryTodos();
    }

    /**
     * Create an instance of {@link QueryTodosResponse }
     * 
     */
    public QueryTodosResponse createQueryTodosResponse() {
        return new QueryTodosResponse();
    }

    /**
     * Create an instance of {@link ClearTodoResponse }
     * 
     */
    public ClearTodoResponse createClearTodoResponse() {
        return new ClearTodoResponse();
    }

    /**
     * Create an instance of {@link DeleteTodo }
     * 
     */
    public DeleteTodo createDeleteTodo() {
        return new DeleteTodo();
    }

    /**
     * Create an instance of {@link AddTodoResponse }
     * 
     */
    public AddTodoResponse createAddTodoResponse() {
        return new AddTodoResponse();
    }

    /**
     * Create an instance of {@link DeleteTodoResponse }
     * 
     */
    public DeleteTodoResponse createDeleteTodoResponse() {
        return new DeleteTodoResponse();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearTodoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "clearTodoResponse")
    public JAXBElement<ClearTodoResponse> createClearTodoResponse(ClearTodoResponse value) {
        return new JAXBElement<ClearTodoResponse>(_ClearTodoResponse_QNAME, ClearTodoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryTodos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "queryTodos")
    public JAXBElement<QueryTodos> createQueryTodos(QueryTodos value) {
        return new JAXBElement<QueryTodos>(_QueryTodos_QNAME, QueryTodos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryTodosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "queryTodosResponse")
    public JAXBElement<QueryTodosResponse> createQueryTodosResponse(QueryTodosResponse value) {
        return new JAXBElement<QueryTodosResponse>(_QueryTodosResponse_QNAME, QueryTodosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTodoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "deleteTodoResponse")
    public JAXBElement<DeleteTodoResponse> createDeleteTodoResponse(DeleteTodoResponse value) {
        return new JAXBElement<DeleteTodoResponse>(_DeleteTodoResponse_QNAME, DeleteTodoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTodoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "addTodoResponse")
    public JAXBElement<AddTodoResponse> createAddTodoResponse(AddTodoResponse value) {
        return new JAXBElement<AddTodoResponse>(_AddTodoResponse_QNAME, AddTodoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "deleteTodo")
    public JAXBElement<DeleteTodo> createDeleteTodo(DeleteTodo value) {
        return new JAXBElement<DeleteTodo>(_DeleteTodo_QNAME, DeleteTodo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "listUsersResponse")
    public JAXBElement<ListUsersResponse> createListUsersResponse(ListUsersResponse value) {
        return new JAXBElement<ListUsersResponse>(_ListUsersResponse_QNAME, ListUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "listUsers")
    public JAXBElement<ListUsers> createListUsers(ListUsers value) {
        return new JAXBElement<ListUsers>(_ListUsers_QNAME, ListUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "addTodo")
    public JAXBElement<AddTodo> createAddTodo(AddTodo value) {
        return new JAXBElement<AddTodo>(_AddTodo_QNAME, AddTodo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearTodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "clearTodo")
    public JAXBElement<ClearTodo> createClearTodo(ClearTodo value) {
        return new JAXBElement<ClearTodo>(_ClearTodo_QNAME, ClearTodo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.todoservices.com", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

}
