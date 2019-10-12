# safkalista-backend

This is the backend for "Safkalista" - an app that allows you to create your own weeks menu. 


## Installation and running
Clone this repo, set your database configuration in configuration/default.edn and run the server with
  
```
    $ lein ring server
    
```
Swagger site should open in http://localhost:3000/index.html
Alternatively, you can also do:

```
    $ lein uberjar
    $ java -jar safkalista-backend-0.1.0-standalone.jar
```
## License


Copyright © 2019 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
