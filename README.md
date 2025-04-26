## Microservice
- For experimenting with the `RequestDetailsController`, you can use the following curl calls:

GET Request
```bash
curl -X GET "http://localhost:8080/request-details" -H "Accept: application/json" -H "Custom-Header: customValue" -G -d "param1=value1&param2=value2"

```

POST Request
```bash
curl -X POST "http://localhost:8080/request-details" -H "Content-Type: application/json" -H "Custom-Header: customValue" -d '{"key":"value"}'

```

PUT Request: The PUT method is used to update a resource or create a resource if it does not exist. It is typically used for full updates.
When you send a PUT request, you are sending a complete representation of the resource. The server will replace the existing resource with the new data provided in the request.
PUT requests are idempotent, meaning that making the same PUT request multiple times will have the same effect as making it once. The resource will be updated to the same state each time.

For example, If you have a user profile resource, a PUT request might look like this:
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "age": 30
}
```

Sending this PUT request will update the entire user profile with the provided data.

```bash
curl -X PUT "http://localhost:8080/request-details" -H "Content-Type: application/json" -H "Custom-Header: customValue" -d '{"key":"value"}'

```

DELETE Request
```bash
curl -X DELETE "http://localhost:8080/request-details" -H "Accept: application/json" -H "Custom-Header: customValue" -G -d "param1=value1&param2=value2"

```

PATCH Request
Purpose: The PATCH method is used to apply partial modifications to a resource. It is typically used for partial updates.
Behavior: When you send a PATCH request, you are sending only the changes you want to make to the resource. The server will update the resource with the provided data without affecting other parts of the resource.
Idempotency: PATCH requests are not necessarily idempotent. Making the same PATCH request multiple times may result in different states if the changes depend on the current state of the resource.
Example: If you want to update only the email of a user profile, a PATCH request might look like this:

```json
{
  "email": "new.email@example.com"
}
```

Sending this PATCH request will update only the email field of the user profile, leaving other fields unchanged.

```bash
curl -X PATCH "http://localhost:8080/request-details" -H "Content-Type: application/json" -H "Custom-Header: customValue" -d '{"key":"value"}'

```

OPTIONS Request
```bash
curl -X OPTIONS "http://localhost:8080/request-details" -H "Custom-Header: customValue"

```

HEAD Request
```bash
curl -I "http://localhost:8080/request-details" -H "Custom-Header: customValue"

```

TRACE Request
```bash
curl -X TRACE "http://localhost:8080/request-details" -H "Custom-Header: customValue"

```
