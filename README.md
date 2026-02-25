## Microservice


## Building and Running the Container:
- Build a new image version:
  ```bash
  docker build -t demo-app .
  ```

- Run the image (for the first time)
  ```bash
  docker run -p 8080:8080 \
    --name my-running-app \
    -e FILE_PATH_ENVIRONMENT_VARIABLE=/in/container/file/path \
    -e MY_ENVIRONMENT_VARIABLE=vismark-file.config \
    -e application.firstName=Vismark \
    -v /Users/vismarkjuarez/documents:/in/container/file/path:ro \ # this line tells Docker to "let the container access all the contents in my computer's "/Users/vismarkjuarez/documents" directory. The container can access the directory via it's own "/in/container/file/path" OS directory, but its access should be read-only (ro)
    demo-app:latest
  ```

  If you have already previously run the image, you need to do `docker start` because `docker run` will create a new container:
  ```bash
  docker image ls
  IMAGE                                                                                                 ID             DISK USAGE   CONTENT SIZE   EXTRA
  demo-app:latest                                                                                       d83dba7aa690        712MB          218MB    U
  gcr.io/k8s-minikube/kicbase:v0.0.50                                                                   ffefe6978189       1.88GB          507MB
  gcr.io/k8s-minikube/kicbase@sha256:eb4fec00e8ad70adf8e6436f195cc429825ffb85f95afcdb5d8d9deb576f3e93   eb4fec00e8ad       1.88GB          507MB    U
  ...
  vismarkjuarez@Vismarks-MacBook-Air  % docker start -a my-running-app
  ```

  If you want to pass in new environment variables and configs, you actually need to delete the old container and re-create it with your new desired configs, as shwon below:
  ```bash
  # 1. Remove the existing container (stops it and clears the name)
  docker rm -f my-running-app

  # 2. Run a brand new container with your NEW values
  docker run -p 8080:8080 \
    --name my-running-app \
    -e application.firstName=NewValue \
    -e NEW_ENV_VAR=something_else \
    -v /Users/vismarkjuarez/documents:/new/container/path \
    demo-app:latest
  ```

- For viewing the application's dynamically-configured environment variables, and volume mount contents, execute the following curl call:
  ```bash
  curl localhost:8080/config
  ```


- For experimenting with the `RequestDetailsController`, you can use the following curl calls:

GET Request
```bash
curl -X GET "http://localhost:8080/request-details" -H "Accept: application/json" -H "Custom-Header: customValue" -G -d "param1=value1&param2=value2"

```

POST Request
```bash
curl -X POST "http://localhost:8080/request-details" -H "Content-Type: application/json" -H "Custom-Header: customValue" -d '{"key":"value"}'

```

PUT Request: 

The PUT method is used to update a resource or create a resource if it does not exist. It is typically used for full updates.
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

Purpose: The OPTIONS method is used to describe the communication options for the target resource. It allows the client to determine the capabilities of the server or the resource.
Behavior: When a client sends an OPTIONS request, the server responds with the allowed HTTP methods for the specified resource. This can include methods like GET, POST, PUT, DELETE, etc.
Use Case: It is often used in CORS (Cross-Origin Resource Sharing) preflight requests to check which HTTP methods and headers are allowed when making cross-origin requests.

Example: An OPTIONS request to /request-details might return:

```json
HTTP/1.1 200 OK
Allow: GET, POST, PUT, DELETE, PATCH, OPTIONS, HEAD, TRACE
```
```bash
curl -X OPTIONS "http://localhost:8080/request-details" -H "Custom-Header: customValue"

```

HEAD Request

Purpose: The HEAD method is used to retrieve the headers of a resource without fetching the actual body. It is similar to a GET request but does not return the response body.
Behavior: When a client sends a HEAD request, the server responds with the headers that would be sent if the resource were requested with a GET method.
Use Case: It is useful for checking the metadata of a resource, such as content type, content length, and last modified date, without downloading the resource itself.
Example: A HEAD request to /request-details might return:

```json

HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 1234
```

```bash
curl -I "http://localhost:8080/request-details" -H "Custom-Header: customValue"

```


TRACE Request

Purpose: The TRACE method is used for diagnostic purposes. It echoes back the received request so that the client can see what changes or additions have been made by intermediate servers.
Behavior: When a client sends a TRACE request, the server responds with the exact request message it received, including headers and body. This helps in debugging and understanding the path taken by the request.
Use Case: It is useful for debugging and testing the network path and intermediaries between the client and server.
Example: A TRACE request to /request-details might return:

```json
HTTP/1.1 200 OK
Content-Type: message/http
Content-Length: 1234

TRACE /request-details HTTP/1.1
Host: localhost:8080
Custom-Header: customValue

```

```bash
curl -X TRACE "http://localhost:8080/request-details" -H "Custom-Header: customValue"

```
